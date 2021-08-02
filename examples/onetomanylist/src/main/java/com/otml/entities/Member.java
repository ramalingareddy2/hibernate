package com.otml.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member implements Serializable {
	protected int memberNo;
	protected String memberName;
	protected String projectName;
	protected String role;
	protected int experience;
	protected Date startDate;
	List<Task> assignedTasks;
}
