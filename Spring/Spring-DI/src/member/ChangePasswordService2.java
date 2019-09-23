package member;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService2 {
	
	@Autowired
	private Dao memberDao;
	
	
	  public void setMemberDao(Dao memberDao) {
		this.memberDao = memberDao;
	}




	public ChangePasswordService2(MemberDao dao) { 
		  memberDao = dao;
	}
	 
	



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