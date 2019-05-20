package com.fc.test.controller.gen;

import com.fc.test.model.auto.Student;
import com.fc.test.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
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
import com.fc.test.model.auto.Bed;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.BedService;
import io.swagger.annotations.Api;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("BedController")
@Api(value = "床位")
public class BedController extends BaseController{


	private String prefix = "admin/bed";
	@Autowired
	private BedService bedService;
	@Autowired
	private StudentService studentService;


	@GetMapping("view")
	@RequiresPermissions("gen:bed:view")
    public String view(Model model)
    {	
		String str="床位";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:bed:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Bed> page=bedService.list(tablepar,searchTxt) ; 
		TableSplitResult<Bed> result=new TableSplitResult<Bed>(page.getPageNum(), page.getTotal(), page.getList()); 
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
	@RequiresPermissions("gen:bed:add")
	@ResponseBody
	public AjaxResult add(Bed bed,Model model){
		int b=bedService.insertSelective(bed);
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
	@RequiresPermissions("gen:bed:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=bedService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Bed bed){
		int b=bedService.checkNameUnique(bed);
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
        mmap.put("Bed", bedService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:bed:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bed record)
    {
        return toAjax(bedService.updateByPrimaryKeySelective(record));
    }




	/**
	 * 智能分配宿舍
	 */
	@PostMapping("/assignDorm")
	@ResponseBody
	public Object assignDorm(){
		List<Bed> beds = bedService.selectEmptyBed();
		List<Student> students = studentService.findUnAssignDormStudentByHabit();
		if (beds == null || beds.size() == 0 || students.size() == 0 || students == null) {
			return success();
		}
		int size = beds.size() < students.size() ? beds.size() : students.size();
		Student student;
		Bed bed;
		for (int i = 0; i < size; i++) {
			student = students.get(i);
			student.setBedId(beds.get(i).getId());
			studentService.updateByPrimaryKeySelective(student);
			bed = beds.get(i);
			bed.setEmpty("N");
			bedService.updateByPrimaryKeySelective(bed);
		}
		HashMap<String, Integer> map = new HashMap<>();
		map.put("unAssignStudent", studentService.findUnAssignDormStudentByHabit().size());
		map.put("unAssignBed", bedService.selectEmptyBed().size());
		System.out.println("分配宿舍完成");
		System.out.println("当前剩余未分配学生个数：" + studentService.findUnAssignDormStudentByHabit().size());
		System.out.println("当前剩余空宿舍个数：" + bedService.selectEmptyBed().size());
		return map;
	}

	
}
