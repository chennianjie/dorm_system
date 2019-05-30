package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.NotificationMapper;
import com.fc.test.model.auto.Notification;
import com.fc.test.model.auto.NotificationExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 资讯信息Service
* @Title: NotificationService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-28 16:44:25  
 */
@Service
public class NotificationService implements BaseService<Notification, NotificationExample>{
	@Autowired
	private NotificationMapper notificationMapper;
	
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Notification> list(Tablepar tablepar,String name){
	        NotificationExample testExample=new NotificationExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andContentLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Notification> list= notificationMapper.selectByExample(testExample);
	        PageInfo<Notification> pageInfo = new PageInfo<Notification>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		NotificationExample example=new NotificationExample();
		example.createCriteria().andIdIn(lista);
		return notificationMapper.deleteByExample(example);
	}
	
	
	@Override
	public Notification selectByPrimaryKey(String id) {
		
		return notificationMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Notification record) {
		return notificationMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Notification record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return notificationMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Notification record, NotificationExample example) {
		
		return notificationMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Notification record, NotificationExample example) {
		
		return notificationMapper.updateByExample(record, example);
	}

	@Override
	public List<Notification> selectByExample(NotificationExample example) {
		
		return notificationMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(NotificationExample example) {
		
		return notificationMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(NotificationExample example) {
		
		return notificationMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Notification notification){
		return 0;
	}


}
