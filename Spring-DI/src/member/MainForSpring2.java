package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring2 {
	
	//private static Assembler assembler = new Assembler();
	
	
	// 스프링 컨테이너 생성 : 조립기 설정파일 appCtx1.xml 
	private static ApplicationContext ctx = 			
			new GenericXmlApplicationContext("classpath:appCtx5.xml");
	
	

	public static void main(String[] args) {
		
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("MemberRegisterService");
		
		MemberRegisterService registerService1 = 
				ctx.getBean("registService", MemberRegisterService.class);
		
		MemberRegisterService registerService2 = 
				ctx.getBean("registService", MemberRegisterService.class);
		
		// 참조변수 비교 : 참조 주소값을 비교
		boolean chk = registerService1==registerService2;
		
		System.out.println("registerService1==registerService2 : " + chk);
		
		System.out.println("============================================");
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("ChangePasswordService");
		
		ChangePasswordService passwordService1 = 
				ctx.getBean("changePwService", ChangePasswordService.class);
		
		ChangePasswordService passwordService2 = 
				ctx.getBean("changePwService", ChangePasswordService.class);
		

		ChangePasswordService passwordService3 = 
				ctx.getBean("changePwService", ChangePasswordService.class);
		
		chk = passwordService1 == passwordService2;
		boolean chk2 = passwordService2 == passwordService3;
		System.out.println("passwordService1==passwordService2 : " + chk);
		System.out.println("passwordService2==passwordService3 : " + chk2);
		
		
		

	}
	

	
	
	
	
	
	
}