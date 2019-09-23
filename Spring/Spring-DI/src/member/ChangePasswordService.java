package member;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {
	
	//private MemberDao memberDao = new MemberDao();
	
	@Autowired(required = false)
	//@Qualifier("sys")
	//@Resource(name = "boardDao")
	private Dao memberDao;
	

	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	/*
	 * public ChangePasswordService(MemberDao dao) { memberDao = dao; }
	 */
	



	public void changePassword(
			String email, 
			String oldPassword, 
			String newPassword) throws MemberNotfoundException, IdPasswordNotMatchingException {
		
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotfoundException();
		}
		member.changePassword(oldPassword, newPassword);
		
		memberDao.update(member);
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}