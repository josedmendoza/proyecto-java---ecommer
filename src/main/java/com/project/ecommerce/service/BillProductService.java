package com.project.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.repository.BillProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BillProductService {
	
	private final BillProductRepository billPRepository;
	
	public Optional<BillProduct> findId(Integer idBill){
		return billPRepository.findById(idBill);
	}

}
