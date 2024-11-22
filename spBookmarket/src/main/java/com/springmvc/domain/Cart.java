package com.springmvc.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart 
{
	private String cartId;	//장바구니 아이디
	private Map<String, CartItem> cartItems;	//장바구니 항목 (키:밸류 형태를 담는 변수)
	private int grandTotal;	//총액
	
	public Cart() 
	{
		super();
		cartItems = new HashMap<String, CartItem>();	//카트 새로 생길 때 카트 아이템 담을 맵도 같이 생성
		grandTotal = 0;
	}
	public Cart(String cartId) 
	{
		this();
		this.cartId = cartId;
	}
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Map<String, CartItem> getCartItems() {
		return cartItems;	//전체 카트 아이템 받아와라
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;	//파라미터로 아이템을 받으면 변수에 저장
	}
	public int getGrandTotal() {
		return grandTotal;
	}

	public void updateGrandTotal()
	{	//총액 업데이트 함수
		System.out.println("cart - updateGrandTotal in");
		grandTotal = 0;
		for(CartItem item : cartItems.values())
		{	//카트아이템 하나씩 꺼내서 값을 꺼내...? 뭔 밸류인데 ? 물건을 하나씩 꺼내고, 그 물건(item=book 객체 하나)으로 부터 가격 꺼냄
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}
	
	@Override
	public int hashCode() 
	{
		System.out.println("cart - hashCode in");
		final int prime = 31;
		int result = 1;
		result = prime*result + (cartId==null? 0 : cartId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("cart - equals in");
		if(this == obj) { return true; }	//받아온객체가 카트아이템이면 트루 -- 바로 돌아감
		if(obj == null) { return false; }	//받아온 객체가 비었으면 false
		if(getClass() != obj.getClass()) { return false; }
		System.out.println("cart - equals 받은 객체가 카트아이템 아니고 안비었다 : other 변수에 객체담음");
		Cart other = (Cart)obj;
		if(cartId == null)
		{
			System.out.println("북이 비었다");
			if(other.cartId != null) { return false; }
		}
		else if(!cartId.equals(other.cartId))
		{
			return false;
		}
		return true;
	}
	
	public void addCartItem(CartItem item)
	{
		System.out.println("domain Cart - addCartitem in");
		String bookId = item.getBook().getBookId();	//등록하기 위한 도서아이디 가져오기
		
		if(cartItems.containsKey(bookId))
		{//도서아이디가 카트아이템 객체에 등록되어있는지 확인
			CartItem cartItem = cartItems.get(bookId);	//도서주문 눌렀을 때 해당 도서 map에서 북아이디 찾아서 카트아이템 객체로 반환해줌
			cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
			cartItems.put(bookId, item);
		}
		else
		{
			cartItems.put(bookId, item);
		}
		updateGrandTotal();	//총액 갱신
	}
	
	public void removeCartItem(CartItem item)
	{
		System.out.println("domain Cart - removeCartItem in");
		String bookId = item.getBook().getBookId();	//등록하기 위한 도서아이디 가져오기
		//도서아이디가 카트아이템 객체에 등록되어있는지 확인
		cartItems.remove(bookId);	//bookId 도서 삭제
		updateGrandTotal();	//총액 갱신
	}
}
