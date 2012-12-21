package com.demo.service;

import java.util.List;

import com.demo.bean.Order;

public interface OrderService {
	public String getUserName(String name);
	public Order getOrder(String orderid);
	public List<Order> getOrders();
	
}
