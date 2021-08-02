package com.sar.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Job implements Serializable {
	protected int jobNo;
	protected String jobTitle;
	protected String description;
	protected String organizationName;
	protected String designation;
	protected int experience;
	protected String location;
	protected String requiredSkills;
	protected String jobStatus;

}
