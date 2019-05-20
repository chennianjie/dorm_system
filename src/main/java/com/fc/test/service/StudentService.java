package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.StudentMapper;
import com.fc.test.model.auto.Student;
import com.fc.test.model.auto.StudentExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 学生Service
* @Title: StudentService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-18 21:58:42  
 */
@Service
public class StudentService implements BaseService<Student, StudentExample>{
	@Autowired
	private StudentMapper studentMapper;
	
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Student> list(Tablepar tablepar,String name){
	        StudentExample testExample=new StudentExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Student> list= studentMapper.selectByExample(testExample);
	        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
	        return  pageInfo;
	 }

    /**
     * 按个人习惯查找所有未分配宿舍的学生
     * @return
     */
    public List<Student> findUnAssignDormStudentByHabit(){
        return studentMapper.findUnAssignDormStudentByHabit();
    }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		StudentExample example=new StudentExample();
		example.createCriteria().andIdIn(lista);
		return studentMapper.deleteByExample(example);
	}
	
	
	@Override
	public Student selectByPrimaryKey(String id) {
		
		return studentMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Student record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return studentMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Student record, StudentExample example) {
		
		return studentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Student record, StudentExample example) {
		
		return studentMapper.updateByExample(record, example);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		
		return studentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(StudentExample example) {
		
		return studentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(StudentExample example) {
		
		return studentMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Student student){
		StudentExample example=new StudentExample();
		example.createCriteria().andStudentNoEqualTo(student.getStudentNo());
		List<Student> list=studentMapper.selectByExample(example);
		return list.size();
	}


}
