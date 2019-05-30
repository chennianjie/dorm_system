package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.CollegeMapper;
import com.fc.test.model.auto.College;
import com.fc.test.model.auto.CollegeExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 学院Service
* @Title: CollegeService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-28 21:13:54  
 */
@Service
public class CollegeService implements BaseService<College, CollegeExample>{
	@Autowired
	private CollegeMapper collegeMapper;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<College> list(Tablepar tablepar,String name){
	        CollegeExample testExample=new CollegeExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<College> list= collegeMapper.selectByExample(testExample);
	        PageInfo<College> pageInfo = new PageInfo<College>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		CollegeExample example=new CollegeExample();
		example.createCriteria().andIdIn(lista);
		return collegeMapper.deleteByExample(example);
	}
	
	
	@Override
	public College selectByPrimaryKey(String id) {
		
		return collegeMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(College record) {
		return collegeMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(College record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return collegeMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(College record, CollegeExample example) {
		
		return collegeMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(College record, CollegeExample example) {
		
		return collegeMapper.updateByExample(record, example);
	}

	@Override
	public List<College> selectByExample(CollegeExample example) {
		
		return collegeMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CollegeExample example) {
		
		return collegeMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CollegeExample example) {
		
		return collegeMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(College college){

		return 0;
	}


}
