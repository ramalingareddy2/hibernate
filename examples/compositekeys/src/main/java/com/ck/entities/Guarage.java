package com.ck.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "guarage")
public class Guarage implements Serializable {
	@EmbeddedId
	protected GuaragePk guaragePk;
	@Column(name = "proprietorName")
	protected String proprietorName;
	@Column(name = "contact_no")
	protected String contactNo;
	@Column(name = "email_address")
	protected String emailAddress;
	protected String location;

}
