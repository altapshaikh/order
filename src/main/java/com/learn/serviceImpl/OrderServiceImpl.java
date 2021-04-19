package com.learn.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.IteamBean;
import com.learn.bean.OrderBean;
import com.learn.dao.OrderDao;
import com.learn.entity.OrderEntity;
import com.learn.service.OrderService;
import com.learn.util.OrderException;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;

	@Override
	public String createOrder(OrderBean[] orderBean) {
		String registerOrder = dao.registerOrder(orderBean);
		return registerOrder;
	}

	@Override
	public OrderBean getOrderById(Integer order_id) throws Exception {
		OrderBean orderBean = new OrderBean();
		OrderEntity findOrderById = dao.findOrderById(order_id);
		List<IteamBean> itemList = new ArrayList<IteamBean>();
		findOrderById.getItemEntity().forEach(data -> {
			IteamBean itemBean = new IteamBean();
			BeanUtils.copyProperties(data, itemBean);
			itemList.add(itemBean);
		});
		orderBean.setOrderDate(findOrderById.getOrderDate());
		orderBean.setOrderId(findOrderById.getOrderId());
		orderBean.setOrderStatus(findOrderById.getOrderStatus());
		orderBean.setItems(itemList);
		return orderBean;
	}

	@Override
	public List<OrderBean> getAllOrders() throws Exception {
		List<OrderEntity> findAllOrders = dao.findAllOrders();
		List<OrderBean> listBean = new ArrayList<OrderBean>();
		findAllOrders.forEach(data -> {
			OrderBean orderBean = new OrderBean();
			orderBean.setOrderDate(data.getOrderDate());
			orderBean.setOrderId(data.getOrderId());
			orderBean.setOrderStatus(data.getOrderStatus());
			List<IteamBean> itemList = new ArrayList<IteamBean>();
			data.getItemEntity().forEach(data1 -> {
				IteamBean itemBean = new IteamBean();
				BeanUtils.copyProperties(data1, itemBean);
				itemList.add(itemBean);
			});
			orderBean.setItems(itemList);
			listBean.add(orderBean);
		});
		if(listBean==null||listBean.isEmpty()) {
			throw new OrderException("Orders not available ");
		}
		return listBean;
	}
}
