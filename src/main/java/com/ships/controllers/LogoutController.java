package com.ships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;




@SessionAttributes({"ship","ships"})
@Controller
public class LogoutController {
//	Fields
	
	
	
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logoutGet() {
		return "logout";
		
	} // end logoutGet
	
	
	@RequestMapping(value = "/logout", method=RequestMethod.POST)
	public String logoutPost() {
		return "logout";

		
	} // end logoutPost
	
} // end class shipController
