package com.esolutions.trainings.jsc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RepeatedLastNameModel {
	@JsonProperty("last_names")
	private List<String> lastNames1;

	@JsonProperty("last-names")
	private List<String> lastNames2;

	public List<String> getLastNames1() {
		return lastNames1;
	}

	public void setLastNames1(List<String> lastNames1) {
		this.lastNames1 = lastNames1;
	}

	public List<String> getLastNames2() {
		return lastNames2;
	}

	public void setLastNames2(List<String> lastNames2) {
		this.lastNames2 = lastNames2;
	}
}
