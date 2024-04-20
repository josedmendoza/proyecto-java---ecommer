package com.project.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.repository.iRepository.IBillProduct;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BillProductRepository {

	private final IBillProduct iBillProduct;

	public Optional<BillProduct> findById(Integer idBill) {
		return iBillProduct.findById(idBill);
	}

	public BillProduct updateBillH(BillProduct header, Float price, Integer Quantity) {

		BillProduct findB = iBillProduct.findById(header.getIdBillG()).orElse(null);

		findB.setTotalPrice(price);
		findB.setTotalquantity(Quantity);

		return iBillProduct.save(findB);

	}

	public BillProduct create(BillProduct data) {
		return iBillProduct.save(data);
	}

}
