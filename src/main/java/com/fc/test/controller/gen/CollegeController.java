package com.fc.test.controller.gen;

import com.fc.test.model.auto.CollegeExample;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.fc.test.model.auto.College;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.CollegeService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("CollegeController")
@Api(value = "学院")
public class CollegeController extends BaseController{
	
	private String prefix = "admin/college";
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:college:view")
    public String view(Model model)
    {	
		String str="学院";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:college:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<College> page=collegeService.list(tablepar,searchTxt) ; 
		TableSplitResult<College> result=new TableSplitResult<College>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

	@PostMapping("list2")
	@ResponseBody
	public Object list2(){
		return collegeService.selectByExample(new CollegeExample());
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
	@RequiresPermissions("gen:college:add")
	@ResponseBody
	public AjaxResult add(College college,Model model){
		int b=collegeService.insertSelective(college);
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
	@RequiresPermissions("gen:college:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=collegeService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(College college){
		int b=collegeService.checkNameUnique(college);
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
        mmap.put("College", collegeService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:college:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(College record)
    {
        return toAjax(collegeService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
