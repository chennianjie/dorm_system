package com.fc.test.service;

import java.util.List;

import com.fc.test.model.auto.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.BedroomMapper;
import com.fc.test.model.auto.Bedroom;
import com.fc.test.model.auto.BedroomExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 寝室表Service
* @Title: BedroomService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-19 13:07:48  
 */
@Service
public class BedroomService implements BaseService<Bedroom, BedroomExample>{
	@Autowired
	private BedroomMapper bedroomMapper;
	@Autowired
	private BedService bedService;
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Bedroom> list(Tablepar tablepar,String name){
	        BedroomExample testExample=new BedroomExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andBedroomNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Bedroom> list= bedroomMapper.selectByExample(testExample);
	        PageInfo<Bedroom> pageInfo = new PageInfo<Bedroom>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		for (String id : lista) {
			bedService.deleteBybedroomId(id);
		}
		BedroomExample example=new BedroomExample();
		example.createCriteria().andIdIn(lista);
		return bedroomMapper.deleteByExample(example);
	}
	
	
	@Override
	public Bedroom selectByPrimaryKey(String id) {
		
		return bedroomMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Bedroom record) {
		return bedroomMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Bedroom record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return bedroomMapper.insertSelective(record);
	}
	
	

	

	
	
	

	
	@Override
	public int updateByExampleSelective(Bedroom record, BedroomExample example) {
		
		return bedroomMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Bedroom record, BedroomExample example) {
		
		return bedroomMapper.updateByExample(record, example);
	}

	@Override
	public List<Bedroom> selectByExample(BedroomExample example) {
		
		return bedroomMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(BedroomExample example) {
		
		return bedroomMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(BedroomExample example) {
		return bedroomMapper.deleteByExample(example);
	}

	public void updatePeopleCurNumWhenAssign(String bedroomId){
		Bedroom bedroom = selectByPrimaryKey(bedroomId);
		bedroom.setPeopleCurNum(Integer.parseInt(bedroom.getPeopleCurNum())+1+"");
		//添加一个床位信息需要
		updateByPrimaryKeySelective(bedroom);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Bedroom bedroom){
		BedroomExample example=new BedroomExample();
		example.createCriteria().andBedroomNameEqualTo(bedroom.getBedroomName());
		List<Bedroom> list=bedroomMapper.selectByExample(example);
		return list.size();
	}


}
