package com.onetooneannon.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "receipt")
public class Receipt implements Serializable {
	@Id
	@Column(name = "bill_no")
	@GenericGenerator(name = "foreign_gen", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "electricityBill") })
	@GeneratedValue(generator = "foreign_gen")
	protected int billNo;
	@Column(name = "transaction_no")
	protected String transactionNo; // bank payment transaction no
	@Column(name = "paid_dt")
	protected Date paidDate;
	protected double amount;

	@OneToOne
	@PrimaryKeyJoinColumn
	ElectricityBill electricityBill;
}
