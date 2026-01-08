package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
