package com.bitcamp.cm.member.domain;

import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

// usebean Class
public class MemberInfo {
	
	
	// 각 변수의 접근 제어지시자는 private
	private int idx;
	private String u_id;
	@JsonIgnore
	private String u_pw;
	private String u_name;
	private String uPhoto;
	private Date u_regDate;
	
	private char verify;
	@JsonIgnore
	private String code;

	// default 생성자 필수
	public MemberInfo() {
		this.u_regDate = new Date();
		getRandomString();
	}

	public MemberInfo(String u_id, String u_pw, String u_name, String uPhoto) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.uPhoto = uPhoto;
		this.u_regDate = new Date();
	}

	public MemberInfo(int idx, String u_id, String u_pw, String u_name, String uPhoto, Date u_regDate) {
		super();
		this.idx = idx;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.uPhoto = uPhoto;
		this.u_regDate = u_regDate;
	}

	// 변수들의 Getter/Setter 시작

	
	

	

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

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public Date getU_regDate() {
		return u_regDate;
	}

	public void setU_regDate(Date u_regDate) {
		this.u_regDate = u_regDate;
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

	
	
	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", uPhoto="
				+ uPhoto + ", u_regDate=" + u_regDate + "]";
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

		return new LoginInfo(u_id, u_name, uPhoto, u_regDate);

	}
	
	// 비밀번호 체크 확인
	// 2017.07.25 메서드 추가
	public boolean pwChk(String pw) {
		return u_pw != null && u_pw.trim().length()>0 && u_pw.equals(pw);
	}
	
	
	//영문 + 숫자 난수 발생
	private void getRandomString() {
		
		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<20 ; i++) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));       //r.nextInt(10)(0<= ? <10)의 int타입 난수를 리턴
			} else {
				sb.append((char)(r.nextInt(26)+97));
				
			}
		}
		
		System.out.println("난수 코드 생성 : " + sb);
		
		setCode(sb.toString());
		
		//return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}