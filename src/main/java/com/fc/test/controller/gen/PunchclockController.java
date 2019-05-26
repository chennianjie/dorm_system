package com.fc.test.controller.gen;

import com.fc.test.model.auto.Student;
import com.fc.test.model.auto.TsysUser;
import com.fc.test.service.StudentService;
import com.fc.test.util.PositionUtil;
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
import com.fc.test.model.auto.Punchclock;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.PunchclockService;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("PunchclockController")
public class PunchclockController extends BaseController{
	
	private String prefix = "admin/punchclock";
	@Autowired
	private PunchclockService punchclockService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("view")
	@RequiresPermissions("gen:punchclock:view")
    public String view(Model model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	
	@PostMapping("list")
	@RequiresPermissions("gen:punchclock:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchTxt){
		PageInfo<Punchclock> page=punchclockService.list(tablepar,searchTxt) ; 
		TableSplitResult<Punchclock> result=new TableSplitResult<Punchclock>(page.getPageNum(), page.getTotal(), page.getList()); 
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
	@RequiresPermissions("gen:punchclock:add")
	@ResponseBody
	public AjaxResult add(Punchclock punchclock,Model model){
		int b=punchclockService.insertSelective(punchclock);
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
	@RequiresPermissions("gen:punchclock:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=punchclockService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(Punchclock punchclock){
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
        mmap.put("Punchclock", punchclockService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    @RequiresPermissions("gen:punchclock:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Punchclock record)
    {
        return toAjax(punchclockService.updateByPrimaryKeySelective(record));
    }


	/**
	 *
	 * @param ipFrom3 ip地址来自第三方
	 * @param longi 经度
	 * @param lati  纬度
	 * @param request
	 * @return
	 * @throws Exception
	 */
	//上班departmentId
	@PostMapping("/punch/")
	public Object punchIn(String ipFrom3, String longi, String lati, String city, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//取得当前用户名
		TsysUser principal = (TsysUser) SecurityUtils.getSubject().getPrincipal();
		String studentId = principal.getUsername();
		//操作记录条数，初始化为0
		System.out.println("==>" + ipFrom3 + " " + longi + " " + lati + " " + city + " " + studentId);
		String resultTotal = "-1";
		HashMap<String, String> map = new HashMap<>();
		PositionUtil positionUtil = new PositionUtil();
		Double targetLon = Double.parseDouble(positionUtil.getProperties().getProperty("lonHGC"));
		Double targetLat = Double.parseDouble(positionUtil.getProperties().getProperty("latHGC"));
		System.out.println("打卡位置:" + lati + " " + longi);
		System.out.println("目标位置:" + targetLat + " " + targetLon);
		//检测是否在打卡范围内
		if (!positionUtil.checkHereYesOrNotPunch(Double.parseDouble(longi), Double.parseDouble(lati), targetLon, targetLat)) {
			map.put("result", resultTotal);
			System.out.println("不在打卡范围内");
			return error();
		}
		//获取用户IP地址
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || ip.indexOf(":") > -1) {
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				ip = null;
			}
		}
		if (ip == null) {
			ip = ipFrom3;
		}
		//获取当前操作的用户
		Student student = studentService.selectByPrimaryKey(studentId);
		//打卡控制
		Punchclock punchClock = new Punchclock();
		punchClock.setStudentNo(studentId);
		punchClock.setStudentName(student.getName());
		punchClock.setIp(ip);
		punchClock.setAddress(city);
		//先查询用户是否已经打过卡
		if (punchclockService.checkIsPunchToday(studentId)) {
			return error();
		} else {
			punchclockService.insertSelective(punchClock);
			return success();
		}
	}
}
