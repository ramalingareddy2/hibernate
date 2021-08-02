package com.manytoone.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Ornament implements Serializable {
	protected int ornamentNo;
	protected String description;
	protected float weight;
	protected double estimatedValue;
	protected GoldLoan goldLoan;
}
