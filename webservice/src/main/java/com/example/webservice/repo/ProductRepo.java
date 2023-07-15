package com.example.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.webservice.model.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends JpaRepository<Product, Long> {
}
