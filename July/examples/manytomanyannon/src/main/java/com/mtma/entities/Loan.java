package com.mtma.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "loan")
public class Loan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_no")
	protected int loanNo;
	@Column(name = "loan_type")
	protected String loanType;
	@Column(name = "principle_amount")
	protected double principleAmount;
	protected int tenure;
	@Column(name = "interest_rate")
	protected float interestRate;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "loan_customers", joinColumns = { @JoinColumn(name = "loan_no") }, inverseJoinColumns = {
			@JoinColumn(name = "customer_no") })
	protected Set<Customer> customers;

}
