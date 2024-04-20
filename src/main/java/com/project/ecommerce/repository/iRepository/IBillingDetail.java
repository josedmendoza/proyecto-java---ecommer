package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.BillingDetail;

public interface IBillingDetail extends JpaRepository<BillingDetail, Integer> {

}
