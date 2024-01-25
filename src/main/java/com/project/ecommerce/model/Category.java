package com.project.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCategory")
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORY")
	private Integer idCategory;
	
	@Column (name = "CLASSIFICATION")
	private String classification;
	
	@Column(name = "CREATION_DATE")
	@JsonIgnore
	private LocalDateTime creationDate = LocalDateTime.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
//	@JsonBackReference
	List<Game> listGame;

	public Category() {
	}

	public Category(Integer idCategory, String classification, LocalDateTime creationDate, List<Game> listGame) {
		this.idCategory = idCategory;
		this.classification = classification;
		this.creationDate = creationDate;
		this.listGame = listGame;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", classification=" + classification + ", creationDate="
				+ creationDate + ", listGame=" + listGame + "]";
	}


	
	
	
}
