package com.criteriaapi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Setter
@Getter
@NamedQueries({
		@NamedQuery(name = "getMembersByExperience", query = "select m from Member m where m.experience >= :experience") })
public class Member implements Serializable {
	@Id
	@Column(name = "member_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int memberNo;
	@Column(name = "member_nm")
	protected String memberName;
	protected String role;
	protected int experience;
	@OneToMany(mappedBy = "member")
	Set<Task> assignedTasks;
}
