package com.slc.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "organization")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Organization implements Serializable {
	@Id
	@Column(name = "organization_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int organizationNo;
	@Column(name = "organization_nm")
	protected String organizationName;
	protected String location;
	@Column(name = "contact_no")
	protected String contactNo;
	@OneToMany(mappedBy = "organization")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	protected Set<Job> jobs;

}
