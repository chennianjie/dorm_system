package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 床位
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-19 16:11:53
 */
public class Bed implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
		private String id;
		
	/**
	 * 床位号
	 */
		private String bedNum;
		
	/**
	 * 是否有人
	 */
		private String empty;
		
	/**
	 * 所属寝室号
	 */
		private String bedroomId;
		
	/**
	 * 寝室名
	 */
		private String bedroomName;
		
	/**
	 * 公寓id
	 */
		private String departmentId;
		
	/**
	 * 公寓名字
	 */
		private String departmentName;

		//学号  业务需要
		private String studentNo;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getBedNum() {
	        return bedNum;
	    }
	
	    public void setBedNum(String bedNum){
	        this.bedNum = bedNum == null ? null : bedNum.trim();
	    }
			
				
		public String getEmpty() {
	        return empty;
	    }
	
	    public void setEmpty(String empty){
	        this.empty = empty == null ? null : empty.trim();
	    }
			
				
		public String getBedroomId() {
	        return bedroomId;
	    }
	
	    public void setBedroomId(String bedroomId){
	        this.bedroomId = bedroomId == null ? null : bedroomId.trim();
	    }
			
				
		public String getBedroomName() {
	        return bedroomName;
	    }
	
	    public void setBedroomName(String bedroomName){
	        this.bedroomName = bedroomName == null ? null : bedroomName.trim();
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