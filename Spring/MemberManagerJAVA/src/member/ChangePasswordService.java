package member;

public class ChangePasswordService {

	//private MemberDao memberDao = new MemberDao();
	
	private MemberDao memberDao;        //인스턴스생성
	
	public ChangePasswordService(MemberDao dao) {
		memberDao = dao;                             //생성자를 통해서 주입받는것
	}
																								//멤버가없거나, 패스워드가맞지않거나
	public void changePassword(String email, String oldPassword, String newPassword) throws MemberNotfoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotfoundException();
		}
		member.changePassword(oldPassword, newPassword);
		
		memberDao.update(member);
	}
}
