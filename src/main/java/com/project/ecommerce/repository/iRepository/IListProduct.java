package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.ListProduct;

public interface IListProduct extends JpaRepository<ListProduct, Integer> {

}
