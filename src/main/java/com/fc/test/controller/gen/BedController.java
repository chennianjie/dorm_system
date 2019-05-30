package com.fc.test.controller.gen;

import com.fc.test.model.auto.BedExample;
import com.fc.test.model.auto.Student;
import com.fc.test.service.BedroomService;
import com.fc.test.service.StudentService;
import com.fc.test.util.StringUtils;
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
	@Autowired
	private BedroomService bedroomService;


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
	@GetMapping("listByBedroomId/{id}")
	@ResponseBody
	public Object listByDepartmentId(@PathVariable String id){
		BedExample bedExample = new BedExample();
		bedExample.createCriteria().andBedroomIdEqualTo(id);
		return bedService.selectByExample(bedExample);
	}
	@GetMapping("listByBedroomIdAndEmpty/{id}")
	@ResponseBody
	public Object listByBedroomIdAndEmpty(@PathVariable String id){
		BedExample bedExample = new BedExample();
		bedExample.createCriteria().andBedroomIdEqualTo(id).andEmptyIsNull();
		return bedService.selectByExample(bedExample);
	}



	/**
     * 新增    改成自选床位功能
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
		if (StringUtils.isEmpty(bed.getDepartmentId())){
			return error(300,"请选择公寓");
		}
    	if (StringUtils.isEmpty(bed.getBedroomId())){
    		return error(400,"请选择宿舍");
		}
		if (StringUtils.isEmpty(bed.getBedNum())){
			return error(500,"请选择床位");
		}
		if (StringUtils.isEmpty(bed.getStudentNo())){
			return error(600,"请选择学生");
		}
		//更新床位信息，如果以前学生有床位，则以前的床位置为空并设置新选择的床位
		String bedId = bed.getBedNum();
		Bed bed1 = new Bed();
		bed1.setId(bedId);
		bed1.setEmpty("N");
		bedService.updateByPrimaryKeySelective(bed1);
		//更新学生信息
		Student student = studentService.selectByStudentNo(bed.getStudentNo());
		student.setBedId(bedId);
		studentService.updateByPrimaryKeySelective(student);
		//更新相关宿舍信息
		bedroomService.updatePeopleCurNumWhenAssign(bed.getBedroomId());
		return success();//200
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
		//找出所有空宿舍
		List<Bed> beds = bedService.selectEmptyBed();
		//通过习惯表找出未分配宿舍的学生
		List<Student> students = studentService.findUnAssignDormStudentByHabit();
		if (beds == null || beds.size() == 0 || students.size() == 0 || students == null) {
			return success();
		}
		int size = beds.size() < students.size() ? beds.size() : students.size();
		Student student;
		Bed bed;
		for (int i = 0; i < size; i++) {
			student = students.get(i);
			bed = beds.get(i);
			student.setBedId(bed.getId());
			student.setBedNum(bed.getBedNum());
			student.setBedroomName(bed.getBedroomName());
			student.setDepartmentName(bed.getDepartmentName());
			//更新学生信息
			studentService.updateByPrimaryKeySelective(student);
			bed.setEmpty("N");
			//更新床位信息
			bedService.updateByPrimaryKeySelective(bed);
			//更新宿舍信息
			bedroomService.updatePeopleCurNumWhenAssign(bed.getBedroomId());
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
