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
@Table(name = "bill_product")
public class BillProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BILL")
	private Integer idBillG;
	
	@Column(name = "TOTAL_AMOUNT")
	private Integer totalAmount;
	
	@Column(name = "TOTAL_PRICE")
	private Integer totalPrice;
	
	@Column(name = "creation_date")
	@JsonIgnore
	private LocalDateTime creationDate = LocalDateTime.now();
	
//	@OneToMany(mappedBy = "billP")
//	private List<OrderProduct> orderProduct;
	
	@ManyToOne
	@JoinColumn(name = "DNI")
	private User user;
	
	@OneToMany(mappedBy = "billProduct")
	
	private List<ListProduct> listProducts;


	public BillProduct() {
	}


	public BillProduct(Integer idBillG, Integer totalAmount, Integer totalPrice, LocalDateTime creationDate, User user,
			List<ListProduct> listProducts) {
		this.idBillG = idBillG;
		this.totalAmount = totalAmount;
		this.totalPrice = totalPrice;
		this.creationDate = creationDate;
		this.user = user;
		this.listProducts = listProducts;
	}


	@Override
	public String toString() {
		return "BillProduct [idBillG=" + idBillG + ", totalAmount=" + totalAmount + ", totalPrice=" + totalPrice
				+ ", creationDate=" + creationDate + ", user=" + user + ", listProducts=" + listProducts + "]";
	}













	

	

	



	
	

}
