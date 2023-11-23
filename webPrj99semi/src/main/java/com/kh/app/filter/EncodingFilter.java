package com.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")

public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 인코딩 뿐만 아니라 로그인이 되어야만 볼 수 있는 페이지라든가 등등을 필터에서 먼저 검사하고 그다음에 서블릿으로 넘기게 하기도 함
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
	
}
