package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
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
}
