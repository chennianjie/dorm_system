package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-20 17:59:10
 */
public class Punchclock implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 
	 */
		private String id;
		
	/**
	 * 
	 */
		private String studentNo;
		
	/**
	 * 
	 */
		private String studentName;
		
	/**
	 * 
	 */
		private String punchTime;
		
	/**
	 * 
	 */
		private String ip;
		
	/**
	 * 
	 */
		private String address;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getStudentNo() {
	        return studentNo;
	    }
	
	    public void setStudentNo(String studentNo){
	        this.studentNo = studentNo == null ? null : studentNo.trim();
	    }
			
				
		public String getStudentName() {
	        return studentName;
	    }
	
	    public void setStudentName(String studentName){
	        this.studentName = studentName == null ? null : studentName.trim();
	    }
			
				
		public String getPunchTime() {
	        return punchTime;
	    }
	
	    public void setPunchTime(String punchTime){
	        this.punchTime = punchTime == null ? null : punchTime.trim();
	    }
			
				
		public String getIp() {
	        return ip;
	    }
	
	    public void setIp(String ip){
	        this.ip = ip == null ? null : ip.trim();
	    }
			
				
		public String getAddress() {
	        return address;
	    }
	
	    public void setAddress(String address){
	        this.address = address == null ? null : address.trim();
	    }
			
			
}