package com.learn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_table")
public class ItemEntity {
	@Id
	@GeneratedValue
	@Column(name = "itemId")
	private int itemId;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "itemUnitPrice")
	private String itemUnitPrice;
	@Column(name = "itemQuantity")
	private int itemQuantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private OrderEntity order;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setItemUnitPrice(String itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public OrderEntity getOrderEntity() {
		return order;
	}

	public void setOrderEntity(OrderEntity order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "ItemEntity [itemId=" + itemId + ", itemName=" + itemName + ", itemUnitPrice=" + itemUnitPrice
				+ ", itemQuantity=" + itemQuantity + ", orderEntity=" + order + "]";
	}
}
