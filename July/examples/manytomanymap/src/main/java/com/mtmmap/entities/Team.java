package com.mtmmap.entities;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Team implements Serializable {
	protected int teamNo;
	protected String teamName;
	protected String managerName;
	protected String coach;
	protected Map<String, Player> players;

	public Team(String teamName, String managerName, String coach) {
		this.teamName = teamName;
		this.managerName = managerName;
		this.coach = coach;
	}

}
