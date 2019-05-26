package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.PunchclockMapper;
import com.fc.test.model.auto.Punchclock;
import com.fc.test.model.auto.PunchclockExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * Service
* @Title: PunchclockService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-20 17:59:10  
 */
@Service
public class PunchclockService implements BaseService<Punchclock, PunchclockExample>{
	@Autowired
	private PunchclockMapper punchclockMapper;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Punchclock> list(Tablepar tablepar,String name){
	        PunchclockExample testExample=new PunchclockExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andStudentNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Punchclock> list= punchclockMapper.selectByExample(testExample);
	        PageInfo<Punchclock> pageInfo = new PageInfo<Punchclock>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		PunchclockExample example=new PunchclockExample();
		example.createCriteria().andIdIn(lista);
		return punchclockMapper.deleteByExample(example);
	}
	
	
	@Override
	public Punchclock selectByPrimaryKey(String id) {
		
		return punchclockMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Punchclock record) {
		return punchclockMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Punchclock record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return punchclockMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Punchclock record, PunchclockExample example) {
		
		return punchclockMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Punchclock record, PunchclockExample example) {
		
		return punchclockMapper.updateByExample(record, example);
	}

	@Override
	public List<Punchclock> selectByExample(PunchclockExample example) {
		
		return punchclockMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(PunchclockExample example) {
		
		return punchclockMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(PunchclockExample example) {
		
		return punchclockMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Punchclock punchclock){
		PunchclockExample example=new PunchclockExample();
		example.createCriteria().andIdEqualTo(punchclock.getId());
		List<Punchclock> list=punchclockMapper.selectByExample(example);
		return list.size();
	}

	/**
	 * 检查是否打过卡今天
	 * @param studentId
	 * @return
	 */
	public boolean checkIsPunchToday(String studentId) {
		return punchclockMapper.findToday(studentId) != null;
	}
}
