package com.onetomanyset.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Review implements Serializable {
	protected int reviewNo;
	protected int rating;
	protected String comment;
	protected Date reviewPostedDate;
	protected String reviewedBy;

}
