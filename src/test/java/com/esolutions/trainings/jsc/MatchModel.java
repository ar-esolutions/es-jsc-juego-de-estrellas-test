package com.esolutions.trainings.jsc;

import java.util.Objects;

public class MatchModel {
	private Integer year;
	private Integer dayOfYear;
	private String date;

	public MatchModel() {
	}

	public MatchModel(Integer year, Integer dayOfYear, String date) {
		this.year = year;
		this.dayOfYear = dayOfYear;
		this.date = date;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(Integer dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MatchModel that = (MatchModel) o;
		return Objects.equals(year, that.year) &&
				Objects.equals(dayOfYear, that.dayOfYear) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, dayOfYear, date);
	}

	@Override
	public String toString() {
		return "MatchModel{" +
				"year=" + year +
				", dayOfYear=" + dayOfYear +
				", date='" + date + '\'' +
				'}';
	}
}
