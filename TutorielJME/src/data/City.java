package data;

import java.util.ArrayList;

public class City {
	
	private ArrayList<Airport> airports;
	private String country;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Airport> getAirports() {
		return airports;
	}
	public City(String country, String name) {
		super();
		airports = new ArrayList<Airport>();
		this.country = country;
		this.name = name;
	}
	public void setAirports(Airport airport) {
		airports.add(airport);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

	
}
