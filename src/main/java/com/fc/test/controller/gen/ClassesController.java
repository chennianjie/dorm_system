package com.fc.test.controller.gen;

import com.fc.test.model.auto.ClassesExample;
import com.fc.test.model.auto.College;
import com.fc.test.service.CollegeService;
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
import com.fc.test.model.auto.Classes;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ClassesService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("ClassesController")
@Api(value = "班级")
public class ClassesController extends BaseController{
	
	private String prefix = "admin/classes";
	@Autowired
	private ClassesService classesService;
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:classes:view")
    public String view(Model model)
    {	
		String str="班级";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:classes:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Classes> page=classesService.list(tablepar,searchTxt) ; 
		TableSplitResult<Classes> result=new TableSplitResult<Classes>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

	@PostMapping("listByCollegeId/{id}")
	@ResponseBody
	public Object listByCollegeId(@PathVariable String id){
		ClassesExample classesExample = new ClassesExample();
		classesExample.createCriteria().andCollegeIdEqualTo(id);
		return  classesService.selectByExample(classesExample);
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
	@RequiresPermissions("gen:classes:add")
	@ResponseBody
	public AjaxResult add(Classes classes,Model model){
		College college = collegeService.selectByPrimaryKey(classes.getCollegeId());
		classes.setCollegeName(college.getName());
		int b=classesService.insertSelective(classes);
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
	@RequiresPermissions("gen:classes:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=classesService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Classes classes){
		int b=classesService.checkNameUnique(classes);
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
        mmap.put("Classes", classesService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:classes:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Classes record)
    {
        return toAjax(classesService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
