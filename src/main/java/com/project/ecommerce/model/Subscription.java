package com.project.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SUBSCRIPTION")
	private Integer idSubscription;

	private String type;

	private String description;

	private float price;

	private Integer stock;

	@Column(name = "CREATION_DATE")
	private LocalDateTime creationDate = LocalDateTime.now();

	
	@OneToMany(mappedBy = "subscription")
	List<ListProductCart> listShoppingCart;
	
	public Subscription() {
	}

	public Subscription(Integer idSubscription, String type, String description, float price, Integer stock,
			LocalDateTime creationDate, List<ListProductCart> listShoppingCart) {
		this.idSubscription = idSubscription;
		this.type = type;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.creationDate = creationDate;
		this.listShoppingCart = listShoppingCart;
	}

	@Override
	public String toString() {
		return "Subscription [idSubscription=" + idSubscription + ", type=" + type + ", description=" + description
				+ ", price=" + price + ", stock=" + stock + ", creationDate=" + creationDate + ", listShoppingCart="
				+ listShoppingCart + "]";
	}

	

	

}
