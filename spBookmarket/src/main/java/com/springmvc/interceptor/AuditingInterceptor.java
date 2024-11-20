package com.springmvc.interceptor;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor extends HandlerInterceptorAdapter
{
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	private String user;
	private String bookId;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		System.out.println("AuditingInterceptor preHandle 호출됨");
		if(request.getRequestURI().endsWith("books/add") && request.getMethod().equals("POST"))
		{
			System.out.println("addbook요청 - post로 등록 도서 받아옴");
			user = request.getRemoteUser();
			bookId = request.getParameter("bookId");
		}
		System.out.println("preHandle 리턴 트루");
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception 
	{
		System.out.println("AuditingInterceptor afterCompletion 호출됨");
		if(request.getRequestURI().endsWith("books/add"))
		{
			System.out.println("addbook 로그");
			logger.warn(String.format("신규등록 도서 ID : %s, 접근자 : %s, 접근시각 : %s", bookId, user, getCurrentTime()));
		}
		System.out.println("afterCompletion 끝");
	}

	private String getCurrentTime()
	{
		System.out.println("AuditingInterceptor getCurrentTime 함수 진입");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println("getCurrentTime 함수가 리턴할 내용 > "+formatter.format(calendar.getTime()));
		return formatter.format(calendar.getTime());
	}
}
