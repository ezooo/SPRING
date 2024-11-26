package com.springmvc.domain;

import java.io.Serializable;

public class Order implements Serializable
{
	private static final long serialVersionUID = 4221771602900107933L;

	private Long orderId;
	private Cart cart;
	private Customer customer;
	private Shipping shipping;
	
	public Order() 
	{
		System.out.println("order 생성자");
		this.customer = new Customer();
		this.shipping = new Shipping();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	
	@Override
	public int hashCode() 
	{
		System.out.println("domain Order hashcode in");
		final int prime = 31;
		int result = 1;
		result = prime * result +( (orderId == null)? 0 : orderId.hashCode() );
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("domain Order equals in");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		
		if(orderId == null)
		{
			System.out.println("domain Order equals orderId 검사");
			if(other.orderId != null)
			{
				return false;
			}
		}
		else if(!orderId.equals(other.orderId))
		{
			return false;
		}
		
		return true;
	}
}
