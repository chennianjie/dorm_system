package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 公寓表
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-17 12:45:19
 */
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 公寓id
	 */
		private String id;
		
	/**
	 * 公寓名
	 */
		private String departmentName;
		
	/**
	 * 公寓序号
	 */
		private Integer departmentNum;
		
	/**
	 * 楼层
	 */
		private Integer floorNum;
		
	/**
	 * 公寓类别
	 */
		private String departmentType;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getDepartmentName() {
	        return departmentName;
	    }
	
	    public void setDepartmentName(String departmentName){
	        this.departmentName = departmentName == null ? null : departmentName.trim();
	    }
			
			
		public Integer getDepartmentNum () {
	        return departmentNum;
	    }
	
	    public void setDepartmentNum (Integer departmentNum) {
	        this.departmentNum = departmentNum;
	    }
	 
			
		public Integer getFloorNum () {
	        return floorNum;
	    }
	
	    public void setFloorNum (Integer floorNum) {
	        this.floorNum = floorNum;
	    }
	 
				
		public String getDepartmentType() {
	        return departmentType;
	    }
	
	    public void setDepartmentType(String departmentType){
	        this.departmentType = departmentType == null ? null : departmentType.trim();
	    }
			
			
}