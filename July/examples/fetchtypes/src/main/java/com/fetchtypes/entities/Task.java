package com.fetchtypes.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task implements Serializable {
	protected int taskNo;
	protected String title;
	protected String description;
	protected int duration;
	protected Member member;

}
