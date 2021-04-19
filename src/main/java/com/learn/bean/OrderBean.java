package com.learn.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderBean {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private int orderId;
	private String orderStatus;
	private List<IteamBean> items;
}
