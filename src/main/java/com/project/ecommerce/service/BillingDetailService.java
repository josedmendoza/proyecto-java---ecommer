package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.model.BillingDetail;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.model.ListProductCart;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.repository.BillingDetailRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BillingDetailService {

	private final BillingDetailRepository billingDetailRepository;
	
	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	// Metodo para guardar los datos de los datos de la facturas los cuales se obtienen del json al generar la factura
	public List<BillingDetail> saveDetail(ShoppingCart  productsDetail, BillProduct bill) {
		
		List<BillingDetail> detailList = new ArrayList<>();
		for(ListProductCart listPCart : productsDetail.getListProductCart()) {
			BillingDetail detail = new BillingDetail();
			log.info("listPCart es: {}", listPCart);
			Game game = listPCart.getGame();
			Subscription subs = listPCart.getSubscription();
			if(game != null) {
				detail.setGame(listPCart.getGame());
				detail.setPrice(listPCart.getPrice());
				detail.setQuantity(listPCart.getQuantity());
				detail.setBillProduct(bill);
				detailList.add(detail);
				
			}else if(subs != null) {
				detail.setSubscription(listPCart.getSubscription());
				detail.setPrice(listPCart.getPrice());
				detail.setQuantity(listPCart.getQuantity());
				detail.setBillProduct(bill);
				detailList.add(detail);
			}
		}
		return billingDetailRepository.save(detailList);
	}
	
	
	
	public Optional<BillingDetail> getD(Integer idDetail) {
		return billingDetailRepository.findB(idDetail);
	}
	
}
