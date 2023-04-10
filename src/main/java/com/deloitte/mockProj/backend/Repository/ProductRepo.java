package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.mockProj.backend.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
