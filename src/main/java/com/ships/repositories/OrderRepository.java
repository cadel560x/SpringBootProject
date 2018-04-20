package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.OrderInfo;




@Repository
public interface OrderRepository extends CrudRepository<OrderInfo, Integer> {
//	'findAll' is defined by default, no need to explicitly declare its signature
//	'save' is defined by default, no need to explicitly declare its signature
	
}
