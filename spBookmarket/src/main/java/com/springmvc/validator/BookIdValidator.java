package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;

public class BookIdValidator implements ConstraintValidator<BookId, String>
{	//유효성 검사를 실시할 클래스 (검사 내용 작성)
	@Autowired
	private BookService bookService;
	
	@Override
	public void initialize(BookId constraintAnnotation) 
	{	//애너테이션 @BookId 의 관련 정보 읽어 초기화 작업
		System.out.println("BookIdValidator 초기화 작업 함수 initialize");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{	//유효성 검사 메서드
		System.out.println("BookIdValidator 유효성 검사 함수 isValid");
		Book book;	//검사 할 북객체 담을 변수 선언
		try
		{	
			book = bookService.getBookById(value);
		}
		catch(BookIdException e)
		{
			return true;
		}
		
		if(book != null)
		{
			return false;
		}
		return true;
	}

}
