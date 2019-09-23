package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration            //컨테이너 생성시 AppContext를 부를것이다.
public class AppContext {
	
	@Bean(name = "memberDao")
	//@Scope("prototype")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	@Bean(name = "registService2")
	public MemberRegisterService2 getMemberRegisterService2() {
		
		MemberRegisterService2 service = new MemberRegisterService2();
		
		//주입
		//service.setMemberDao(getMemberDao());      @Autowired를 설정했으므로 쓰지않아도된다.
		
		return service;
		//return new MemberRegisterService2(getMemberDao());
	}
	
	@Bean(name = "changePwService2")
	public ChangePasswordService2 getChangePasswordService2() {
		
		ChangePasswordService2 service = new ChangePasswordService2();
		
		//주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		//return new ChangePasswordService2(getMemberDao()); 
	}

}
