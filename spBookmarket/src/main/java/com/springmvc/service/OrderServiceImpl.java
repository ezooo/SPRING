package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.domain.Order;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;
	
	@Override
	public void confirmOrder(String bookId, long quantity) 
	{
		System.out.println("OrderServiceImpl confirmOrder in");
		Book bookById = bookRepository.getBookById(bookId);
		if(bookById.getUnitsInStock() < quantity)
		{
			System.out.println("OrderServiceImpl confirmOrder 재고부족");
			throw new IllegalArgumentException("품절입니다. 사용 가능한 재고 수 : "+bookById.getUnitsInStock());
		}
		bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
		System.out.println("OrderServiceImpl confirmOrder 재고 수 업데이트");
	}

	@Override
	public Long saveOrder(Order order) 
	{
		System.out.println("OrderServiceImpl saveOrder in");
		Long orderId = orderRepository.saveOrder(order);
		System.out.println("OrderServiceImpl saveOrder : orderRepository.saveOrder() 다녀옴");
		cartService.delete(order.getCart().getCartId());
		System.out.println("주문했으면 카트 삭제");
		return orderId;
	}

}
