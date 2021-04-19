package com.learn.dao;

import java.util.List;

import com.learn.bean.OrderBean;
import com.learn.entity.OrderEntity;

public interface OrderDao {
	public String registerOrder(OrderBean[] orderBean);

	public OrderEntity findOrderById(Integer order_id) throws Exception;

	public List<OrderEntity> findAllOrders() throws Exception;
}
