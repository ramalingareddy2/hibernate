package com.onetomanyset.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Product implements Serializable {
	protected int productNo;
	protected String productName;
	protected String description;
	protected String manufacturer;
	protected double amount;
	protected Set<Review> productReviews;

}
