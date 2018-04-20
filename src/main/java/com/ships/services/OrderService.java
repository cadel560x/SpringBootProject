package com.ships.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderRepository;




@Service
public class OrderService {
//	Fields
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShipService shipService;
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	
	
	
//	Methods
	public Iterable<OrderInfo> findAll() {
		return orderRepository.findAll();
		
	} // end findAll()
	
	
	public String save(OrderInfo orderInfo) {
		String msg = "";
		BigDecimal shipCost, shippingCompanyBalance, newBalance;
		
		shipCost = orderInfo.getShip().getCost();
		shippingCompanyBalance = orderInfo.getShippingCompany().getBalance();
		
		if ( shipCost.compareTo(shippingCompanyBalance) > 0 ) {
			return "Shipping company balance is less than cost of ship - Cannot place order";
		}
		
		// Reference: http://www.java2s.com/Tutorials/Java/Date/Date_Format/Format_date_in_yyyyMMdd_format_in_Java.htm
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// Set 'orderInfo' date
	    orderInfo.setDate(formatter.format(new Date()));
		orderRepository.save(orderInfo);
		
		// the 'save' method knows when it has to do an 'INSERT' or an 'UPDATE'
		// In this case is updating the 'ship' with 'orderInfo.getShip()'
		orderInfo.getShip().setShippingCompany(orderInfo.getShippingCompany());
		shipService.save(orderInfo.getShip());
		
		// Update 'shipping_company' with 'orderInfo.getShippingCompany()' new balance
		newBalance = shippingCompanyBalance.subtract(shipCost);
		orderInfo.getShippingCompany().setBalance(newBalance);
		shippingCompanyService.save(orderInfo.getShippingCompany());
		
		// Return 'msg' empty; that means everything is Ok
		return msg;
		
	} // end save(ShippingCompany shippingCompany)
	
} // end class OrderService
