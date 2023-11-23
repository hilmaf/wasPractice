package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.BoardVo;
import com.kh.app.board.service.BoardService;
import com.kh.app.member.MemberVo;

@WebServlet("/board/delete")

public class BoardDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember==null) {
				throw new Exception("로그인 후에만 삭제 가능함");
			}
			
			// data
			String no = req.getParameter("no");
			String writerNo = loginMember.getNo();
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setWriterNo(writerNo);
			
			// service
			BoardService bs = new BoardService();
			int result = bs.delete(vo);
			
			
			// result == view
			if(result != 1) {
				throw new Exception("result가 1이 아님...");
			}
			
			// 게시글 삭제 성공 시 게시글 목록 페이지로 redirect
			req.getSession().setAttribute("alertMsg", "게시글 삭제 성공");
			resp.sendRedirect("/app99/board/list");
			
		} catch(Exception e) {
			System.out.println("[ERR-B004] 게시글 삭제 중 에러 발생...");
			req.setAttribute("errorMsg", "게시글 삭제 실패");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
