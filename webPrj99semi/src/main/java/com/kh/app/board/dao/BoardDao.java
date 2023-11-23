package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> selectBoardList(Connection conn) throws Exception {
		// sql
		String sql = "SELECT B.NO  번호 , C.CATEGORY 카테고리 , B.TITLE 제목 , M.ID 작성자 , B.HIT 조회수 , B.ENROLL_DATE 작성일 FROM BOARD B LEFT JOIN MEMBER M ON B.WRITER_NO = M.NO LEFT JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.STATUS='O' ORDER BY B.NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("번호");
			String categoryName = rs.getString("카테고리");
			String title = rs.getString("제목");
			String writerNick = rs.getString("작성자");
			String hit = rs.getString("조회수");
			String enrollDate = rs.getString("작성일");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			
			boardVoList.add(vo);
		}
		
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return boardVoList;
	}
	
	public int write(Connection conn, BoardVo vo) throws Exception {
		// sql
		String sql = "INSERT INTO BOARD(NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getWriterNo());
		int result = pstmt.executeUpdate();
		
		// rs
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public BoardVo selectBoardByNo(Connection conn, String no) throws Exception {
		// sql
		String sql = "SELECT B.NO 번호 , B.CATEGORY_NO 카테고리번호, C.CATEGORY 카테고리 , B.TITLE 제목 , B.CONTENT 내용 , B.WRITER_NO 작성자번호, M.ID  작성자 , B.HIT 조회수 , B.ENROLL_DATE 작성일 , B.MODIFY_DATE 수정일 , B.STATUS  삭제여부 FROM BOARD B LEFT JOIN MEMBER M ON M.NO = B.WRITER_NO LEFT JOIN CATEGORY C ON C.NO = B.CATEGORY_NO WHERE B.NO = ? AND B.STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
	
		// rs
		BoardVo vo = null;
		if(rs.next()) {
			String categoryNo = rs.getString("카테고리번호");
			String categoryName = rs.getString("카테고리");
			String title = rs.getString("제목");
			String content = rs.getString("내용");
			String writerNo = rs.getString("작성자번호");
			String writerNick = rs.getString("작성자");
			String hit = rs.getString("조회수");
			String enrollDate = rs.getString("작성일");
			String modifyDate = rs.getString("수정일");
			String status = rs.getString("삭제여부");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setCategoryNo(categoryNo);
			vo.setCategoryName(categoryName);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setWriterNick(writerNick);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setStatus(status);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int increaseHit(Connection conn, String no) throws Exception {
		// sql
		String sql = "UPDATE BOARD SET HIT=HIT+1 WHERE NO=? AND STATUS='O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delete(Connection conn, BoardVo vo) throws Exception {
		// sql
		String sql = "UPDATE BOARD SET STATUS = 'X' WHERE NO=? AND WRITER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		pstmt.setString(2, vo.getWriterNo());
		int result = pstmt.executeUpdate();
		
		// rs
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
