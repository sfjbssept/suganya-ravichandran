package com.example.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entities.ProductsManagementEntity;

public interface ProductManagementRepo extends JpaRepository<ProductsManagementEntity, Integer> {

}
