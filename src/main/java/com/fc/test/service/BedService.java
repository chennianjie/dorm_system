package com.fc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.auto.BedMapper;
import com.fc.test.model.auto.Bed;
import com.fc.test.model.auto.BedExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;

/**
 * 床位Service
* @Title: BedService.java 
* @Package com.fc.test.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-05-19 16:11:53  
 */
@Service
public class BedService implements BaseService<Bed, BedExample>{
	@Autowired
	private BedMapper bedMapper;
	
	/**
	 * 分页查询
	 * @return
	 */
	 public PageInfo<Bed> list(Tablepar tablepar,String name){
	        BedExample testExample=new BedExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andBedNumLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<Bed> list= bedMapper.selectByExample(testExample);
	        PageInfo<Bed> pageInfo = new PageInfo<Bed>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		BedExample example=new BedExample();
		example.createCriteria().andIdIn(lista);
		return bedMapper.deleteByExample(example);
	}
	
	
	@Override
	public Bed selectByPrimaryKey(String id) {
		
		return bedMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(Bed record) {
		return bedMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Bed record) {
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
		return bedMapper.insertSelective(record);
	}

	/**
	 * 查找空寝室
	 * @return
	 */
	public List<Bed> selectEmptyBed(){
		BedExample bedExample = new BedExample();
		bedExample.createCriteria().andEmptyIsNull();
		bedExample.setOrderByClause("department_id, bedroom_name, bed_num");
		return selectByExample(bedExample);
	}
	

	
	
	

	
	@Override
	public int updateByExampleSelective(Bed record, BedExample example) {
		
		return bedMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Bed record, BedExample example) {
		
		return bedMapper.updateByExample(record, example);
	}

	@Override
	public List<Bed> selectByExample(BedExample example) {
		
		return bedMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(BedExample example) {
		
		return bedMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(BedExample example) {
		
		return bedMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @return
	 */
	public int checkNameUnique(Bed bed){
		BedExample example=new BedExample();
		example.createCriteria().andBedNumEqualTo(bed.getBedNum());
		List<Bed> list=bedMapper.selectByExample(example);
		return list.size();
	}


}
