package data;

import java.util.ArrayList;

public class Country {
	
	private String name;
   
	private	ArrayList<City> cities;
	private ArrayList<AirLine> airlines;
	
	
	
	 public Country(String name) {
			super();
			cities = new ArrayList<City>();
			airlines = new ArrayList<AirLine>();
			this.name = name;
	}

	 	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(City city) {
		this.cities.add(city);
	}

	public ArrayList<AirLine> getAirlines() {
		return airlines;
	}

	public void setAirlines(AirLine airlines) {
		this.airlines.add(airlines);
	}
	
	public City getcity(String city) {
		for (int j = 0; j < this.getCities().size(); j++) {
			if (this.getCities().get(j).getName().equals(city)) {
				return this.getCities().get(j);
			}
		}
		return null;
	}


	@Override
	public String toString() {
		return "Country [name=" + name + ", cities=" + cities + ", airlines="
				+ airlines + "]";
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}



	public void setAirlines(ArrayList<AirLine> airlines) {
		this.airlines = airlines;
	}


	
	
	
	
}
