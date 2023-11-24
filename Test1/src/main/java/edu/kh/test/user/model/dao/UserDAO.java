package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kh.test.db.util.JDBCTemplate;
import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {

	public UserDTO search(Connection conn, String userNo) throws Exception{
		// sql
		String sql ="SELECT * FROM TB_USER WHERE USER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		UserDTO dto = null;
		if(rs.next()) {
			String id = rs.getString("USER_ID");
			String name = rs.getString("USER_NAME");
			String age = rs.getString("USER_AGE");
			
			dto = new UserDTO();
			dto.setUserNo(userNo);
			dto.setUserId(id);
			dto.setUserName(name);
			dto.setUserAge(age);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dto;
	}

}
