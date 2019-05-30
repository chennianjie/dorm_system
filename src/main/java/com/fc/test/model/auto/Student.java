package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 学生
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-27 16:02:58
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
		private String id;
		
	/**
	 * 学生名字
	 */
		private String name;
		
	/**
	 * 性别
	 */
		private String sex;
		
	/**
	 * 电话
	 */
		private String telNo;
		
	/**
	 * 学号
	 */
		private String studentNo;
		
	/**
	 * 学院id
	 */
		private String collegeId;
		
	/**
	 * 所属学院名
	 */
		private String collegeName;
		
	/**
	 * 班级id
	 */
		private String classesId;
		
	/**
	 * 所在班级名称
	 */
		private String classesName;
		
	/**
	 * 是否分配床位，为空表示未分配
	 */
		private String bedId;
		
	/**
	 * 
	 */
		private String bedNum;
		
	/**
	 * 
	 */
		private String bedroomName;
		
	/**
	 * 
	 */
		private String departmentName;
	
	
			
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
			
				
		public String getSex() {
	        return sex;
	    }
	
	    public void setSex(String sex){
	        this.sex = sex == null ? null : sex.trim();
	    }
			
				
		public String getTelNo() {
	        return telNo;
	    }
	
	    public void setTelNo(String telNo){
	        this.telNo = telNo == null ? null : telNo.trim();
	    }
			
				
		public String getStudentNo() {
	        return studentNo;
	    }
	
	    public void setStudentNo(String studentNo){
	        this.studentNo = studentNo == null ? null : studentNo.trim();
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
			
				
		public String getClassesId() {
	        return classesId;
	    }
	
	    public void setClassesId(String classesId){
	        this.classesId = classesId == null ? null : classesId.trim();
	    }
			
				
		public String getClassesName() {
	        return classesName;
	    }
	
	    public void setClassesName(String classesName){
	        this.classesName = classesName == null ? null : classesName.trim();
	    }
			
				
		public String getBedId() {
	        return bedId;
	    }
	
	    public void setBedId(String bedId){
	        this.bedId = bedId == null ? null : bedId.trim();
	    }
			
				
		public String getBedNum() {
	        return bedNum;
	    }
	
	    public void setBedNum(String bedNum){
	        this.bedNum = bedNum == null ? null : bedNum.trim();
	    }
			
				
		public String getBedroomName() {
	        return bedroomName;
	    }
	
	    public void setBedroomName(String bedroomName){
	        this.bedroomName = bedroomName == null ? null : bedroomName.trim();
	    }
			
				
		public String getDepartmentName() {
	        return departmentName;
	    }
	
	    public void setDepartmentName(String departmentName){
	        this.departmentName = departmentName == null ? null : departmentName.trim();
	    }
			
			
}