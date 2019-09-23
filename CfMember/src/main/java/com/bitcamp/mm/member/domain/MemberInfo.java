package com.bitcamp.mm.member.domain;

import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class MemberInfo {


	private int idx;
	private String u_id;
	@JsonIgnore
	private String u_pw;
	private String u_name;
	private String u_photo;
	private Date regDate;
	private char verify;
	@JsonIgnore
	private String code;


	public MemberInfo() {
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(String u_id, String u_pw, String u_name, String u_photo) {		
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_photo = u_photo;
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(int idx, String u_id, String u_pw, String u_name, String u_photo, Date regDate) {
		super();
		this.idx = idx;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_photo = u_photo;
		this.regDate = regDate;
		getRandomSting();
	}





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

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_photo="
				+ u_photo + ", regDate=" + regDate + ", verify=" + verify + ", code=" + code + "]";
	}
	
	

	// 화면 결과 출력을 위한 HTML 코드 반환
	public String makeHtmlDiv() {
		String str = "";

		str += "<div class=\"mInfor\"> \n";
		str += "	<h3> \n";
		str += "		" + u_id + "(" + u_name + ")\n";
		str += "	</h3> \n";
		str += "	<p> \n";
		str += "		" + u_pw;
		str += "	</p> \n";
		str += "</div> \n";

		return str;
	}

	// MemberInfo 객체 -> LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {

		return new LoginInfo(u_id, u_name, u_photo, regDate);

	}

	// 비밀번호 체크 확인
	// 2017.07.25 메서드 추가
	public boolean pwChk(String pw) {
		return u_pw != null && u_pw.trim().length() > 0 && u_pw.equals(pw);
	}
	
	// 2019.08.20 추가
	// 영문 + 숫자 난수 발생
	private void getRandomSting() {
		
		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();
		
		for(int i=0 ; i<20 ; i++ ) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char)(r.nextInt(26)+97));
			}
		}
		
		System.out.println("난수 코드 생성 : " + sb) ;
		
		setCode(sb.toString());
		
		//return  sb.toString();		
	}

}
