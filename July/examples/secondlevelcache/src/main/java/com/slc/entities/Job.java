package com.slc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "job")
public class Job implements Serializable {
	@Id
	@Column(name = "job_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int jobNo;
	protected String title;
	protected String description;
	protected int experience;

	@ManyToOne
	@JoinColumn(name = "organization_no")
	protected Organization organization;

}
