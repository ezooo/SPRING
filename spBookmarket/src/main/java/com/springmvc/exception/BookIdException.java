package com.springmvc.exception;

@SuppressWarnings("serial")
public class BookIdException extends RuntimeException
{	//도서 목록에 존재하지 않는 도서 아이디를 요청하는 경우 예외처리
	private String bookId;

	public BookIdException(String bookId) 
	{
		super();
		System.out.println("BookIdException 생성자 호출됨");
		this.bookId = bookId;
		System.out.println("찾고있는 북 아이디 변수에 저장");
	}

	public String getBookId() 
	{
		return bookId;
	}
}
