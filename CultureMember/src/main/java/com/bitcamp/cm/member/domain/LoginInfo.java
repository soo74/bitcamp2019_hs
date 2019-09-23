package com.bitcamp.cm.member.domain;

import java.util.Date;

public class LoginInfo {
	
	private String u_id;
	private String u_name;
	private String uPhoto;
	private Date u_regDate;
	
	public LoginInfo(String u_id, String u_name, String uPhoto, Date u_regDate) {	
		this.u_id = u_id;
		this.u_name = u_name;
		this.uPhoto = uPhoto;
		this.u_regDate = u_regDate;
	}

	

	public String getU_id() {
		return u_id;
	}



	public String getU_name() {
		return u_name;
	}



	public String getuPhoto() {
		return uPhoto;
	}



	public Date getU_regDate() {
		return u_regDate;
	}



	@Override
	public String toString() {
		return "LoginInfo [u_id=" + u_id + ", u_name=" + u_name + ", uPhoto=" + uPhoto + ", u_regDate=" + u_regDate
				+ "]";
	}



	
	
	
	
	
	
	

}