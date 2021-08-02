package com.ck.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class GuaragePk implements Serializable {
	@Column(name = "guarage_club_reg_no")
	protected String guarageClubRegNo;
	@Column(name = "guarage_nm")
	protected String guarageName;
}
