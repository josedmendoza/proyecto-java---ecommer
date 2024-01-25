package com.project.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.repository.iRepository.IBillProduct;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BillProductRepository {

	private final IBillProduct billProduct;


	public Optional<BillProduct> findById(Integer idBill) {
		return billProduct.findById(idBill);
	}

}
