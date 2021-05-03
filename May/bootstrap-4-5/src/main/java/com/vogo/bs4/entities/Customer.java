package com.vogo.bs4.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Customer implements Serializable {
	protected int customerNo;
	protected String fullname;
	protected Date dob;
	protected String gender;
	protected String mobileNo;
	protected String emailAddress;
	protected String drivingLicenseNo;

}
