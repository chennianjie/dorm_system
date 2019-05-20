package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Department;
import com.fc.test.model.auto.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 公寓表
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-17 12:45:19
 */
public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);
		
    Department selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example); 
		
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
  	  	
}