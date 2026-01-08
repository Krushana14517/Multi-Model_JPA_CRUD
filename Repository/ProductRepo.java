package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
