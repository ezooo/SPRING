package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice	//전역예외처리 : 전체 애플리케이션에 한번에 적용할 수 있음
public class CommonException 
{
	@ExceptionHandler(RuntimeException.class)
	private ModelAndView handleErrorCommon(Exception e)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", e);
		modelAndView.setViewName("errorCommon");
		return modelAndView;
	}
}
