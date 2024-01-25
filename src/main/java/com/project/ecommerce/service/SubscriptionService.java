package com.project.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
	
	private final SubscriptionRepository subsRepository;
	
	
//	public Subscription createSu(Subscription subscription) {
//		return subsRepository.save(subscription);
//	}
	
	public Optional<Subscription> getSu(int idSubscription){
			return subsRepository.findById(idSubscription);
	}
	
	public boolean validation (Integer idSubscription) {
		return subsRepository.exists(idSubscription);
	}
	
//	public Subscription updateSu(int idSubscription, Subscription subscription) {
//		Subscription find = subsRepository.findById(idSubscription).
//				orElseThrow(()-> new RuntimeException());
//		
//		find.setType(subscription.getType());
//		find.setDescription(subscription.getDescription());
//		find.setPrice(subscription.getPrice());
//		find.setStock(subscription.getStock());
//		
//		return subsRepository.save(find);
//		
//	}

}
