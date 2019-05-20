package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 个人习性
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-18 20:49:11
 */
public class Habit implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 
	 */
		private String id;
		
	/**
	 * 饮食习惯（以喜好菜系区分）
	 */
		private String eatingHabits;
		
	/**
	 * 作息（夜猫子，早睡早起，两者兼顾默认）
	 */
		private String workRest;
		
	/**
	 * 是否吸烟
	 */
		private String smoke;
		
	/**
	 * 睡眠质量（低，中，高）三个等级，越低表示越容易被吵醒
	 */
		private String sleepQuality;
		
	/**
	 * 学生id
	 */
		private String studentId;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getEatingHabits() {
	        return eatingHabits;
	    }
	
	    public void setEatingHabits(String eatingHabits){
	        this.eatingHabits = eatingHabits == null ? null : eatingHabits.trim();
	    }
			
				
		public String getWorkRest() {
	        return workRest;
	    }
	
	    public void setWorkRest(String workRest){
	        this.workRest = workRest == null ? null : workRest.trim();
	    }
			
				
		public String getSmoke() {
	        return smoke;
	    }
	
	    public void setSmoke(String smoke){
	        this.smoke = smoke == null ? null : smoke.trim();
	    }
			
				
		public String getSleepQuality() {
	        return sleepQuality;
	    }
	
	    public void setSleepQuality(String sleepQuality){
	        this.sleepQuality = sleepQuality == null ? null : sleepQuality.trim();
	    }
			
				
		public String getStudentId() {
	        return studentId;
	    }
	
	    public void setStudentId(String studentId){
	        this.studentId = studentId == null ? null : studentId.trim();
	    }
			
			
}