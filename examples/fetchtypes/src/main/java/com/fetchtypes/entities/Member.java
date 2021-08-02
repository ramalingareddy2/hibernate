package com.fetchtypes.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member implements Serializable {
	protected int memberNo;
	protected String memberName;
	protected int experience;
	protected String role;
	protected Set<Task> tasks;

}
