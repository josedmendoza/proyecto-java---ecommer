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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "list_product")
public class ListProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID_LIST_PRODUCT")
	private Integer idListProduct;
	
	private Integer amount;
	
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "DNI")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "ID_GAME")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "ID_SUBSCRIPTION")
	private Subscription subscription;
	
	@Column(name = "creation_date")
	@JsonIgnore
	private LocalDateTime creationDate = LocalDateTime.now();
	
//	@OneToMany (mappedBy = "listProduct")
//	private List<OrderProduct> listOrderProducto;
	
	@ManyToOne
	@JoinColumn(name = "ID_BILL")
	@JsonIgnore
	private BillProduct billProduct;

	public ListProduct() {
	}

	public ListProduct(Integer idListProduct, Integer amount, float price, User user, Game game,
			Subscription subscription, BillProduct billProduct) {
		this.idListProduct = idListProduct;
		this.amount = amount;
		this.price = price;
		this.user = user;
		this.game = game;
		this.subscription = subscription;
		this.billProduct = billProduct;
	}

	@Override
	public String toString() {
		return "ListProduct [idListProduct=" + idListProduct + ", amount=" + amount + ", price=" + price + ", user="
				+ user + ", game=" + game + ", subscription=" + subscription + ", billProduct=" + billProduct + "]";
	}






	

	
	
	
	
	


	
	
	

}
