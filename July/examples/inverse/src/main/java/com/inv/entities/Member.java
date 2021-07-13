package com.inv.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member implements Serializable {
	protected int memberNo;
	protected String memberName;
	protected String role;
	protected int experience;
	protected Project project;

}
