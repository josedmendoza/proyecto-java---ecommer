package com.project.ecommerce.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@JsonInclude(value = Include.NON_NULL, content = Include.NON_NULL)
@Table(name = "LIST_PRODUCT_CART")
public class ListProductCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIST_PRODUCT_CART")
	private Integer idListProductcart;

	private Integer quantity;

	private float price;

	
	@Column(name = "creation_date")
	private LocalDateTime creationDate = LocalDateTime.now();

	@JsonIgnoreProperties(value = "listShoppingCart")
	@ManyToOne
	@JoinColumn(name = "ID_GAME")
	private Game game;

	@JsonIgnoreProperties(value = "listShoppingCart")
	@ManyToOne
	@JoinColumn(name = "ID_SUBSCRIPTION")
	private Subscription subscription;

	@JsonIgnoreProperties(value = {"user", "listProductCart"})
	@ManyToOne
	@JoinColumn(name = "ID_SHOPPING_CART")
	private ShoppingCart shoppingCart;

	public ListProductCart() {
	}

	public ListProductCart(Integer idListProductcart, Integer quantity, float price, LocalDateTime creationDate,
			Game game, Subscription subscription, ShoppingCart shoppingCart) {
		this.idListProductcart = idListProductcart;
		this.quantity = quantity;
		this.price = price;
		this.creationDate = creationDate;
		this.game = game;
		this.subscription = subscription;
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String toString() {
		return "ListProductCart [idListProductcart=" + idListProductcart + ", quantity=" + quantity + ", price=" + price
				+ ", creationDate=" + creationDate + ", game=" + game + ", subscription=" + subscription
				+ ", shoppingCart=" + shoppingCart + "]";
	}

	
}
