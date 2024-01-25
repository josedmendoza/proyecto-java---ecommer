package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.BillProduct;

public interface IBillProduct extends JpaRepository<BillProduct, Integer> {

}
