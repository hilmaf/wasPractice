package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.BoardVo;
import com.kh.app.board.service.BoardService;

@WebServlet("/board/list")

public class BoardListController extends HttpServlet {
	
	// 게시글 목록 조회 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			// 만약 페이지번호가 있으면 데이터 받아올 게 있겠지만 지금은 없기 때문에 그냥 모든 게시글 조회하면 됨
			
			// service
			BoardService bs = new BoardService();
			List<BoardVo> boardVoList = bs.selectBoardList();
			
			// result (==view)			
			req.setAttribute("boardVoList", boardVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		} catch(Exception e) {
			System.out.println("[ERR-B001] 게시글 목록 조회 중 예외 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 목록 조회");
			req.getRequestDispatcher("WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
}
