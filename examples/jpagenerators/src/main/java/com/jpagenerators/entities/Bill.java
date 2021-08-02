package com.jpagenerators.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@Column(name = "bill_no")
	/* @GeneratedValue(strategy = GenerationType.IDENTITY) */
	/*
	 * @SequenceGenerator(name = "billgen", sequenceName = "bill_no_seq",
	 * initialValue = 1, allocationSize = 1)
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billgen")
	 */
	@TableGenerator(name = "billtblgen", table = "unique_keys", pkColumnName = "pkName", valueColumnName = "pkvalue", pkColumnValue = "bill_no", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "billtblgen")
	protected int billNo;
	@Column(name = "bill_dt")
	protected Date billDate;
	@Column(name = "customer_nm")
	protected String customerName;
	protected String description;
	protected double amount;

}
