package com.project.ecommerce.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


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

@Getter @Setter
@Entity
@Table(name = "GAME")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GAME")
	private Integer idGame;
	
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private float price;

	@Column(name = "STOCK")
	private Integer stock;
	
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	
	@Column(name = "CREATION_DATE")
	private LocalDateTime creationDate = LocalDateTime.now();
	
	
	@OneToMany(mappedBy = "game")
	 List<ListProductCart> listShoppingCart;
	
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY") // name corresponde al nombre de la FK 
	private Category category;

	public Game() {
	}

	public Game(Integer idGame, String name, String description, float price, Integer stock, Date releaseDate,
			LocalDateTime creationDate, List<ListProductCart> listShoppingCart, Category category) {
		this.idGame = idGame;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.releaseDate = releaseDate;
		this.creationDate = creationDate;
		this.listShoppingCart = listShoppingCart;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", releaseDate=" + releaseDate + ", creationDate=" + creationDate
				+ ", listShoppingCart=" + listShoppingCart + ", category=" + category + "]";
	}

	


	
}
