package com.mtmlist.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Journey implements Serializable {
	protected int journeyNo;
	protected String source;
	protected String destination;
	protected Date journeyDate;
	protected double amount;
	protected List<Passenger> passengers;

}
