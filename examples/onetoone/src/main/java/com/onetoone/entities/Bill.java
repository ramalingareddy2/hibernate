package com.onetoone.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Bill implements Serializable {
	protected int billNo;
	protected String consumerName;
	protected Date billGeneratedDate;
	protected Date dueDate;
	protected double amount;

}
