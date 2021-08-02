package com.jpaconfig.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Store implements Serializable {
	private static final long serialVersionUID = 7912858488102937298L;
	protected int storeNo;
	protected String storeName;
	protected String contactNo;
	protected String emailAddress;
	protected String address;
	protected String city;
	protected String state;
	protected int zip;
	protected String country;
}
