package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
