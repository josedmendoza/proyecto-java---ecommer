package com.project.ecommerce.repository.iRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.BillProduct;

public interface IBillProduct extends JpaRepository<BillProduct, Integer> {

	@Query(value = "select * from bill_product where dni = :pidUser", nativeQuery = true)
	List<BillProduct> getId(@Param(value = "pidUser") Integer idUser);

}
