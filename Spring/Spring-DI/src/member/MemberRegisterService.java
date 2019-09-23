package member;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("registService")
public class MemberRegisterService {
	
	@Autowired(required = false)
	// @Qualifier("sys")
	//@Resource(name = "memberDao1")
	private Dao memberDao;
	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	/*
	 * public MemberRegisterService(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	
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