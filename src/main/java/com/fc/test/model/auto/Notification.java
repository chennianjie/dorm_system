package com.fc.test.model.auto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 资讯信息
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-28 16:44:25
 */
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/**
	 * 主键
	 */
		private String id;
		
	/**
	 * 内容
	 */
		private String content;
		
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
		private Date createTime;
		
	/**
	 * 创建用户
	 */
		private String userId;
		
	/**
	 * 查看权限标识 1所有人  2同寝室人  3同班级人   
	 */
		private String permission;
	
	
			
		public String getId() {
	        return id;
	    }
	
	    public void setId(String id){
	        this.id = id == null ? null : id.trim();
	    }
			
				
		public String getContent() {
	        return content;
	    }
	
	    public void setContent(String content){
	        this.content = content == null ? null : content.trim();
	    }
			
			
		public Date getCreateTime () {
	        return createTime;
	    }
	
	    public void setCreateTime (Date createTime) {
	        this.createTime = createTime;
	    }
	 
				
		public String getUserId() {
	        return userId;
	    }
	
	    public void setUserId(String userId){
	        this.userId = userId == null ? null : userId.trim();
	    }
			
				
		public String getPermission() {
	        return permission;
	    }
	
	    public void setPermission(String permission){
	        this.permission = permission == null ? null : permission.trim();
	    }
			
			
}