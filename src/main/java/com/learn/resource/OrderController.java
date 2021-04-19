package com.learn.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bean.OrderBean;
import com.learn.service.OrderService;
import com.learn.util.OrderException;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/create")
	public ResponseEntity<String> storeOrder(@RequestBody OrderBean[] orderBean) {
		String createOrder = orderService.createOrder(orderBean);
		return ResponseEntity.ok(createOrder);
	}

	@GetMapping(value = "{order_id}")
	public ResponseEntity<OrderBean> getOrder(@PathVariable("order_id") String order_id) {
		OrderBean orderById = null;
		try {
			orderById = orderService.getOrderById(Integer.parseInt(order_id));
		} catch (Exception e) {
			throw new OrderException("Order id is not valid ");
		}
		return ResponseEntity.ok(orderById);
	}

	@GetMapping(value = "/orders")
	public ResponseEntity<List<OrderBean>> getAllOrder() {
		List<OrderBean> allOrders;
		try {
			allOrders = orderService.getAllOrders();
		} catch (Exception e) {
			throw new OrderException("Orders not available ");
		}
		return ResponseEntity.ok(allOrders);
	}
}
