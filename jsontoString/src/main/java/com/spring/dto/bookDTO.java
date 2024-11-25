package com.spring.dto;

public class bookDTO 
{
	private String title;
	private int price;
	private String company;
	private int page;
	

	public bookDTO(String title, int price, String company, int page) 
	{
		super();
		this.title = title;
		this.price = price;
		this.company = company;
		this.page = page;
	}
	public bookDTO() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 객체 --> 문자열로 출력하는 구문
	@Override
	public String toString() //객체를 문자열로 리턴해줌
	{
		return "bookDTO [title=" + title + ", price=" + price + ", company=" + company + ", page=" + page + "]";
	}

}
