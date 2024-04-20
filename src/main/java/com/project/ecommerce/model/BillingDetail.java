package com.project.ecommerce.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

@JsonInclude(value = Include.NON_NULL,content = Include.NON_NULL)
@Getter @Setter
@Entity
@JsonPropertyOrder({ "idBillingDetail","billProduct", "game", "subscription", "quantity", "price"})
@Table(name = "BILLING_DETAIL")
public class BillingDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BILLING_DETAIL")
	private Integer idBillingDetail;

	private Integer quantity;
	
	private float price;

	@Column(name = "CREATION_DATE")
	private LocalDate creationDate = LocalDate.now();

	@ManyToOne
	@JsonIgnoreProperties(value = {"category", "releaseDate", "description" ,"stock", "price","listShoppingCart","creationDate" })
	@JoinColumn(name = "ID_GAME")
	private Game game;

	@ManyToOne
	@JsonIgnoreProperties(value = { "description","price","listShoppingCart"})
	@JoinColumn(name = "ID_SUBSCRIPTION")
	private Subscription subscription;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"totalquantity", "totalPrice"})
	@JoinColumn(name = "ID_BILL")
	private BillProduct billProduct;

	public BillingDetail() {
	}

	public BillingDetail(Integer idBillingDetail, Integer quantity, float price, LocalDate creationDate, Game game,
			Subscription subscription, BillProduct billProduct) {
		this.idBillingDetail = idBillingDetail;
		this.quantity = quantity;
		this.price = price;
		this.creationDate = creationDate;
		this.game = game;
		this.subscription = subscription;
		this.billProduct = billProduct;
	}

	@Override
	public String toString() {
		return "BillingDetail [idBillingDetail=" + idBillingDetail + ", quantity=" + quantity + ", price=" + price
				+ ", creationDate=" + creationDate + ", game=" + game + ", subscription=" + subscription
				+ ", billProduct=" + billProduct + "]";
	}
	
	
}
