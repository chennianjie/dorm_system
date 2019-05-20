package com.fc.test.controller.gen;

import com.fc.test.model.auto.DepartmentExample;
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
import com.fc.test.model.auto.Department;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.DepartmentService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("DepartmentController")
@Api(value = "公寓表")
public class DepartmentController extends BaseController{
	
	private String prefix = "admin/department";
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:department:view")
    public String view(Model model)
    {	
		String str="公寓表";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:department:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt,String departmentType){
		System.out.println(departmentType);
		PageInfo<Department> page=departmentService.list(tablepar,searchTxt, departmentType) ;
		TableSplitResult<Department> result=new TableSplitResult<Department>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

	@PostMapping("list2")
	@ResponseBody
	public Object list2(){
		return  departmentService.selectByExample(new DepartmentExample());
	}

	@GetMapping("get/{id}")
	@ResponseBody
	public Object get(@PathVariable String id){
		return  departmentService.selectByPrimaryKey(id);
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
	@RequiresPermissions("gen:department:add")
	@ResponseBody
	public AjaxResult add(Department department,Model model){
		int b=departmentService.insertSelective(department);
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
	@RequiresPermissions("gen:department:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=departmentService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Department department){
		int b=departmentService.checkNameUnique(department);
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
        mmap.put("Department", departmentService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:department:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Department record)
    {
        return toAjax(departmentService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
