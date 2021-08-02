package com.annonsingletable.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tour")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tour_type")
@DiscriminatorValue("local")
public class Tour implements Serializable {
	@Id
	@Column(name = "tour_no")
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int tourNo;
	@Column(name = "tour_package_nm")
	protected String tourPackageName;
	protected int days;
	protected String source;
	protected String destination;
	protected double amount;

}
