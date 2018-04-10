package com.ships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class shipController {
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips() {
		return "";
	} // end showShips
} // end class shipController
