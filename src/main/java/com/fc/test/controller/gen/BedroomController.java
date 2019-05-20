package com.fc.test.controller.gen;

import cn.hutool.core.util.ObjectUtil;
import com.fc.test.model.auto.Bed;
import com.fc.test.model.auto.BedroomExample;
import com.fc.test.model.auto.Department;
import com.fc.test.service.BedService;
import com.fc.test.service.DepartmentService;
import com.fc.test.util.SnowflakeIdWorker;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.fc.test.model.auto.Bedroom;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.BedroomService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("BedroomController")
@Api(value = "寝室表")
public class BedroomController extends BaseController{
	
	private String prefix = "admin/bedroom";
	@Autowired
	private BedroomService bedroomService;
	@Autowired
    private DepartmentService departmentService;
	@Autowired
    private BedService bedService;

	
	@GetMapping("view")
	@RequiresPermissions("gen:bedroom:view")
    public String view(Model model)
    {	
		String str="寝室表";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:bedroom:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Bedroom> page=bedroomService.list(tablepar,searchTxt) ; 
		TableSplitResult<Bedroom> result=new TableSplitResult<Bedroom>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}

    @GetMapping("listByDepartmentId/{id}")
    @ResponseBody
    public Object listByDepartmentId(@PathVariable String id){
        BedroomExample bedroomExample = new BedroomExample();
        bedroomExample.createCriteria().andDepartmentIdEqualTo(id);
        return bedroomService.selectByExample(bedroomExample);
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
	@RequiresPermissions("gen:bedroom:add")
	@ResponseBody
    @Transactional()
	public AjaxResult add(Bedroom bedroom,Model model){
		Department department = departmentService.selectByPrimaryKey(bedroom.getDepartmentId());
		//department非空判断
        if (ObjectUtil.isNull(department)){
            return error(500, "请选择公寓");
        }
		bedroom.setDepartmentName(department.getDepartmentName());
		int b=bedroomService.insertSelective(bedroom);
		//初始化该寝室床位
        Bed bed = new Bed();
        bed.setBedroomId(bedroom.getId());
        bed.setBedroomName(bedroom.getBedroomName());
        bed.setDepartmentId(department.getId());
        bed.setDepartmentName(department.getDepartmentName());
        for (int i = 1; i <= Integer.parseInt(bedroom.getPeopleSumNum()); i++) {
            bed.setBedNum(i+"");
            bed.setId(SnowflakeIdWorker.getUUID());
            bedService.insertSelective(bed);
        }
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
	@RequiresPermissions("gen:bedroom:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=bedroomService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Bedroom bedroom){
		int b=bedroomService.checkNameUnique(bedroom);
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
        mmap.put("Bedroom", bedroomService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:bedroom:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bedroom record)
    {
        return toAjax(bedroomService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
