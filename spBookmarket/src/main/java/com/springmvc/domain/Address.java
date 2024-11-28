package com.springmvc.domain;

import java.io.Serializable;

public class Address implements Serializable
{
	private static final long serialVersionUID = -824607634067469239L;
	
	private String detailName;
	private String addressName;
	private String country;
	private String zipCode;
	
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public int hashCode() 
	{
		System.out.println("domain Address hashcode in");
		final int prime = 31;
		int result = 1;
		result = prime * result +( (addressName == null)? 0 : addressName.hashCode() );
		result = prime * result +( (country == null)? 0 : country.hashCode() );
		result = prime * result +( (detailName == null)? 0 : detailName.hashCode() );
		result = prime * result +( (zipCode == null)? 0 : zipCode.hashCode() );
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("domain Address equals in");
		if(this == obj) {return true;}
		if(obj == null) {return false;}
		if(getClass() != obj.getClass()) {return false;}

		Address other = (Address) obj;
		//addressName 검사
		if(addressName == null)
		{
			System.out.println("domain Address equals addressName 검사");
			if(other.addressName != null)
			{
				return false;
			}
		}
		else if(!addressName.equals(other.addressName))
		{
			return false;
		}
		//country 검사
		if(country == null)
		{
			System.out.println("domain Address equals country 검사");
			if(other.country != null)
			{
				return false;
			}
		}
		else if(!country.equals(other.country))
		{
			return false;
		}
		//detailName 검사
		if(detailName == null)
		{
			System.out.println("domain Address equals detailName 검사");
			if(other.detailName != null)
			{
				return false;
			}
		}
		else if(!detailName.equals(other.detailName))
		{
			return false;
		}
		//zipCode 검사
		if(zipCode == null)
		{
			System.out.println("domain Address equals zipCode 검사");
			if(other.zipCode != null)
			{
				return false;
			}
		}
		else if(!zipCode.equals(other.zipCode))
		{
			return false;
		}
		System.out.println("domain Address equals 검사 끝 리턴트루");
		return true;
	}

}
