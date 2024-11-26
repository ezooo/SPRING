package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
import com.springmvc.exception.CartException;
import com.springmvc.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart create(Cart cart) 
	{
		System.out.println("CartServiceImpl - create in ");
		return cartRepository.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		System.out.println("CartServiceImpl - read in ");
		return cartRepository.read(cartId);
	}
	
	public void update(String cartId, Cart cart)
	{
		cartRepository.update(cartId, cart);
	}

	@Override
	public void delete(String cartId) 
	{
		System.out.println("북서비스 델리트");
		cartRepository.delete(cartId);
	}

	@Override
	public Cart validateCart(String cartId) 
	{	//장바구니 유효성 검사 - 예외처리
		System.out.println("북서비스 validateCart");
		Cart cart = cartRepository.read(cartId);
		System.out.println("돌아옴");
		if(cart == null || cart.getCartItems().size() == 0)
		{
			System.out.println("북서비스 validateCart - 카트가 비었다 : 예외처리");
			throw new CartException(cartId);
		}
		System.out.println(cart);
		System.out.println("리턴할거");
		return cart;
	}
}
