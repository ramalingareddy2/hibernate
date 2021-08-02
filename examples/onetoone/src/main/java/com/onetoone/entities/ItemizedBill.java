package com.onetoone.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemizedBill implements Serializable {
	protected int billNo;
	protected int localCallMinutes;
	protected int internationalCallMinutes;
	protected int dataConsumed;
	protected double voiceCallCharges;
	protected double dataCharges;

	protected Bill bill;
}
