package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.HabitMapper;
import com.fc.test.model.auto.Habit;
import com.fc.test.model.auto.HabitExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 个人习性Service
* @Title: HabitService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-18 20:49:11  
 */
@Service
public class HabitService implements BaseService<Habit, HabitExample>{
	@Autowired
	private HabitMapper habitMapper;
	
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Habit> list(Tablepar tablepar,String name){
	        HabitExample testExample=new HabitExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
//	        	testExample.createCriteria().andTest29Like("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Habit> list= habitMapper.selectByExample(testExample);
	        PageInfo<Habit> pageInfo = new PageInfo<Habit>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		HabitExample example=new HabitExample();
		example.createCriteria().andIdIn(lista);
		return habitMapper.deleteByExample(example);
	}
	
	
	@Override
	public Habit selectByPrimaryKey(String id) {
		
		return habitMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Habit record) {
		return habitMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Habit record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return habitMapper.insertSelective(record);
	}

	/**
	 * 按个人习惯查找所有未分配宿舍的学生
	 * @return
	 */
	/*public List<Habit> findUnAssignDormStudentByHabit(){
		HabitExample habitExample = new HabitExample();
		//student_id   区分了院系年级班级
		habitExample.setOrderByClause("student_id, sleep_quality, work_rest, smoke, eating_habits");
		habitExample.createCriteria().andStudentIdIsNull();
		return selectByExample(habitExample);


	}*/



	@Override
	public int updateByExampleSelective(Habit record, HabitExample example) {
		
		return habitMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Habit record, HabitExample example) {
		
		return habitMapper.updateByExample(record, example);
	}

	@Override
	public List<Habit> selectByExample(HabitExample example) {
		
		return habitMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(HabitExample example) {
		
		return habitMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(HabitExample example) {
		
		return habitMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Habit habit){
		HabitExample example=new HabitExample();
		example.createCriteria().andStudentIdEqualTo(habit.getStudentId());
		List<Habit> list=habitMapper.selectByExample(example);
		return list.size();
	}


}
