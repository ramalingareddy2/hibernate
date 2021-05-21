package com.hbmtools.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Staff implements Serializable {
	protected int staffNo;
	protected String fullName;
	protected int age;
	protected String gender;
	protected String designation;
	protected int experience;
	protected String mobileNo;
	protected String emailAddress;

}
