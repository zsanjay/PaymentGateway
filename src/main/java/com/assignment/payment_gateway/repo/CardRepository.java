package com.assignment.payment_gateway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.payment_gateway.model.CardDetails;

@Repository
public interface CardRepository extends CrudRepository<CardDetails, Long>{

}
