package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.BoardVo;
import com.kh.app.board.dao.BoardDao;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.page.vo.PageVo;

public class BoardService {

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList(PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn, pvo);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	public int write(BoardVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		// close
		JDBCTemplate.close(conn);
		return result;
	}

	
	// 게시글 상세조회
	public BoardVo selectBoardByNo(String no) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		// 게시글 상세조회
		BoardDao dao = new BoardDao();
		int result = dao.increaseHit(conn, no);
		
		if(result != 1) {
			throw new Exception("조회수 증가 작업 오류");
		}
		
		BoardVo vo = dao.selectBoardByNo(conn, no);			
		
		// tx
		if(result ==1 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int delete(BoardVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.delete(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int selectBoardCount() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int cnt = dao.selectBoardCount(conn);
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
	}


}
