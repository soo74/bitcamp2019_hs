package com.bitcamp.mm.member.domain;

import java.util.Date;

public class LoginInfo {
	
	private String u_id;
	private String u_name;
	private String u_photo;
	private Date regDate;
	

	public LoginInfo(String u_id, String u_name, String u_photo, Date regDate) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_photo = u_photo;
		this.regDate = regDate;
	}

	


	public String getU_id() {
		return u_id;
	}




	public String getU_name() {
		return u_name;
	}


	public String getU_photo() {
		return u_photo;
	}





	public Date getRegDate() {
		return regDate;
	}




	@Override
	public String toString() {
		return "LoginInfo [u_id=" + u_id + ", u_name=" + u_name + ", u_photo=" + u_photo + ", regDate=" + regDate + "]";
	}




	
	
	
	
	
	

}
