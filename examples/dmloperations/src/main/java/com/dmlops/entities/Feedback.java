package com.dmlops.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Feedback implements Serializable {
	protected int feedbackNo;
	protected Date feedbackDate;
	protected int rating;
	protected String comments;
	protected String providedBy;
	protected String emailAddress;
}
