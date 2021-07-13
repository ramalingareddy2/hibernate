package com.onetomany.entities;

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

@Entity
@Table(name = "enquiry")
@Setter
@Getter
public class Enquiry implements Serializable {
	@Id
	@Column(name = "enquiry_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int enquiryNo;
	@Column(name = "person_nm")
	protected String personName;
	@Column(name = "mobile_no")
	protected String mobileNo;
	@Column(name = "email_address")
	protected String emailAddress;

	@ManyToOne
	@JoinColumn(name = "property_no", nullable = false)
	protected Property property;

}
