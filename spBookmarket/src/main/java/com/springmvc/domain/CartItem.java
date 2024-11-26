package com.springmvc.domain;

import java.io.Serializable;

public class CartItem implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2220274791589791282L;
	
	private Book book;
	private int quantity;	//장바구니 담긴 물건 갯수
	private int totalPrice;
	
	public CartItem() {}
	
	public CartItem(Book book)
	{
		super();
		this.book = book;
		this.quantity = 1;
		this.totalPrice = book.getUnitPrice();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() 
	{
		System.out.println("cartitem - updateTotalPrice in");
		totalPrice = this.book.getUnitPrice() * this.quantity;
		System.out.println("totalPrice = "+totalPrice);
	}

	@Override
	public int hashCode() 
	{
		System.out.println("cartitem - hashCode in");
		final int prime = 31;
		int result = 1;
		result = prime*result + (book==null? 0:book.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("cartitem - equals in");
		if(this == obj) { return true; }	//받아온객체가 카트아이템이면 트루 -- 바로 돌아감
		if(obj == null) { return false; }	//받아온 객체가 비었으면 false
		if(getClass() != obj.getClass()) { return false; }
		System.out.println("cartitem - equals 받은 객체가 카트아이템 아니고 안비었다 : other 변수에 객체담음");
		CartItem other = (CartItem)obj;
		if(book == null)
		{
			System.out.println("북이 비었다");
			if(other.book != null) { return false; }
		}
		else if(!book.equals(other.book))
		{
			return false;
		}
		return true;
	}
}
