package com.getvsload.entities;

import java.io.Serializable;

import lombok.Data;

@Data
final public class Product implements Serializable, IProduct {
	protected int productNo;
	protected String productName;
	protected String description;
	protected double price;

}
