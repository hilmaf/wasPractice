package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.BoardVo;
import com.kh.app.board.dao.BoardDao;
import com.kh.app.db.util.JDBCTemplate;

public class BoardService {

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

}
