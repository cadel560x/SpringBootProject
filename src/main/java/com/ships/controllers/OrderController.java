package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;




@SessionAttributes({"order","orders"})
@Controller
public class OrderController {
//	Fields
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShipService shipService;
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	
	
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String showOrders(Model model) {
		Iterable<OrderInfo> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		
		return "showOrders";
		
	} // end showOrders
	
	
	@RequestMapping(value = "/createOrder", method=RequestMethod.GET)
	public String createOrderGet(Model model) {
		OrderInfo orderInfo = new OrderInfo();
		model.addAttribute("orderInfo", orderInfo);
		
		// Get available ships
		Iterable<Ship> ships = (ArrayList<Ship>) shipService.findByShippingCompanyIsNull();
		Map<Ship,String> shipList = new HashMap<Ship,String>();
		
		String label = "";
		for (Ship ship : ships) {
			label = ship.getName() + "; Cost=" + ship.getCost();
			shipList.put(ship, label);
		}
		
		model.addAttribute("shipList", shipList);
		
		// Get shipping companies
		Iterable<ShippingCompany> shippingCompanies = (ArrayList<ShippingCompany>) shippingCompanyService.findAll();
		Map<ShippingCompany, String> shippingCompanyList = new HashMap<ShippingCompany, String>();

		for (ShippingCompany shippingCompany : shippingCompanies) {
			label = shippingCompany.getName() + "; Balance=" + shippingCompany.getBalance();
			shippingCompanyList.put(shippingCompany, label);
		}
		
		model.addAttribute("shippingCompanyList", shippingCompanyList);
		
		return "createOrder";
		
	} // end createOrderGet
	
	
	@RequestMapping(value = "/createOrder", method=RequestMethod.POST)
	public String createOrderPost(@ModelAttribute("orderInfo") OrderInfo orderInfo, Model model) {
		String ret;
		
		// Validates if a ship and a shipping company were selected
		if ( orderInfo.getShip() == null || orderInfo.getShippingCompany() == null ) {
			ret = "No ship and/nor shipping company selected";
			model.addAttribute("errorMessage", ret);
			
			return "errorCreateOrder";
		}
		
		
		// Sends the 'OrderInfo' object to the service for its storage
		ret = orderService.save(orderInfo);
		if ( ret.isEmpty() ) {
			return "redirect:showOrders";
		}
		else {
			// If there is a message in 'ret', is an error
			model.addAttribute("errorMessage", ret);
			
			return "errorCreateOrder";
		}
		
	} // end createOrderPost
	
} // end class OrderController
