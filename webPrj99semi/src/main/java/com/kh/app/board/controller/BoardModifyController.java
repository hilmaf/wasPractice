package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.BoardVo;
import com.kh.app.board.service.BoardService;

@WebServlet("/board/edit")

public class BoardModifyController extends HttpServlet{

	// 수정 화면 불러오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터
			String no = req.getParameter("no");
			
			// service
			BoardService bs = new BoardService();
			BoardVo vo = bs.selectBoardByNo(no);
			
			if(vo == null) {
				throw new Exception("게시글 정보 불러오지 못함");
			}
			System.out.println(vo);
			
			// result == view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/modify.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println("[ERR-B005] 게시글 수정 화면 불러오기 도중 예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errorMsg", "수정화면 불러오기 실패..");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	// 수정 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/app99/board/detail");
	}
	
}
