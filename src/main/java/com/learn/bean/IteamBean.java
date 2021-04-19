package com.learn.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class IteamBean {
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("itemUnitPrice")
	private String itemUnitPrice;
	@JsonProperty("itemQuantity")
	private int itemQuantity;
}
