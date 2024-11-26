package com.springmvc.exception;

public class CartException extends RuntimeException
{
	private static final long serialVersionUID = 6457077274469537785L;
	private String cartId;
	
	public CartException(String cartId) 
	{
		System.out.println("CartException 생성자 in");
		this.cartId = cartId;
	}

	public String getCartId() 
	{
		System.out.println("CartException cartId 리턴");
		return cartId;
	}
}
