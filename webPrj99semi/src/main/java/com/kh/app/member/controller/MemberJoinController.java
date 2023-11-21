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

@WebServlet("/member/join")

public class MemberJoinController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 인코딩 처리
			req.setCharacterEncoding("UTF-8");
			// 데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String addr = req.getParameter("addr");
			String[] hobbys= req.getParameterValues("hobbys"); // 여러 개의 취미 값들을 전부 다 가져올 수 있으려면
			
			
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			vo.setPhone(phone);
			vo.setEmail(email);
			vo.setAddr(addr);
			vo.setHobbys(hobbys);
			
			// 서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			// 결과 처리(view)
			if(result == 1) {
				HttpSession session = req.getSession();
				session.setAttribute("alertMsg", "회원가입 성공");
				resp.sendRedirect("/app99/home");
			} else {
				throw new Exception("result값이 1이 아님");
			}
		} catch(Exception e) {
			System.out.println("[ERR-M001] 회원가입 도중 예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errorMsg", "회원가입");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);	
		}
	}
	
}//class
