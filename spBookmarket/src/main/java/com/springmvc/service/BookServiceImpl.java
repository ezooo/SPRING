package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBookList() 
	{
		System.out.println("북서비스 겟북리스트 함수 진입");
		
		return bookRepository.getAllBookList();
	}

	@Override
	public List<Book> getBookListByCategory(String category) 
	{
		System.out.println("북서비스 getBookListByCategory 진입 - 리파지토리 함수 호출하기");
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		System.out.println("북서비스 getBookListByCategory : 리파지토리 함수 호출 후 리턴 받아 북 컨트롤러로 돌아갑니다.");
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) 
	{
		System.out.println("북서비스 getBookListByFilter 진입 - 리파지토리 함수 호출하기");
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		System.out.println("북서비스 getBookListByFilter : 리파지토리의 리턴을 받고 북 컨트롤러로 돌아갑니다.");
		return booksByFilter;
	}

	@Override
	public Book getBookById(String bookId) 
	{
		System.out.println("북서비스 getBookById - 리파지토리 함수호출");
		Book bookById = bookRepository.getBookById(bookId);
		System.out.println("bookRepository의 getBookById 호출종료");
		return bookById;
	}

	@Override
	public void setNewBook(Book book) 
	{
		System.out.println("북서비스 셋뉴북 - 리파지토리 함수호출");
		bookRepository.setNewBook(book);
		System.out.println("북서비스 셋뉴북 - 리파지토리 셋 완료");
	}
}
