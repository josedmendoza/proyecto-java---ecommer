package com.project.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.ecommerce.model.User;

public class ShoppingCartDto {
	
	private Integer idCart;

	@JsonIgnoreProperties(value = {"listBill","shoppingCart"})
	private User user;

	public ShoppingCartDto() {
	}

	public ShoppingCartDto(Integer idCart, User user) {
		this.idCart = idCart;
		this.user = user;
	}

	public Integer getIdCart() {
		return idCart;
	}

	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
