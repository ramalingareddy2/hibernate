package com.manytomanyset.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class DTHPackage implements Serializable {
	protected int packageNo;
	protected String packageName;
	protected String region;
	protected String activationNo;
	protected double monthlyCharges;
	protected Set<Channel> channels;
}
