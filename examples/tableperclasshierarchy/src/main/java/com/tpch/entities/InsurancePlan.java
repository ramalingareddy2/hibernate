package com.tpch.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class InsurancePlan implements Serializable {
	private static final long serialVersionUID = -1835824029528334250L;
	protected int planNo;
	protected String planName;
	protected int minEligibilityAge;
	protected int maxEligibilityAge;
	protected int minTenure;
	protected int maxTenure;
	protected double minAmount;
}
