package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {

	// 멤버변수
	private final MemberDao dao;
	
	// 생성자
	public MemberService() {
		dao = new MemberDao();
	}
	
	public int join(MemberVo vo) throws Exception {
		// business logic
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호 일치하지 않음");
		}
		
		if(vo.getMemberId().length() < 4) {
			throw new Exception("아이디 길이 4자 이상이어야 함");
		}
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
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

}
