package com.fc.test.controller.gen;

import com.fc.test.model.auto.TsysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.auto.Habit;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.HabitService;
import io.swagger.annotations.Api;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("HabitController")
@Api(value = "个人习性")
public class HabitController extends BaseController{
	
	private String prefix = "admin/habit";
	@Autowired
	private HabitService habitService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:habit:view")
    public String view(Model model)
    {	
		String str="个人习性";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:habit:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Habit> page=habitService.list(tablepar,searchTxt) ; 
		TableSplitResult<Habit> result=new TableSplitResult<Habit>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
	
	@PostMapping("add")
	@RequiresPermissions("gen:habit:add")
	@ResponseBody
	public AjaxResult add(Habit habit,Model model){
    	//取得当前用户名
		TsysUser principal = (TsysUser)SecurityUtils.getSubject().getPrincipal();
		String username = principal.getUsername();
		habit.setStudentId(username);
		int b=habitService.insertSelective(habit);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	@PostMapping("remove")
	@RequiresPermissions("gen:habit:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=habitService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查用户
	 * @return
	 */
	@PostMapping("checkNameUnique")
	@ResponseBody
	public int checkNameUnique(Habit habit){
		int b=habitService.checkNameUnique(habit);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("Habit", habitService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:habit:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Habit record)
    {
        return toAjax(habitService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
