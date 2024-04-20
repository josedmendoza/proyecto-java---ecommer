package com.project.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.model.Subscription;

@JsonInclude(value = Include.NON_NULL, content = Include.NON_NULL)
public class ListProductcartDto {
	
	@JsonIgnoreProperties(value = "listShoppingCart")
	private Game gameDto;
	
	@JsonIgnoreProperties(value = "listShoppingCart")
	private Subscription subscriptionDto;

	private Integer quantityDto;

	private float priceDto;
	
	@JsonIgnoreProperties(value = {"user", "listProductCart"})
	private ShoppingCart shoppingCartDto; 

	public ListProductcartDto() {
	}


	public ListProductcartDto(Game gameDto, Subscription subscriptionDto, Integer quantityDto, float priceDto,
			ShoppingCart shoppingCartDto) {
		this.gameDto = gameDto;
		this.subscriptionDto = subscriptionDto;
		this.quantityDto = quantityDto;
		this.priceDto = priceDto;
		this.shoppingCartDto = shoppingCartDto;
	}


	public Game getGameDto() {
		return gameDto;
	}


	public void setGameDto(Game gameDto) {
		this.gameDto = gameDto;
	}
//
//
	public Subscription getSubscriptionDto() {
		return subscriptionDto;
	}


	public void setSubscriptionDto(Subscription subscriptionDto) {
		this.subscriptionDto = subscriptionDto;
	}


	public Integer getQuantityDto() {
		return quantityDto;
	}


	public void setQuantityDto(Integer quantityDto) {
		this.quantityDto = quantityDto;
	}


	public float getPriceDto() {
		return priceDto;
	}


	public void setPriceDto(float priceDto) {
		this.priceDto = priceDto;
	}


	public ShoppingCart getShoppingCartDto() {
		return shoppingCartDto;
	}


	public void setShoppingCartDto(ShoppingCart shoppingCartDto) {
		this.shoppingCartDto = shoppingCartDto;
	}

	
	

	

	

	

}
