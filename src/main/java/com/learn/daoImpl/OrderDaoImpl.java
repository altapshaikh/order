package com.learn.daoImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.bean.OrderBean;
import com.learn.dao.OrderDao;
import com.learn.entity.ItemEntity;
import com.learn.entity.OrderEntity;
import com.learn.repo.OrderRepository;

@Component

public class OrderDaoImpl implements OrderDao {
	@Autowired
	private OrderRepository orderRepository;
	private OrderEntity save;

	@Override
	public String registerOrder(OrderBean[] orderBean) {
		List<OrderBean> asList = Arrays.asList(orderBean);
		String msg = "";

		asList.forEach(data -> {
			Set<ItemEntity> itemEntitySet = new HashSet();
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setOrderStatus("success");
			orderEntity.setOrderDate(data.getOrderDate());
			data.getItems().forEach(data1 -> {
				ItemEntity itemEntity = new ItemEntity();
				itemEntity.setItemName(data1.getItemName());
				itemEntity.setItemQuantity(data1.getItemQuantity());
				itemEntity.setItemUnitPrice(data1.getItemUnitPrice());
				itemEntity.setOrderEntity(orderEntity);
				itemEntitySet.add(itemEntity);
			});
			orderEntity.setItemEntity(itemEntitySet);
			save = orderRepository.save(orderEntity);
		});
		if (save.getOrderId() > 0) {
			return msg = "record created successfully.............";
		} else {
			return msg = "record not created .............";
		}
	}

	@Override
	public OrderEntity findOrderById(Integer order_id) throws Exception {
		Optional<OrderEntity> findById = orderRepository.findById(order_id);
		return findById.get();
	}

	@Override
	public List<OrderEntity> findAllOrders() throws Exception {
		List<OrderEntity> findAll = (List<OrderEntity>) orderRepository.findAll();
		return findAll;
	}
}
