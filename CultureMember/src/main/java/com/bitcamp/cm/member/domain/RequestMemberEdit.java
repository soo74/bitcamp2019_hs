package com.bitcamp.cm.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class RequestMemberEdit {

	private int idx;
	private String u_id;
	private String u_pw;
	private String u_name;
	private MultipartFile uPhoto;
	private String oldFile;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	

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

	public MultipartFile getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(MultipartFile uPhoto) {
		this.uPhoto = uPhoto;
	}

	public String getOldFile() {
		return oldFile;
	}

	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}


	

	@Override
	public String toString() {
		return "RequestMemberEdit [idx=" + idx + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + "]";
	}

	public MemberInfo toMemberInfo() {

		MemberInfo info = new MemberInfo();
		info.setIdx(idx);
		info.setU_id(u_id);
		info.setU_name(u_name);
		info.setU_pw(u_pw);
		return info;

	}

}