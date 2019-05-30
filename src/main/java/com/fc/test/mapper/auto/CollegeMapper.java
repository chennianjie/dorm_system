package com.fc.test.mapper.auto;

import com.fc.test.model.auto.College;
import com.fc.test.model.auto.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 学院
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-28 21:13:54
 */
public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);
		
    College selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example); 
		
    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
  	  	
}