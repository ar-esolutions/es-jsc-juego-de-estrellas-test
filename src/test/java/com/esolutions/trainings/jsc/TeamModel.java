package com.esolutions.trainings.jsc;

import java.util.List;

public class TeamModel {
	private List<PlayerModel> players;

	public List<PlayerModel> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerModel> players) {
		this.players = players;
	}

	static TeamModel build(List<PlayerModel> list) {
		final TeamModel teamModel = new TeamModel();
		teamModel.setPlayers(list);
		return teamModel;
	}
}
