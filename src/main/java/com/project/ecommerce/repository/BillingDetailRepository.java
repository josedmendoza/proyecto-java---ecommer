package com.project.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.BillingDetail;
import com.project.ecommerce.repository.iRepository.IBillingDetail;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BillingDetailRepository {

	
	private final IBillingDetail iBillingDetail;

	public List<BillingDetail> save(List<BillingDetail> detail) {
		return iBillingDetail.saveAll(detail);
	}
	
	public Optional<BillingDetail> findB(Integer idDetail) {
		return iBillingDetail.findById(idDetail);
	}
	
}
