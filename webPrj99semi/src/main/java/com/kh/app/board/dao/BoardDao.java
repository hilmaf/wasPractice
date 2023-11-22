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

}
