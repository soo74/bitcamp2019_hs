package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {

	@Autowired
	MailSender sender;
	
	@Autowired
	JavaMailSender javaMailSender;
	

	
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		//메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("heuisu704@naver.com");
		message.setSubject("처음 보내는 Java Mail 입니다.");
		message.setText("처음 보내는 메일의 내용입니다. 반갑습니다.");
		message.setFrom("dale94011@gmail.com");
		
		SimpleMailMessage m = new SimpleMailMessage(message);
		
		sender.send(message);
		
		return "send ok";
	}
	
	
	@RequestMapping("/mail/send2")
	public String sendJavaMailSender() {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			// 메일 제목 설정
			message.setSubject("[안내] 처음 보내는 JavaMailSender", "UTF-8");
			
			//html 메일 내용
			String htmlStr = "<h1 style=\"color:blue\">안녕하세요</h1><br>" + "<a href=\"http://www.naver.com\">naver</a>";
			//내용 설정
			message.setText(htmlStr, "UTF-8", "html");
			//To 설정
			message.addRecipient(RecipientType.TO, new InternetAddress("heuisu704@naver.com", "김희수 님", "UTF-8"));
			
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "send ok";
	}


	@ResponseBody
	@RequestMapping("/mail/send3")
	public String sendFileAttach() {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		
			// 제목
			messageHelper.setSubject("[안내] 파일 첨부합니다.");
		
			// 내용html
			String htmlStr = "<h1>파일첨부, 파일을 다운받으세요.</h1>";
			
			// 내용 설정
			messageHelper.setText(htmlStr, true);
			
			// To 설정
			messageHelper.setTo(new InternetAddress("heuisu704@naver.com", "김희수 님", "UTF-8"));
		
			//첨부할 파일 객체 생성
			DataSource dataSource = new FileDataSource("C:\\Users\\5CLASS-184\\Documents\\test.pdf");
			//MimeMessageHelper 파일 객체를 추가
			messageHelper.addAttachment(MimeUtility.encodeText("test.pdf", "UTF-8", "B"), dataSource);
		
			
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "send ok";
	}




}
