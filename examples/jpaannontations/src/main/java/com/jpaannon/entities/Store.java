package com.jpaannon.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "store")
public class Store implements Serializable {
	private static final long serialVersionUID = 7912858488102937298L;
	@Id
	@Column(name = "store_no")
	protected int storeNo;
	@Column(name = "store_nm")
	protected String storeName;
	@Column(name = "contact_no")
	protected String contactNo;
	@Column(name = "email_address")
	protected String emailAddress;
	protected String address;
	protected String city;
	protected String state;
	protected int zip;
	protected String country;
}
