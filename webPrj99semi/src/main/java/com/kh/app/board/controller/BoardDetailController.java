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

@WebServlet("/board/detail")

public class BoardDetailController extends HttpServlet{
	
	// 게시글 상세조회 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터 - 어떤 글을 선택했느냐
			String no = req.getParameter("no");
					
			// service
			BoardService bs = new BoardService();
			BoardVo vo = bs.selectBoardByNo(no);
			
			// result
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println("[ERR-B003] 게시글 상세 조회 도중 예외 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
