package com.otmm.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Workorder implements Serializable {
	protected int workorderNo;
	protected String title;
	protected String description;
	protected Date startDate;
	protected int duration;
	protected double budget;
	protected String status;

}
