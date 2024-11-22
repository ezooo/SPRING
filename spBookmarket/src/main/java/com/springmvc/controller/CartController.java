package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.repository.CartRepository;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	@Autowired
	private BookService bookService;	//카트에 책 담기위해 변수 추가
	
	@GetMapping
	public String requestCartId(HttpServletRequest req)
	{
		System.out.println("CartController - requestCartId : 카트 아이디 가져오고 리다이렉션");
		String sessionid = req.getSession(true).getId();
		System.out.println("세션아이디는 "+sessionid);
		return "redirect:/cart/" + sessionid;
	}
	
	@PostMapping
	public @ResponseBody Cart create(@RequestBody Cart cart)
	{
		System.out.println("CartController - create : 카트클래스 정보를 받아 장바구니 생성, 응답바디로 전달");
		return cartService.create(cart);
	}
	
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable(value="cartId") String cartId, Model model)
	{
		System.out.println("CartController - requestCartList : 해당 아이디의 장바구니 정보를 카트객체에 등록, 카트페이지 반환");
		Cart cart = cartService.read(cartId);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId)
	{
		System.out.println("CartController - read : 장바구니 정보 가져옴");
		return cartService.read(cartId);
	}
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)	//오류 응답 상태 코드 설정
	public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest req)
	{
		System.out.println("카트컨트롤러 addCartByNewItem 들어옴 - 장바구니에 상품추가");
		//장바구니ID 인 세션ID 가져오기
		String ssId = req.getSession(true).getId();
		//장바구니 등록된 모든 정보 얻어오기
		Cart cart = cartService.read(ssId);
		if(cart == null)
		{
			cart = cartService.create(new Cart(ssId));	//없으면 새로 만들어라
		}
		//경로변수 bookId에 대한 정보 얻어오기
		Book book = bookService.getBookById(bookId);
		if(book == null)
		{
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		//bookId에 대한 도서정보를 장바구니에 등록하기
		cart.addCartItem(new CartItem(book));
		//세션ID에 대한 장바구니 갱신하기
		cartService.update(ssId, cart);
	}
	
	@PutMapping("/remove/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)	//오류 응답 상태 코드 설정
	public void removeCartByItem(@PathVariable String bookId, HttpServletRequest req)
	{
		System.out.println("카트컨트롤러 removeCartByItem 들어옴 - 장바구니 상품삭제");
		String ssId = req.getSession(true).getId();	//장바구니ID 인 세션ID 가져오기
		Cart cart = cartService.read(ssId);	//장바구니 등록된 모든 정보 얻어오기
		
		if(cart == null)
		{
			cart = cartService.create(new Cart(ssId));	//없으면 새로 만들어라
		}
		//경로변수 bookId에 대한 정보 얻어오기
		Book book = bookService.getBookById(bookId);
		if(book == null)
		{
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		//bookId에 대한 도서정보를 장바구니에 등록하기
		cart.removeCartItem(new CartItem(book));
		//세션ID에 대한 장바구니 갱신하기
		cartService.update(ssId, cart);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCartList(@PathVariable(value="cartId") String cartId)
	{
		System.out.println("장바구니 목록 전체 삭제 함수");
		cartService.delete(cartId);
	}
}
