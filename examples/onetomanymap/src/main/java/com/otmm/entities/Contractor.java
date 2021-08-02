package com.otmm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class Contractor implements Serializable {
	protected int contractorNo;
	protected String organizationName;
	protected String licenseNo;
	protected Date establishedDate;
	protected String contactNo;
	protected String emailAddress;
	protected Map<String, Workorder> allotedWorkorders;
}
