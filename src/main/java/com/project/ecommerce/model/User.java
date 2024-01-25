package com.project.ecommerce.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	private Integer dni;

	@Column(name = "FIRTS_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	private String direction;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	private Integer Age;

	private Integer telf;

	private String mail;

	@JsonIgnore
	@Column(name = "CREATION_DATE")
	private LocalDate creationDate = LocalDate.now();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<BillProduct> listBill;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<ListProduct> listProduct;

	public User() {
	}

	public User(Integer dni, String firstName, String lastName, String direction, Date birthDate, Integer age,
			Integer telf, String mail, LocalDate creationDate, List<BillProduct> listBill,
			List<ListProduct> listProduct) {
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.direction = direction;
		this.birthDate = birthDate;
		Age = age;
		this.telf = telf;
		this.mail = mail;
		this.creationDate = creationDate;
		this.listBill = listBill;
		this.listProduct = listProduct;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", firstName=" + firstName + ", lastName=" + lastName + ", direction=" + direction
				+ ", birthDate=" + birthDate + ", Age=" + Age + ", telf=" + telf + ", mail=" + mail + ", creationDate="
				+ creationDate + ", listBill=" + listBill + ", listProduct=" + listProduct + "]";
	}



	

}
