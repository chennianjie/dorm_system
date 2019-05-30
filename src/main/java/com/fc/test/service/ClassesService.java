package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.ClassesMapper;
import com.fc.test.model.auto.Classes;
import com.fc.test.model.auto.ClassesExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 班级Service
* @Title: ClassesService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-30 12:50:00  
 */
@Service
public class ClassesService implements BaseService<Classes, ClassesExample>{
	@Autowired
	private ClassesMapper classesMapper;
	
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Classes> list(Tablepar tablepar,String name){
	        ClassesExample testExample=new ClassesExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Classes> list= classesMapper.selectByExample(testExample);
	        PageInfo<Classes> pageInfo = new PageInfo<Classes>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		ClassesExample example=new ClassesExample();
		example.createCriteria().andIdIn(lista);
		return classesMapper.deleteByExample(example);
	}
	
	
	@Override
	public Classes selectByPrimaryKey(String id) {
		
		return classesMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Classes record) {
		return classesMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Classes record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return classesMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Classes record, ClassesExample example) {
		
		return classesMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Classes record, ClassesExample example) {
		
		return classesMapper.updateByExample(record, example);
	}

	@Override
	public List<Classes> selectByExample(ClassesExample example) {
		
		return classesMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ClassesExample example) {
		
		return classesMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ClassesExample example) {
		
		return classesMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Classes classes){

		return 0;
	}


}
