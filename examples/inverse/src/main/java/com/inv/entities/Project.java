package com.inv.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Project implements Serializable {
	protected int projectNo;
	protected String projectName;
	protected Date startDate;
	protected int duration;
	protected Set<Member> members;
}
