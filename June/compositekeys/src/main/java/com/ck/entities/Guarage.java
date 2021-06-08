package com.ck.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Guarage implements Serializable {
	protected GuaragePk guaragePk;
	protected String proprietorName;
	protected String contactNo;
	protected String emailAddress;
	protected String location;

}
