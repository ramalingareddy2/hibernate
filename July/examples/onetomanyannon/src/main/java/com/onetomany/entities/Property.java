package com.onetomany.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property")
@Setter
@Getter
public class Property implements Serializable {
	@Id
	@Column(name = "property_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int propertyNo;
	protected String title;
	protected String description;
	@Column(name = "property_type")
	protected String propertyType;
	protected double amount;

	@OneToMany(mappedBy = "property", fetch = FetchType.EAGER)
	protected List<Enquiry> enquiries; // this association is readonly, dont update the relationship column based on
										// this association
}
