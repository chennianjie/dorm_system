package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 寝室表
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-19 13:07:48
 */
public class Bedroom implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 寝室id
	 */
		private String id;
		
	/**
	 * 寝室名称
	 */
		private String bedroomName;
		
	/**
	 * 人数（几人寝）
	 */
		private String peopleSumNum;
		
	/**
	 * 所在楼层
	 */
		private String floor;
		
	/**
	 * 当前所住人数
	 */
		private String peopleCurNum;
		
	/**
	 * 是否为空
	 */
		private String empty;
		
	/**
	 * 公寓id
	 */
		private String departmentId;
		
	/**
	 * 公寓名字
	 */
		private String departmentName;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getBedroomName() {
	        return bedroomName;
	    }
	
	    public void setBedroomName(String bedroomName){
	        this.bedroomName = bedroomName == null ? null : bedroomName.trim();
	    }
			
				
		public String getPeopleSumNum() {
	        return peopleSumNum;
	    }
	
	    public void setPeopleSumNum(String peopleSumNum){
	        this.peopleSumNum = peopleSumNum == null ? null : peopleSumNum.trim();
	    }
			
				
		public String getFloor() {
	        return floor;
	    }
	
	    public void setFloor(String floor){
	        this.floor = floor == null ? null : floor.trim();
	    }
			
				
		public String getPeopleCurNum() {
	        return peopleCurNum;
	    }
	
	    public void setPeopleCurNum(String peopleCurNum){
	        this.peopleCurNum = peopleCurNum == null ? null : peopleCurNum.trim();
	    }
			
				
		public String getEmpty() {
	        return empty;
	    }
	
	    public void setEmpty(String empty){
	        this.empty = empty == null ? null : empty.trim();
	    }
			
				
		public String getDepartmentId() {
	        return departmentId;
	    }
	
	    public void setDepartmentId(String departmentId){
	        this.departmentId = departmentId == null ? null : departmentId.trim();
	    }
			
				
		public String getDepartmentName() {
	        return departmentName;
	    }
	
	    public void setDepartmentName(String departmentName){
	        this.departmentName = departmentName == null ? null : departmentName.trim();
	    }
			
			
}