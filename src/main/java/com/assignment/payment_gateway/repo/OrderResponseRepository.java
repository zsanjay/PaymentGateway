package com.assignment.payment_gateway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.payment_gateway.model.OrderDetailsResponse;

@Repository
public interface OrderResponseRepository extends CrudRepository<OrderDetailsResponse , Long>{

}
