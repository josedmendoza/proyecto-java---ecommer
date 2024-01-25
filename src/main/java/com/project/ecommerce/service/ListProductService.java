package com.project.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.ListProduct;
import com.project.ecommerce.repository.ListProductoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListProductService {

	private final ListProductoRepository listProductoRepository;
	
	public ListProduct createListP (ListProduct listProduct) {
		return listProductoRepository.create(listProduct);
	}
	
	public Optional<?> findListById(Integer idListProduct){
		return listProductoRepository.findId(idListProduct);
	}
	
	public List<ListProduct> getList(){
		return listProductoRepository.getAll();
	}
} 
