package com.annontableperclass.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
@Table(name = "international_tour")
public class InternationalTour extends Tour {
	@Column(name = "passport_no")
	protected String passportNo;
	@Column(name = "visa_required")
	protected boolean visaRequired;
	@Column(name = "visa_charges")
	protected double visaCharges;
}
