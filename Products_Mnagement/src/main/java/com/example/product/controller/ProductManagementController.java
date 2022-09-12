package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entities.ProductsManagementEntity;
import com.example.product.services.ProductManagementService;

@RestController
public class ProductManagementController {
	
	@Autowired
	ProductManagementService productService;
	
	@PostMapping
	public String addProduct(@RequestBody ProductsManagementEntity product) {
		
		productService.addProduct(product);
		
		return "products saved";
		
	}
	
	

}
