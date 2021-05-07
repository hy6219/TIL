package com.mission.javabeans;

public class MovieBean {
	private String title;
	private int price;
	private String director;
	private String synopsis;
	private String genre;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return String.valueOf(price);
	}
	public void setPrice(int pirce) {
		this.price = pirce;
	}
	public void setPrice(String price) {
		this.price = Integer.valueOf(price);
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
