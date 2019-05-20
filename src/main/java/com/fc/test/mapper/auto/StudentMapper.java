package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Student;
import com.fc.test.model.auto.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 学生
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-18 21:58:42
 */
public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
		
    Student selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example); 
		
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> findUnAssignDormStudentByHabit();
}