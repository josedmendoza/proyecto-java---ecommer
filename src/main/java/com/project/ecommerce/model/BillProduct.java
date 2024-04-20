package com.project.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


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


@JsonInclude(value = Include.NON_NULL,content = Include.NON_NULL)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBillG")
@Getter
@Setter
@Entity
@Table(name = "bill_product")
public class BillProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BILL")
	private Integer idBillG;
	
	@Column(name = "TOTAL_quantity")
	private Integer totalquantity;
	
	@Column(name = "TOTAL_PRICE")
	private Float totalPrice;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate = LocalDateTime.now();
	
	
	@JsonIgnoreProperties(value = {"shoppingCart","listBill"})
	@ManyToOne
	@JoinColumn(name = "DNI")
	private User user;
	
	@JsonIgnoreProperties(value = {"billProduct","idBillingDetail","creationDate"})
	@OneToMany(mappedBy = "billProduct")
	private List<BillingDetail> detail;
	

	public BillProduct() {
	}


	public BillProduct(Integer idBillG, Integer totalquantity, Float totalPrice, LocalDateTime creationDate, User user,
			List<BillingDetail> detail) {
		this.idBillG = idBillG;
		this.totalquantity = totalquantity;
		this.totalPrice = totalPrice;
		this.creationDate = creationDate;
		this.user = user;
		this.detail = detail;
	}

	
	

//	@Override
//	public String toString() {
//		return "BillProduct [idBillG=" + idBillG + ", totalquantity=" + totalquantity + ", totalPrice=" + totalPrice
//				+ ", creationDate=" + creationDate + ", user=" + user + ", detail=" + detail + "]";
//	}













	

	

	



	
	

}
