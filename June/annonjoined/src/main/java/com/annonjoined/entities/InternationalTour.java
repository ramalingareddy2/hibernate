package com.annonjoined.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn
public class InternationalTour extends Tour {
	@Column(name = "passport_no")
	protected String passportNo;
	@Column(name = "visa_required")
	protected boolean visaRequired;
	@Column(name = "visa_charges")
	protected double visaCharges;
}
