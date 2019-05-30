package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Classes;
import com.fc.test.model.auto.ClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 班级
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-30 12:50:00
 */
public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);
		
    Classes selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example); 
		
    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
  	  	
}