package com.springmvc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable
{
	private static final long serialVersionUID = -8923129427599533816L;
	
	private String customerId;
	private String name;
	private Address address;
	private String phone;
	
	public Customer() 
	{
		System.out.println("customer 기본생성자");
		this.address = new Address();
	}

	public Customer(String customerId, String name) 
	{
		this();
		System.out.println("customer 매개변수 있는 생성자");
		this.customerId = customerId;
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() 
	{
		System.out.println("domain Customer hashcode in");
		final int prime = 31;
		int result = 1;
		result = prime * result +( (customerId == null)? 0 : customerId.hashCode() );
		return Objects.hash(address, customerId, name, phone);
	}

	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("domain Customer equals in");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		
		if(customerId == null)
		{
			System.out.println("domain Customer equals customerId 검사");
			if(other.customerId != null)
			{
				return false;
			}
		}
		else if(!customerId.equals(other.customerId))
		{
			return false;
		}
		
		return true;
	}
	
}
