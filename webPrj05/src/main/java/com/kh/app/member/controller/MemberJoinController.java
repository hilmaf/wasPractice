package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.MemberVo;
import com.kh.app.member.service.MemberService;

@WebServlet("/member/join")

public class MemberJoinController extends HttpServlet{
	
	// 회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	
	// 회원가입 처리
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
			
			// service
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			// 결과 처리
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			} else {
				throw new Exception("[ERR-JOIN] 입력 정보 재확인 필요");
			}
		} catch(Exception e) {
			System.out.println("[ERR-JOIN] 회원가입 작업 도중 예외 발생");
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
	}
}
