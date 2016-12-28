package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Airport implements Comparable<Airport>{
	
	private int airportID;
	private String name;
	private String city;
	private String country;
	private String iata;
	private String icao;
	private String latitude;
	private String longitude;
	private String altitude;
	private String timezone;
	private String DST;
	private HashMap<String,String> routeleave;
	private HashMap<String,String> routearrrive;
	
	public HashMap<String,String> getRouteleave() {
		return routeleave;
	}
	public void setRouteleave(String route,String arriveairport) {
		this.routeleave.put(route, arriveairport);
	}
	
	public HashMap<String,String> getRoutearrrive() {
		return routearrrive;
	}
	public void setRoutearrrive(String route,String leaveairport) {
		this.routearrrive.put(route, leaveairport);
	}


	
	public Airport(int airportID, String name,String city, String country,String iata,
			String icao, String latitude, String longitude, String altitude,
			String timezone, String dST) {
		super();
		this.airportID = airportID;
		this.name = name;
		this.city = city;
		this.country = country;
		this.iata = iata;
		this.icao = icao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.timezone = timezone;
		DST = dST;
		
		routearrrive = new HashMap<String, String>();
		routeleave = new HashMap<String,String>();
	}
	public int getAirportID() {
		return airportID;
	}
	public void setAirportID(int airportID) {
		this.airportID = airportID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getDST() {
		return DST;
	}
	public void setDST(String dST) {
		DST = dST;
	}
	


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Airport [airportID=" + airportID + ", name=" + name + ", city="
				+ city + ", country=" + country + ", iata=" + iata + ", icao="
				+ icao + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", altitude=" + altitude + ", timezone=" + timezone
				+ ", DST=" + DST + "]";
	}
	@Override
	public int compareTo(Airport o) {
		// TODO Auto-generated method stub
		return this.getIata().compareTo(o.getIata());
	}
	
	
	
	
	
}
