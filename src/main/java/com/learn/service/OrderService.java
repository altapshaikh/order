package com.learn.service;

import java.util.List;

import com.learn.bean.OrderBean;

public interface OrderService {
	public String createOrder(OrderBean[] orderBean);

	public OrderBean getOrderById(Integer order_id) throws Exception;

	public List<OrderBean> getAllOrders() throws Exception;
}
