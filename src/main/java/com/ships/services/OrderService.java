package com.ships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderRepository;




@Service
public class OrderService {
//	Fields
	@Autowired
	private OrderRepository orderRepository;
	
	
	
	
//	Methods
	public Iterable<OrderInfo> findAll() {
		return orderRepository.findAll();
		
	}
	
} // end class ShipService
