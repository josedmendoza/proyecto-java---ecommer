//package com.project.ecommerce.model;
//
//import java.io.Serializable;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Embeddable
//public class ShoppingCartPk implements Serializable {
//	
//	@Column(name = "ID_SHOPPING_CART")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer idShoppingCart;
//	
//	@Column(name = "DNI")
//	private Integer idUser;
//
//	public ShoppingCartPk() {
//	}
//
//	public ShoppingCartPk(Integer idShoppingCart, Integer idUser) {
//		this.idShoppingCart = idShoppingCart;
//		this.idUser = idUser;
//	}
//	
//	
//
//}
