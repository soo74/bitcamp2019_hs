package dateShare.service.user;

import java.sql.Connection;
import java.sql.SQLException;

import dateShare.Dao.dateUserDao;
import dateShare.Model.DateUser;
import jdbc.ConnectionProvider;

public class LoginService {
	
	private static LoginService service = new LoginService();

	public static LoginService getInstance() {
		return service;
	}

	private LoginService() {}

	public DateUser login(String u_id) {

		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행
		
		DateUser dUser = null;
		
		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			dateUserDao dao = dateUserDao.getInstance();

			dUser = dao.login(conn, u_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dUser;

	}
}
