//package com.project.ecommerce.model;
//
//import java.time.LocalDateTime;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "ORDER_PRODUCT")
//public class OrderProduct {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_ORDER_PRODUCT")
//	private Integer idOrderP;
//
//	@Column(name = "creation_date")
//	@JsonIgnore
//	private LocalDateTime creationDate = LocalDateTime.now();
//
//	@ManyToOne
//	@JoinColumn(name = "ID_BILL", insertable = false, updatable = false)
//	private BillProduct billP;
//
//	@ManyToOne
//	@JoinColumn(name = "ID_LIST_PRODUCT", insertable = false, updatable = false)
//	private ListProduct listProduct;
//	
//
//
//	public OrderProduct() {
//	}
//
//
//
//	public OrderProduct(Integer idOrderP, LocalDateTime creationDate, BillProduct billP, ListProduct listProduct) {
//		this.idOrderP = idOrderP;
//		this.creationDate = creationDate;
//		this.billP = billP;
//		this.listProduct = listProduct;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "OrderProduct [idOrderP=" + idOrderP + ", creationDate=" + creationDate + ", billP=" + billP
//				+ ", listProduct=" + listProduct + "]";
//	}
//
//
//	
//	
//	
//
//
//
//
//	
//	
//
//
//
//	
//	
//	
//
//}
