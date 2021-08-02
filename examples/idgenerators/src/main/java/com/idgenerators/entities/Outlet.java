package com.idgenerators.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Outlet implements Serializable {
	protected String outletNo;
	protected String outletName;
	protected String description;
	protected String inChargeName;
	protected int capacity;
	protected String location;
	protected String contactNo;
}
