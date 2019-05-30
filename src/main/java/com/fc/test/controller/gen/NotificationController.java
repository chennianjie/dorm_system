package com.fc.test.controller.gen;

import com.fc.test.model.auto.TsysRole;
import com.fc.test.model.auto.TsysUser;
import com.fc.test.service.SysRoleService;
import org.apache.shiro.SecurityUtils;
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
import com.fc.test.model.auto.Notification;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.NotificationService;
import io.swagger.annotations.Api;

import java.util.List;

@Controller
@RequestMapping("NotificationController")
@Api(value = "资讯信息")
public class NotificationController extends BaseController{
	
	private String prefix = "admin/notification";
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private SysRoleService sysRoleService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:notification:view")
    public String view(Model model)
    {	
		String str="资讯信息";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:notification:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Notification> page=notificationService.list(tablepar,searchTxt) ; 
		TableSplitResult<Notification> result=new TableSplitResult<Notification>(page.getPageNum(), page.getTotal(), page.getList()); 
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
	@RequiresPermissions("gen:notification:add")
	@ResponseBody
	public AjaxResult add(Notification notification,Model model){

		TsysUser principal = (TsysUser) SecurityUtils.getSubject().getPrincipal();
		notification.setUserId(principal.getId());
		int b=notificationService.insertSelective(notification);
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
	@RequiresPermissions("gen:notification:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=notificationService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查用户
	 * @param tsysUser
	 * @return
	 */
	@PostMapping("checkNameUnique")
	@ResponseBody
	public int checkNameUnique(Notification notification){
		int b=notificationService.checkNameUnique(notification);
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
        mmap.put("Notification", notificationService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:notification:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Notification record)
    {
        return toAjax(notificationService.updateByPrimaryKeySelective(record));
    }

    
    

	
}
