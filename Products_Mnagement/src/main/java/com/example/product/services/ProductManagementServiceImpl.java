package com.example.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entities.ProductsManagementEntity;
import com.example.product.repo.ProductManagementRepo;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {
	
	@Autowired
	ProductManagementRepo repo;
	
	@Override
	public Integer addProduct(ProductsManagementEntity product) {
		
		ProductsManagementEntity product1 = repo.save(product);
		return product1.getId();
	}

}
