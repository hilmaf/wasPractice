package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.board.BoardVo;
import com.kh.app.board.service.BoardService;
import com.kh.app.member.MemberVo;

@WebServlet("/board/write")

public class BoardWriteController extends HttpServlet {
	
	// 화면 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 안 되어있으면 에러페이지 띄우기
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		if(loginMember==null) {
			req.setAttribute("errorMsg", "로그인 안된 상태여서 게시글 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
//		if(req.getSession().getAttribute("loginMember")==null) {
//			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp)
//			req.setAttribute("errorMsg", "로그인 안된 상태여서 게시글 작성 실패");
//		}
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	// 게시글 작성 처리 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			// 데이터
			String category = req.getParameter("category");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			if(loginMember==null) {
				throw new Exception("로그인 안함");
			}
			
			BoardVo vo = new BoardVo();
			
			vo.setCategoryNo(category);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(loginMember.getNo());
			
			// service
			BoardService bs = new BoardService();
			int result = bs.write(vo);
			
			// result == view
			if(result!=1) {
				throw new Exception("result가 1이 아님");
			}
			
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공");
			resp.sendRedirect("/app99/board/list");
		} catch(Exception e) {
			req.setAttribute("errorMsg", "게시글 작성 실패...");
			System.out.println("[ERR-B002] 게시글 작성 실패");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);			
		}
		
	}
	
}
