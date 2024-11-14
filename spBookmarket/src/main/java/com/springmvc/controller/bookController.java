package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
public class bookController 
{
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String requestBookList(Model model)
	{
		System.out.println("북컨트롤러 북리스트함수 진입");
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
}
