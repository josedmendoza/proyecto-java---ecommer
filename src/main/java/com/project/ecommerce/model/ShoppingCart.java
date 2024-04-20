package com.project.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SHOPPING_CART")
	private Integer idCart;

	@JsonIgnore
	@Column(name = "creation_date")
	private LocalDateTime creationDate = LocalDateTime.now();
	
	@OneToOne
	@JoinColumn(name = "DNI")
	private User user;
	
	@OneToMany(mappedBy = "shoppingCart")
	private List<ListProductCart> listProductCart;


	public ShoppingCart() {
	}


	public ShoppingCart(Integer idCart, LocalDateTime creationDate, User user, List<ListProductCart> listProductCart) {
		this.idCart = idCart;
		this.creationDate = creationDate;
		this.user = user;
		this.listProductCart = listProductCart;
	}


	@Override
	public String toString() {
		return "ShoppingCart [idCart=" + idCart + ", creationDate=" + creationDate + ", user=" + user
				+ ", listProductCart=" + listProductCart + "]";
	}




	


	


	


	


	

}
