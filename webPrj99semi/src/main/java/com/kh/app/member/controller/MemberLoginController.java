package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.MemberVo;
import com.kh.app.member.service.MemberService;

@WebServlet("/member/login")

public class MemberLoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			// 서비스
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			// result (== view)
			if(loginMember==null) {
				throw new Exception("일치하는 회원정보 없음");
			}
			
			resp.sendRedirect("/app99/home");
		} catch(Exception e) {
			System.out.println("[ERR-M002] 로그인 작업 중 예외 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
