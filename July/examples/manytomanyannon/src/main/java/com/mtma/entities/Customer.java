package com.mtma.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@Id
	@Column(name = "customer_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int customerNo;
	@Column(name = "customer_nm")
	protected String customerName;
	protected int age;
	protected String gender;

	@ManyToMany(mappedBy = "customers")
	protected Set<Loan> loans;
}
