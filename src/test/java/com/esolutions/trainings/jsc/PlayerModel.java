package com.esolutions.trainings.jsc;

public class PlayerModel {
	private String name;
	private Long played;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPlayed() {
		return played;
	}

	public void setPlayed(Long played) {
		this.played = played;
	}

	static PlayerModel build(String name, Long played) {
		final PlayerModel model = new PlayerModel();
		model.setName(name);
		model.setPlayed(played);
		return model;
	}
}
