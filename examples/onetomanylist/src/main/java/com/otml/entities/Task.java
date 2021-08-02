package com.otml.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Task implements Serializable {
	protected int taskNo;
	protected String title;
	protected String description;
	protected int duration;
	protected String status;

}
