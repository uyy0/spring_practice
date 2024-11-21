package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor extends HandlerInterceptorAdapter{
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	private String user;
	private String bookId;
	
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse arg1,
							Object handler) throws Exception{
	    System.out.println("Request URI: " + request.getRequestURI());
	    System.out.println("Request Method: " + request.getMethod());
	    System.out.println("Remote User: " + request.getRemoteUser());
		if(request.getRequestURI().endsWith("books/add") && request.getMethod().equals("POST")) {
			System.out.println("request uri if문 입장");
			user=request.getRemoteUser();
			bookId=request.getParameterValues("bookId")[0];
		}
		return true;
	}
	
	public void afterCompletion(HttpServletRequest request,
							HttpServletResponse response,
							Object handler, Exception arg3) throws Exception{
		if(request.getRequestURI().endsWith("books/add")) {
			logger.warn(String.format("신규등록 도서 ID : %s, 접근자 : %s, 접근시각 : %s", bookId, user, getCurrentTime()));
		}
	}
	
	public String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
