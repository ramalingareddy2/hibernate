package com.mtmlist.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Passenger implements Serializable {
	private int passengerNo;
	private String fullname;
	private int age;
	private String gender;
	private String mobileNo;
	private String emailAddress;
}
