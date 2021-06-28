package com.manytoone.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class GoldLoan implements Serializable {
	protected int goldloanNo;
	protected String description;
	protected float totalWeight;
	protected float interestRate;
	protected double loanAmount;
}
