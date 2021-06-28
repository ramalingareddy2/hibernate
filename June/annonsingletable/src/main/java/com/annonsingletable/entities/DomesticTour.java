package com.annonsingletable.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("domestic")
public class DomesticTour extends Tour {
	@Column(name = "additional_state_charges")
	protected double additionalStateCharges;
	@Column(name = "toll_taxes_to_be_paid")
	protected double tollTaxesToBePaid;

}
