package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 学院
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-28 21:13:54
 */
public class College implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
		private String id;
		
	/**
	 * 学院名字
	 */
		private String name;
		
	/**
	 * 导员名字
	 */
		private String coacherName;
		
	/**
	 * 导员电话
	 */
		private String coacherCall;
	
	
			
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
			
				
		public String getCoacherName() {
	        return coacherName;
	    }
	
	    public void setCoacherName(String coacherName){
	        this.coacherName = coacherName == null ? null : coacherName.trim();
	    }
			
				
		public String getCoacherCall() {
	        return coacherCall;
	    }
	
	    public void setCoacherCall(String coacherCall){
	        this.coacherCall = coacherCall == null ? null : coacherCall.trim();
	    }
			
			
}