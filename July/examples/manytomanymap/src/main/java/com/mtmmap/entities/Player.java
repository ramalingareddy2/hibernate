package com.mtmmap.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player implements Serializable {
	protected int playerNo;
	protected String playerName;
	protected int age;
	protected String gender;

	public Player(String playerName, int age, String gender) {
		this.playerName = playerName;
		this.age = age;
		this.gender = gender;
	}

}
