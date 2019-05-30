package com.fc.test.mapper.auto;

import com.fc.test.model.auto.Notification;
import com.fc.test.model.auto.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 资讯信息
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-28 16:44:25
 */
public interface NotificationMapper {
    long countByExample(NotificationExample example);

    int deleteByExample(NotificationExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectByExample(NotificationExample example);
		
    Notification selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example); 
		
    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
  	  	
}