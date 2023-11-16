package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		int result = pstmt.executeUpdate();
		// rs
		
		// close
		JDBCTemplate.close(pstmt);
		
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberNick());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		
		MemberVo loginMember = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			
			loginMember.setMemberId(id);
			loginMember.setMemberPwd(pwd);
			loginMember.setMemberNick(nick);
		}
		
		return loginMember;
	}
	
}
