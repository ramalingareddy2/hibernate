package com.onetomanyset.dto;

public class ProductDto {
	private int productNo;
	private String productName;
	private double amount;

	public ProductDto(int productNo, String productName, double amount) {
		this.productNo = productNo;
		this.productName = productName;
		this.amount = amount;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
