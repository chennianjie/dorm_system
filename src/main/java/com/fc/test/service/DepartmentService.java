package com.fc.test.service;

import java.util.List;

import com.fc.test.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.DepartmentMapper;
import com.fc.test.model.auto.Department;
import com.fc.test.model.auto.DepartmentExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 公寓表Service
* @Title: DepartmentService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-17 12:45:19  
 */
@Service
public class DepartmentService implements BaseService<Department, DepartmentExample>{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Department> list(Tablepar tablepar,String name,String departmentType){
	        DepartmentExample testExample=new DepartmentExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andDepartmentNameLike("%"+name+"%");
	        }
	        if(StringUtils.isNotEmpty(departmentType)) {
	        	testExample.createCriteria().andDepartmentTypeEqualTo(departmentType);
			}

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Department> list= departmentMapper.selectByExample(testExample);
	        PageInfo<Department> pageInfo = new PageInfo<Department>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		DepartmentExample example=new DepartmentExample();
		example.createCriteria().andIdIn(lista);
		return departmentMapper.deleteByExample(example);
	}
	
	
	@Override
	public Department selectByPrimaryKey(String id) {
		
		return departmentMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Department record) {
		return departmentMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Department record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return departmentMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Department record, DepartmentExample example) {
		
		return departmentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Department record, DepartmentExample example) {
		
		return departmentMapper.updateByExample(record, example);
	}

	@Override
	public List<Department> selectByExample(DepartmentExample example) {
		
		return departmentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(DepartmentExample example) {
		
		return departmentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(DepartmentExample example) {
		
		return departmentMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param Department
	 * @return
	 */
	public int checkNameUnique(Department department){
		DepartmentExample example=new DepartmentExample();
		example.createCriteria().andDepartmentNameEqualTo(department.getDepartmentName());
		List<Department> list=departmentMapper.selectByExample(example);
		return list.size();
	}


}
