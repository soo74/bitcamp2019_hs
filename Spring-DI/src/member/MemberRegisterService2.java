package member;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public class MemberRegisterService2 {
	

	private MemberDao memberDao;

	  public MemberRegisterService2(MemberDao memberDao) {
		  this.memberDao = memberDao;
	  	}
	 
	
	public void regist(RegisterRequest request) throws AlreadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException();
		}
		
		Member newMember = new Member(
				request.getEmail(), 
				request.getPassword(), 
				request.getName(), 
				new Date());
		
		memberDao.insert(newMember);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}