package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Bed;
import com.fc.test.model.auto.BedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 床位
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-19 16:11:53
 */
public interface BedMapper {
    long countByExample(BedExample example);

    int deleteByExample(BedExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Bed record);

    int insertSelective(Bed record);

    List<Bed> selectByExample(BedExample example);
		
    Bed selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Bed record, @Param("example") BedExample example);

    int updateByExample(@Param("record") Bed record, @Param("example") BedExample example); 
		
    int updateByPrimaryKeySelective(Bed record);

    int updateByPrimaryKey(Bed record);
  	  	
}