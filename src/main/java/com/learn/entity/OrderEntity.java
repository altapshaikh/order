package com.learn.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "order_table")
public class OrderEntity {
	@Id
	@GeneratedValue
	@Column(name = "orderId")
	private int orderId;
	@Column(name = "orderDate")
	private Date orderDate;
	@Column(name = "orderStatus")
	private String orderStatus;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<ItemEntity> itemEntity;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<ItemEntity> getItemEntity() {
		return itemEntity;
	}

	public void setItemEntity(Set<ItemEntity> itemEntity) {
		this.itemEntity = itemEntity;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", itemEntity=" + itemEntity + "]";
	}
}
