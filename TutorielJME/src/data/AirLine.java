package data;

import java.util.ArrayList;

public class AirLine {
	
	private int airlineID;
	private String name;
	private String alias;
	private String iata;
	private String icao;
	private String callsign;
	private String country;
	private String active;
	private ArrayList<String> route;

	@Override
	public String toString() {
		return "AirLine [airlineID=" + airlineID + ", name=" + name
				+ ", alias=" + alias + ", iata=" + iata + ", icao=" + icao
				+ ", callsign=" + callsign + ", country=" + country
				+ ", active=" + active + "]";
	}

	public AirLine(int airlineID, String name, String alias, String iata,
			String icao, String callsign, String country, String active) {
		super();
		this.airlineID = airlineID;
		this.name = name;
		this.alias = alias;
		this.iata = iata;
		this.icao = icao;
		this.callsign = callsign;
		this.country = country;
		this.active = active;
		route = new ArrayList<String>();
	}

	public int getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(int airlineID) {
		this.airlineID = airlineID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public ArrayList<String> getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route.add(route);
	}
	
	
}
