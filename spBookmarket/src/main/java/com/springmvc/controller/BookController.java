package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService bookService;
	//bookservice도 component scan 되어있어야 Autowired 될 수 있다. 다 같이 스캔되어야 쓸 수 있음
	//수동생성한거는 Autowired 안됨
	
	@GetMapping
	public String requestBookList(Model model)
	{
		System.out.println("BookController - 북리스트함수 진입");
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
//	@GetMapping("/all")	//getMapping  사용하면 단순화 (메서드 속성 생략)
//	public String requestAllBooks(Model model)
//	{
//		System.out.println("BookController 리퀘스트 all 함수 진입");
//		List<Book> list = bookService.getAllBookList();
//		model.addAttribute("bookList", list);
//		return "books";
//	}
	@GetMapping("/all")
	public ModelAndView requestAllBooks(Model model)
	{
		System.out.println("BookController 리퀘스트 all 함수 - 모델앤뷰 사용하기");
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList", list);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model)
	{
		System.out.println("BookController - 카테고리별 책 가져오기 진입");
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		System.out.println("BookController - 카테고리별 책 실어보내기 완료");
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter
		(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model)
	{
		System.out.println("BookController - 필터로 책 가져오기 진입");
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		System.out.println("BookController - 필터 책 목록 실어보내기 완료");
		return "books";
	}
}
