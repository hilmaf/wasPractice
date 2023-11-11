package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")

public class AddServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String result = Integer.toString(Integer.parseInt(n1) + Integer.parseInt(n2));
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>CALCULATOR</h1>");
		pw.write("<h3>sum :::  " + result + "</h3>");
	
	}
	
}
