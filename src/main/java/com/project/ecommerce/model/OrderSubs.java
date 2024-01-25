package com.project.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "ORDER_SUSCRIPTION")
public class OrderSubs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDER_SUS")
	private int idOrderSubs;

	private int amount;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

//	@ManyToOne
//	@JoinColumn(name = "DNI", insertable = false, updatable = false)
//	private User user;

//	@ManyToOne
//	@JoinColumn(name = "ID_SUBSCRIPTION", insertable = false, updatable = false)
//	private Subscription subscription;

	public OrderSubs() {
	}

	public OrderSubs(int idOrderSubs, int amount, LocalDateTime creationDate, User user, Subscription subscription) {
		this.idOrderSubs = idOrderSubs;
		this.amount = amount;
		this.creationDate = creationDate;
//		this.user = user;
//		this.subscription = subscription;
	}
	
	


}
