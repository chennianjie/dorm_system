package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Punchclock;
import com.fc.test.model.auto.PunchclockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-20 17:59:10
 */
public interface PunchclockMapper {
    long countByExample(PunchclockExample example);

    int deleteByExample(PunchclockExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Punchclock record);

    int insertSelective(Punchclock record);

    List<Punchclock> selectByExample(PunchclockExample example);
		
    Punchclock selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Punchclock record, @Param("example") PunchclockExample example);

    int updateByExample(@Param("record") Punchclock record, @Param("example") PunchclockExample example); 
		
    int updateByPrimaryKeySelective(Punchclock record);

    int updateByPrimaryKey(Punchclock record);

    Punchclock findToday(String studentId);

}