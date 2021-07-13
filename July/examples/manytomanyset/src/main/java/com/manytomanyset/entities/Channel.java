package com.manytomanyset.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Channel implements Serializable {
	protected int channelNo;
	protected String channelName;
	protected String language;
	protected boolean hd;
	protected double subscriptionCharges;

}
