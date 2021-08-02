package com.onetooneannon.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "electricity_bill")
public class ElectricityBill implements Serializable {
	@Id
	@Column(name = "bill_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int billNo;
	@Column(name = "service_no")
	protected String serviceNo;
	@Column(name = "consumer_no")
	protected String consumerNo;
	protected int units;
	@Column(name = "bill_amount")
	protected double billAmount;

	@OneToOne(mappedBy = "electricityBill")
	protected Receipt receipt;
}
