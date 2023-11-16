package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.MemberVo;
import com.kh.app.member.service.MemberService;

@WebServlet("/member/login")

public class MemberLoginController extends HttpServlet{
	
	// 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(id);
			vo.setMemberPwd(pwd);
			
			// service
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			// 결과 처리
			if(loginMember!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("userData", loginMember);
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			} else {
				throw new Exception("[ERR-LOGIN2] 일치하는 회원정보 없음");
			}
		} catch(Exception e) {
			System.out.println("[ERR-LOGIN1] 로그인 작업 도중 예외 발생");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);					
			
		}
	}
	
}
