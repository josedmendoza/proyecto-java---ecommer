package com.project.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.repository.iRepository.ISubscriptionRepostory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SubscriptionRepository {
	
	private final ISubscriptionRepostory iSubscriptionRepostory;
	
	public Optional<Subscription> findById (Integer idSubscription) {
		return iSubscriptionRepostory.findById(idSubscription);
	}
	
	public boolean exists(Integer idSubscription) {
		return iSubscriptionRepostory.existsById(idSubscription);
		
	}
	
	public Subscription updateStockLPC(Integer id, Integer stock) {
		Subscription find = iSubscriptionRepostory.findById(id).orElse(null);
		find.setStock(stock);
		return iSubscriptionRepostory.save(find);
	}

}
