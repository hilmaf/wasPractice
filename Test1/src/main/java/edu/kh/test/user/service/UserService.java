package edu.kh.test.user.service;

import java.sql.Connection;

import edu.kh.test.db.util.JDBCTemplate;
import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

public class UserService {

	public UserDTO search(String userNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.search(conn, userNo);
		
		// tx
		
		
		// close
		JDBCTemplate.close(conn);
		
		return dto;
	}

}
