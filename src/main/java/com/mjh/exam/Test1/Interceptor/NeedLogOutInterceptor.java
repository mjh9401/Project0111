package com.mjh.exam.Test1.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mjh.exam.Test1.Dto.Rq;

@Component
public class NeedLogOutInterceptor implements HandlerInterceptor {
	@Autowired
	private Rq rq;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(rq.isLogined()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그아웃 해주세요');"
					+ "location.href='/main';"
					+ "</script>");
			out.flush();
			out.close();

			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
