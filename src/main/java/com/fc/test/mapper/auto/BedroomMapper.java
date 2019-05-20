package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Bedroom;
import com.fc.test.model.auto.BedroomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 寝室表
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-19 13:07:48
 */
public interface BedroomMapper {
    long countByExample(BedroomExample example);

    int deleteByExample(BedroomExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Bedroom record);

    int insertSelective(Bedroom record);

    List<Bedroom> selectByExample(BedroomExample example);
		
    Bedroom selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Bedroom record, @Param("example") BedroomExample example);

    int updateByExample(@Param("record") Bedroom record, @Param("example") BedroomExample example); 
		
    int updateByPrimaryKeySelective(Bedroom record);

    int updateByPrimaryKey(Bedroom record);
  	  	
}