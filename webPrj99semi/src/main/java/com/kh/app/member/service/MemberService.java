package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.MemberVo;
import com.kh.app.member.dao.MemberDao;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// business logic
		// 아이디 4~12 영문소문자 + 숫자
		boolean idOk = vo.getMemberId().matches("[a-z0-9]{4,12}");
		if(!idOk) {
			throw new Exception("아이디 길이 잘못됨");
		}
		// 비밀번호 일치여부 체크
		boolean pwdOk = vo.getMemberPwd().equals(vo.getMemberPwd2());
		if(!pwdOk) {
			throw new Exception("비밀번호 일치여부 문제");
		}
		
		// 비밀번호 4글자 이상
		if(vo.getMemberPwd().length() < 4) {
			throw new Exception("비밀번호 4글자 이상");
		}
		
		// 닉네임에 admin 금지
		boolean nickCheck = vo.getMemberNick().contains("admin") || vo.getMemberNick().contains("ADMIN");
		
		if(nickCheck) {
			throw new Exception("닉네임에 admin 포함 불가");
		}
		
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
		// conn
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
