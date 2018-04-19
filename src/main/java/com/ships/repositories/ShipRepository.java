package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;




@Repository
public interface ShipRepository extends CrudRepository<Ship, Integer> {
//	'findAll' is defined by default, no need to explicitly declare its signature
//	'save' is defined by default, no need to explicitly declare its signature
	
}
