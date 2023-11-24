package edu.kh.test.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.vo.UserDTO;
import edu.kh.test.user.service.UserService;

@WebServlet("/selectUser")

public class SelectUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 데이터
			String userNo = req.getParameter("userNo");
			
			// service
			UserService service = new UserService();
			UserDTO dto = service.search(userNo);
			
			// result == view
			if(dto==null) {
				throw new Exception("조회 결과 없음");
			}
			
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(req, resp);
			
		} catch(Exception e) {
			req.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(req, resp);
		}
	}
}
