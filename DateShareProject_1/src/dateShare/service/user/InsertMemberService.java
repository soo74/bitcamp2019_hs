package dateShare.service.user;

import java.sql.Connection;
import java.sql.SQLException;

import dateShare.Dao.dateUserDao;
import dateShare.Model.DateUser;
import jdbc.ConnectionProvider;

public class InsertMemberService {
	
	private static InsertMemberService service = new InsertMemberService();

	public static InsertMemberService getInstance() {
		return service;
	}

	private InsertMemberService() {}

	public int insert(DateUser dUser) {

		int rCnt = 0;

		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			dateUserDao dao = dateUserDao.getInstance();

			rCnt = dao.insert(conn, dUser);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;

	}
}
