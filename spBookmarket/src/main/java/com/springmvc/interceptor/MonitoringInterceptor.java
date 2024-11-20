package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor
{
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();	//스톱워치 만들기 - 안해도 상관없음
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{	//웹 요청 URL이 컨트롤러에 들어가기 전에 호출됨
		System.out.println("preHandle 호출됨");
		StopWatch stopWatch = new StopWatch(handler.toString());	//핸들러 객체에 대한 정보를 스톱워치의 파라미터로 줌
		//스톱워치 시작을 안했네...
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		
		logger.info("접근한 URL 경로 : "+ getURLPath(request));
		logger.info("요청 처리 시작 시각 : "+ getCurrentTime());
		System.out.println("프리핸들 로그남김");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{	//웹 요청을 컨트롤러가 처리한 후 호출
		System.out.println("postHandle 호출됨");
		logger.info("요청 처리 종료 시각 : "+ getCurrentTime());
		System.out.println("포스트핸들 로그남김");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception 
	{	//컨트롤러가 요청을 처리하여 뷰에 최종 결과 반환하고 난 뒤에 호출
		System.out.println("afterCompletion 호출됨");
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop(); //스톱워치 종료
		logger.info("요청 처리 소요 시간 : "+ stopWatch.getTotalTimeMillis() +"ms");
		stopWatchLocal.set(null);
		logger.info("===================================");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	//함수 만들기
	private String getURLPath(HttpServletRequest request)
	{
		System.out.println("getURLPath 함수 진입");
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = (queryString == null? "" : "?" + queryString) ;
		System.out.println("queryString은 > "+queryString);
		return currentPath + queryString;
	}
	private String getCurrentTime()
	{
		System.out.println("getCurrentTime 함수 진입");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println("getCurrentTime 함수가 리턴할 내용 > "+formatter.format(calendar.getTime()));
		return formatter.format(calendar.getTime());
	}
}
