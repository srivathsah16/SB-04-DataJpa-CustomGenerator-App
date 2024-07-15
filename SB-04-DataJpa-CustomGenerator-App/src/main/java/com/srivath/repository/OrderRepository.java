package com.srivath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srivath.entity.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, String> {

}
