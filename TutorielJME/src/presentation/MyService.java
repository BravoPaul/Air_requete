package presentation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import data.Airport;
import data.City;
import data.Country;
import data.Route;
import data.Test;

public class MyService {
	// 获得随机数据

	public static ArrayList<Airport> trouveleaveairport = new ArrayList<Airport>();
	public static ArrayList<Airport> trouveleftairport = new ArrayList<Airport>();
	
	
	@SuppressWarnings("unused")
	public static ArrayList<String> getroute(String scountry, String scity,
			String sairport, String dcountry, String dcity, String dairport,
			String airline) {
		
		ArrayList<String> airroutes = null;
		
		if (Test.airLineHashMapHashMap.get(airline)!=null&&airline!=null) {
			
			airroutes = Test.airLineHashMapHashMap.get(airline).getRoute(); 
			System.out.println(airroutes);
		}

		ArrayList<String> arrayroute = new ArrayList<String>();
		int i = 0;
		Airport vraidariport;
		if (sairport != null) {

			java.util.Iterator<Entry<String, String>> iter = Test
					.getAirportbyiata(sairport).getRouteleave().entrySet()
					.iterator();

			while (iter.hasNext()) {
				Map.Entry entry = iter.next();
				String key = (String) entry.getKey();
				String val = (String) entry.getValue();
				vraidariport = Test.getAirportbyiata(val);
				// System.out.println(vraidariport.getCountry());
				try {
					if (vraidariport != null) {
						if (dairport != null) {

							if (dairport.equals(vraidariport.getIata())) {
									if (airroutes==null||airroutes.contains(key)) {
										arrayroute.add(key);
										trouveleaveairport.add(Test.getAirportbyiata(sairport));
										trouveleftairport.add(vraidariport);
										i++;
									}
								
							}
						} else if (dairport == null && dcity != null) {
							if (vraidariport.getCity().equals(dcity)) {
								if (airroutes==null||airroutes.contains(key)) {
									trouveleaveairport.add(Test.getAirportbyiata(sairport));
									trouveleftairport.add(vraidariport);
									arrayroute.add(key);
									i++;
								}
							}
						} else if (dairport == null && dcity == null
								&& dcountry != null) {
							
							if (vraidariport.getCountry().contains(dcountry)) {
								if (airroutes==null||airroutes.contains(key)) {
									trouveleaveairport.add(Test.getAirportbyiata(sairport));
									trouveleftairport.add(vraidariport);
									arrayroute.add(key);
									i++;
								}
							}
						}
					}
				} catch (NullPointerException e) {
					// TODO: handle exception
				}

			}
		}

		else if (sairport == null && scity != null) {

			City vraicity = Test.getcity(scity);

			for (int j = 0; j < vraicity.getAirports().size(); j++) {
				Airport linshi1 =  vraicity.getAirports().get(j);
				sairport = linshi1.getIata();
				java.util.Iterator<Entry<String, String>> iter = Test
						.getAirportbyiata(sairport).getRouteleave().entrySet()
						.iterator();
				
				while (iter.hasNext()) {
					try {
						Map.Entry entry = iter.next();
						String key = (String) entry.getKey();
						String val = (String) entry.getValue();
						vraidariport = Test.getAirportbyiata(val);

						if (dairport != null) {
							if (dairport.equals(vraidariport.getIata())) {
								if (airroutes==null||airroutes.contains(key)) {
									arrayroute.add(key);
									trouveleaveairport.add(linshi1);
									trouveleftairport.add(vraidariport);
									i++;
								}
							}
						} else if (dairport == null && dcity != null) {
							if (vraidariport.getCity().equals(dcity)) {
								if (airroutes==null||airroutes.contains(key)) {
									arrayroute.add(key);
									trouveleaveairport.add(Test.getAirportbyiata(sairport));
									trouveleftairport.add(vraidariport);
									i++;
								}
							}
						} else if (dairport == null && dcity == null
								&& dcountry != null) {
							if (vraidariport.getCountry().equals(dcountry)) {
								if (airroutes==null||airroutes.contains(key)) {
									arrayroute.add(key);
									trouveleaveairport.add(Test.getAirportbyiata(sairport));
									trouveleftairport.add(vraidariport);
									i++;
								}
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}

		}

		else if (sairport == null && scity == null && scountry != null) {

			Country vraicountry = Test.getcountry(scountry);

			for (int j = 0; j < vraicountry.getCities().size(); j++) {
				City vraicity = vraicountry.getCities().get(j);

				for (int j2 = 0; j2 < vraicity.getAirports().size(); j2++) {
					Airport linshi1 = vraicity.getAirports().get(j2);
					sairport = linshi1.getIata();
					java.util.Iterator<Entry<String, String>> iter = Test
							.getAirportbyiata(sairport).getRouteleave()
							.entrySet().iterator();
					
					while (iter.hasNext()) {
						try {
							Map.Entry entry = iter.next();
							String key = (String) entry.getKey();
							String val = (String) entry.getValue();
							vraidariport = Test.getAirportbyiata(val);

							if (dairport != null) {
								if (dairport.equals(vraidariport.getIata())) {
									if (airroutes==null||airroutes.contains(key)) {
										arrayroute.add(key);
										trouveleaveairport.add(Test.getAirportbyiata(sairport));
										trouveleftairport.add(vraidariport);
										i++;
									}
								}
							} else if (dairport == null && dcity != null) {
								if (vraidariport.getCity().equals(dcity)) {
									if (airroutes==null||airroutes.contains(key)) {
										arrayroute.add(key);
										trouveleaveairport.add(Test.getAirportbyiata(sairport));
										trouveleftairport.add(vraidariport);
										i++;
									}
								}
							} else if (dairport == null && dcity == null
									&& dcountry != null) {
								if (vraidariport.getCountry().equals(dcountry)) {
									if (airroutes==null||airroutes.contains(key)) {
										arrayroute.add(key);
										trouveleaveairport.add(Test.getAirportbyiata(sairport));
										trouveleftairport.add(vraidariport);
										i++;
									}
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

				}
			}
		}
		
		if (arrayroute.size()==0&&airroutes!=null) {
			return airroutes;
		}
		
		return arrayroute;
	}

	public static ArrayList<Route> getRoutes() {
		ArrayList<Route> routes = null;
		return routes;
	}
	
	public static String getcoutrybyairport(String airport) {
		
		if (Test.getAirportbyiata(airport)!=null) {
			return Test.getAirportbyiata(airport).getCountry();
		}
		
		else {
			return null;
		}
	}
	
	public static String getcitybyairport(String airport) {
		
		if (Test.getAirportbyiata(airport)!=null) {
			return Test.getAirportbyiata(airport).getCity();
		}
		
		else {
			return null;
		}
	}

	public static ArrayList<String> getcoutrybyname(String country) {
		ArrayList<String> countryselect = null;
		countryselect = new ArrayList<String>();
		for (int i = 0; i < Test.countries.size(); i++) {
			if (Test.countries.get(i).getName().contains(country)) {
				countryselect.add(Test.countries.get(i).getName());
			}
		}
		return countryselect;
	}

	public static ArrayList<String> getportbyname(String airportss) {
		// System.out.println("jint qu");
		ArrayList<String> airport = new ArrayList<String>();
		java.util.Iterator<Entry<String, Airport>> iter = Test.airportHashMap
				.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = iter.next();
			String key = (String) entry.getKey();
			Airport valAirport = (Airport) entry.getValue();
			if (key.contains(airportss)) {
				airport.add(valAirport.getIata());
			}
			Airport val = (Airport) entry.getValue();
		}
		return airport;
	}
	
	

	@SuppressWarnings("unused")
	public static ArrayList<String> getcitybyname(String country, String city) {
		ArrayList<String> cityselect = null;
		Country countryselect = null;
		cityselect = new ArrayList<String>();

		if (countryselect != null) {

			countryselect = Test.getcountry(country);

			for (int i = 0; i < countryselect.getCities().size(); i++) {
				if (countryselect.getCities().get(i).getName().contains(city)) {
					cityselect.add(countryselect.getCities().get(i).getName());
				}

			}
		} else {

			for (int i = 0; i < Test.cities.size(); i++) {
				if (Test.cities.get(i).getName().contains(city)) {
					cityselect.add(Test.cities.get(i).getName());
				}
			}
		}

		return cityselect;
	}

}