package com.bitcamp.cm.member.domain;

public class MemberRestapiRegRequest {
	
	private String u_id;
	private String u_name;
	private String u_pw;
	
	
	
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return "MemberRestapiRegRequest [u_id=" + u_id + ", u_name=" + u_name + ", u_pw=" + u_pw + "]";
	}

	public MemberInfo toMemberInfo() {
		MemberInfo member = new MemberInfo();
		member.setU_id(u_id);
		member.setU_name(u_name);
		member.setU_pw(u_pw);
		return member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}