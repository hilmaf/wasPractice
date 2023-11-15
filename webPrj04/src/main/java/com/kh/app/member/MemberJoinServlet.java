package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")

public class MemberJoinServlet extends HttpServlet {

	// 회원가입 화면 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		
	}
	
	// 회원가입 작업 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
		
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			
			// 서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			// 결과 처리
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			} else {
				throw new Exception();
			}

		} catch(Exception e) {
			System.out.println("[ERR-M001] 회원가입 작업 도중 예외 발생");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);			
		}
	}
}
