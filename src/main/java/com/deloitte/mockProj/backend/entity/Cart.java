package com.deloitte.mockProj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cart",schema="de_kart")
@Entity
public class Cart {
	
	
	@Id
	private int user_id;
	
	@Column
	private String cart_details;
	
	public Cart() {
		super();
	}

	public Cart(int user_id, String cart_details) {
		super();
		this.user_id = user_id;
		this.cart_details = cart_details;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCart_details() {
		return cart_details;
	}

	public void setCart_details(String cart_details) {
		this.cart_details = cart_details;
	}

	@Override
	public String toString() {
		return "Cart [user_id=" + user_id + ", cart_details=" + cart_details + "]";
	}
	
}
