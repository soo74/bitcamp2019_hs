package com.bitcamp.mm.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class RequestMemberRegist {

	private String u_id;
	private String u_pw;
	private String u_name;
	private MultipartFile u_photo;

	


	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public MultipartFile getU_photo() {
		return u_photo;
	}

	public void setU_photo(MultipartFile u_photo) {
		this.u_photo = u_photo;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return "RequestMemberRegist [u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_photo=" + u_photo
				+ "]";
	}

	public MemberInfo toMemberInfo() {
		
		MemberInfo info = new MemberInfo();
		info.setU_id(u_id);
		info.setU_name(u_name);
		info.setU_pw(u_pw);
		
		return info;
		
	}
	
	
	
	
	
	
	
	
	
	

}
