package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.MemberVo;
import com.kh.app.member.dao.MemberDao;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		// connection
		Connection conn = JDBCTemplate.getConnection();
		// dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

}
