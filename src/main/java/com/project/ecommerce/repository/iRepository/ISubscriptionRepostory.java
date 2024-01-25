package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Subscription;

public interface ISubscriptionRepostory extends JpaRepository<Subscription, Integer> {

}
