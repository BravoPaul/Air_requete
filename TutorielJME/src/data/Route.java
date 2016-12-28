package data;

public class Route {
	
	private String airline;
	private int airlineID;
	private int sairportID;
	private String sairportName;
	private int dairportID;
	private String dairportName;
	private String codeshare;
	private String stops;
	private String equipment;
	
	
	public Route(String airline, int airlineID,
			String sairportName,int sairportID, String dairportName,int dairportID, 
			String codeshare, String stops, String equipment) {
		super();
		this.airline = airline;
		this.airlineID = airlineID;
		this.sairportID = sairportID;
		this.sairportName = sairportName;
		this.dairportID = dairportID;
		this.dairportName = dairportName;
		this.codeshare = codeshare;
		this.stops = stops;
		this.equipment = equipment;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(int airlineID) {
		this.airlineID = airlineID;
	}

	public int getSairportID() {
		return sairportID;
	}

	public void setSairportID(int sairportID) {
		this.sairportID = sairportID;
	}

	public String getSairportName() {
		return sairportName;
	}

	public void setSairportName(String sairportName) {
		this.sairportName = sairportName;
	}

	public int getDairportID() {
		return dairportID;
	}

	public void setDairportID(int dairportID) {
		this.dairportID = dairportID;
	}

	public String getDairportName() {
		return dairportName;
	}

	public void setDairportName(String dairportName) {
		this.dairportName = dairportName;
	}

	public String getCodeshare() {
		return codeshare;
	}

	public void setCodeshare(String codeshare) {
		this.codeshare = codeshare;
	}

	public String getStops() {
		return stops;
	}

	public void setStops(String stops) {
		this.stops = stops;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "Route [airline=" + airline + ", airlineID=" + airlineID
				+ ", sairportID=" + sairportID + ", sairportName="
				+ sairportName + ", dairportID=" + dairportID
				+ ", dairportName=" + dairportName + ", codeshare=" + codeshare
				+ ", stops=" + stops + ", equipment=" + equipment + "]";
	}
	
	
	
	
	
	
}
