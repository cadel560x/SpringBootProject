package com.ships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ships.model.Ship;
import com.ships.services.ShipService;




@SessionAttributes({"ship","ships"})
@Controller
public class ShipController {
//	Fields
	@Autowired
	private ShipService shipService;
	
	
	
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips(Model model) {
		Iterable<Ship> ships = shipService.findAll();
		model.addAttribute("ships", ships);
		
		return "showShips";
		
	} // end showShips
	
} // end class shipController
