package com.fc.test.controller.gen;

import com.fc.test.model.auto.*;
import com.fc.test.service.ClassesService;
import com.fc.test.service.CollegeService;
import com.fc.test.util.StringUtils;
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
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.StudentService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("StudentController")
@Api(value = "学生")
public class StudentController extends BaseController{
	
	private String prefix = "admin/student";
	@Autowired
	private StudentService studentService;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private ClassesService classesService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:student:view")
    public String view(Model model)
    {	
		String str="学生";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:student:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt,String sex, String departmentName, String bedroomName){
		System.out.println(bedroomName);
		StudentExample testExample=new StudentExample();
		StudentExample.Criteria criteria = testExample.createCriteria();
		if(StringUtils.isNotEmpty(searchTxt)){
			criteria.andNameEqualTo(searchTxt);
		}
		if(StringUtils.isNotEmpty(sex)){
			criteria.andSexEqualTo(sex);
		}
		if(StringUtils.isNotEmpty(departmentName)){
			criteria.andDepartmentNameEqualTo(departmentName);
		}
		if(StringUtils.isNotEmpty(bedroomName)){
			criteria.andBedroomNameEqualTo(bedroomName);
		}

		PageInfo<Student> page=studentService.list(tablepar, testExample) ;
		TableSplitResult<Student> result=new TableSplitResult<Student>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

	@GetMapping("listByBedroomId")
	@ResponseBody
	public Object listNotAssignBed(){
		StudentExample studentExample = new StudentExample();
		studentExample.createCriteria().andBedIdIsNull();
		return studentService.selectByExample(studentExample);
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
	@RequiresPermissions("gen:student:add")
	@ResponseBody
	public AjaxResult add(Student student,Model model){
		College college = collegeService.selectByPrimaryKey(student.getCollegeId());
		student.setCollegeName(college.getName());
		Classes classes = classesService.selectByPrimaryKey(student.getClassesId());
		student.setClassesName(classes.getName());
		int b=studentService.insertSelective(student);
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
	@RequiresPermissions("gen:student:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=studentService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Student student){
		return 0;
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
        mmap.put("Student", studentService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:student:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student record)
    {
        return toAjax(studentService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
