package com.demo.bean;

import java.io.Serializable;

public class Order implements Serializable {
	private String orderid;
	private String name;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
