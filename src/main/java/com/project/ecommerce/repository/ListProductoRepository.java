package com.project.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.ListProduct;
import com.project.ecommerce.repository.iRepository.IListProduct;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListProductoRepository {

	private final IListProduct iListProduct;
	
	public ListProduct create (ListProduct listProduct) {
		return iListProduct.save(listProduct);
	}
	
	public Optional<ListProduct> findId( Integer idListProduct) {
		return iListProduct.findById(idListProduct); 
	}
	
	public List<ListProduct> getAll(){
		return iListProduct.findAll();
	}
	
}
