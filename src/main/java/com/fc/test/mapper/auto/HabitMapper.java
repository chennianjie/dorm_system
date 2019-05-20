package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Habit;
import com.fc.test.model.auto.HabitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 个人习性
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-18 20:49:11
 */
public interface HabitMapper {
    long countByExample(HabitExample example);

    int deleteByExample(HabitExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Habit record);

    int insertSelective(Habit record);

    List<Habit> selectByExample(HabitExample example);
		
    Habit selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Habit record, @Param("example") HabitExample example);

    int updateByExample(@Param("record") Habit record, @Param("example") HabitExample example); 
		
    int updateByPrimaryKeySelective(Habit record);

    int updateByPrimaryKey(Habit record);


}