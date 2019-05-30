package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 班级
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-30 12:50:00
 */
public class Classes implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
		private String id;
		
	/**
	 * 班级名称
	 */
		private String name;
		
	/**
	 * 班长姓名
	 */
		private String monitorName;
		
	/**
	 * 班长电话
	 */
		private String monitorCall;
		
	/**
	 * 学院id
	 */
		private String collegeId;
		
	/**
	 * 学院名
	 */
		private String collegeName;
		
	/**
	 * 年级
	 */
		private String grade;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getName() {
	        return name;
	    }
	
	    public void setName(String name){
	        this.name = name == null ? null : name.trim();
	    }
			
				
		public String getMonitorName() {
	        return monitorName;
	    }
	
	    public void setMonitorName(String monitorName){
	        this.monitorName = monitorName == null ? null : monitorName.trim();
	    }
			
				
		public String getMonitorCall() {
	        return monitorCall;
	    }
	
	    public void setMonitorCall(String monitorCall){
	        this.monitorCall = monitorCall == null ? null : monitorCall.trim();
	    }
			
				
		public String getCollegeId() {
	        return collegeId;
	    }
	
	    public void setCollegeId(String collegeId){
	        this.collegeId = collegeId == null ? null : collegeId.trim();
	    }
			
				
		public String getCollegeName() {
	        return collegeName;
	    }
	
	    public void setCollegeName(String collegeName){
	        this.collegeName = collegeName == null ? null : collegeName.trim();
	    }
			
				
		public String getGrade() {
	        return grade;
	    }
	
	    public void setGrade(String grade){
	        this.grade = grade == null ? null : grade.trim();
	    }
			
			
}