package com.ships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;




@Service
public class ShipService {
//	Fields
	@Autowired
	private ShipRepository shipRepository;
	
	
	
	
//	Methods
	public Iterable<Ship> findAll() {
		return shipRepository.findAll();
		
	}
	
} // end class ShipService
