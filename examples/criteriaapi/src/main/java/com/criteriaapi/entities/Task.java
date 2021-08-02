package com.criteriaapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
@Setter
@Getter
public class Task implements Serializable {
	@Id
	@Column(name = "task_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int taskNo;
	protected String title;
	protected String description;
	protected int duration;
	protected String status;

	@ManyToOne
	@JoinColumn(name = "member_no")
	protected Member member;
}
