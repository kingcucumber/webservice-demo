package com.demo.bean.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;

import com.demo.bean.Order;
import com.demo.service.OrderService;

@Stateless
@Remote(OrderService.class)
public class OrderServiceBean implements OrderService {

	// @WebMethod
	public String getUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order getOrder(String orderid) {

		Order order = new Order();
		order.setOrderid(orderid);
		order.setName("little birds");
		return order;
	}

	public List<Order> getOrders() {
		List<Order> persons = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setName("one");
		order1.setOrderid("001");

		Order order2 = new Order();
		order2.setName("two");
		order2.setOrderid("002");

		persons.add(order2);
		persons.add(order1);
		return persons;
	}

}
