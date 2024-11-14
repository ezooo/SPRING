package com.springmvc.service;

import java.util.List;

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
}
