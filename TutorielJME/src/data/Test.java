package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Test {
	
	public static ArrayList<Country> countries = new ArrayList<Country>();
	public static ArrayList<City> cities = new ArrayList<City>();
	public static HashMap<String, AirLine> airLineHashMapHashMap = new HashMap<String, AirLine>();
	public static HashMap<String, Airport> airportHashMap = new HashMap<String, Airport>();
	
	private FileReader dFileReader = null;
	private BufferedReader br = null;
	
	public void initialcontry() {
		
		java.util.Iterator<Entry<String, Airport>> iter = airportHashMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = iter.next(); 
		    String key = (String) entry.getKey(); 
		    Airport val = (Airport) entry.getValue(); 

			Country ccCountry = getcountry(val.getCountry());
			if (ccCountry==null) {
				Country country = new Country(val.getCountry());
				City city = new City(country.getName(),val.getCity());
				city.setAirports(val);
				cities.add(city);
				country.setCities(city);
				countries.add(country);
			}
			if (ccCountry!=null) {
				City dedaocity = ccCountry.getcity(val.getCity());
				if (dedaocity==null) {
					City city = new City(ccCountry.getName(),val.getCity());
					city.setAirports(val);
					cities.add(city);
					ccCountry.setCities(city);
				}
				else {
					dedaocity.setAirports(val);
				}
			}
		
		    
		} 
		/*
		for (int i = 0; i < airLines.size(); i++) {
			Country ccCountry = getcountry(airLines.get(i).getCountry());
			if (ccCountry!=null) {
				ccCountry.setAirlines(airLines.get(i));;
			}
			
		}*/
	}
	
	
	public static Country getcountry(String country) {
		for (int i = 0; i < countries.size(); i++) {
			if (country.equals(countries.get(i).getName())) {
				return countries.get(i);
			}
		}
		return null;
	}
	
	public static City getcity(String city) {
		for (int i = 0; i < cities.size(); i++) {
			if (city.equals(cities.get(i).getName())) {
				return cities.get(i);
			}
		}
		return null;
	}
	
	public static Airport getAirportbyiata(String airport) {
		
		if (Test.airportHashMap.get(airport)!=null) {
			return Test.airportHashMap.get(airport);
		}
		
		return null;
	}
	
	public void initialRoute() throws IOException, InterruptedException{
		try {
			
			dFileReader = new FileReader(new File("D:\\routes.dat"));
			br = new BufferedReader(dFileReader);
			String s = null;
			String[] arrayTemp = null;
			int j = 0;
			while ((s = br.readLine()) != null) {
				if (s == " ") continue; 
				arrayTemp = s.split("\\,");
				int aInt,bInt,cInt;
				try {
					aInt = Integer.parseInt(arrayTemp[1]);
				} catch (NumberFormatException e) {
					aInt = -1;
				}
				try {
					bInt = Integer.parseInt(arrayTemp[3]);
				} catch (NumberFormatException e) {
					bInt = -1;
				}
				try {
					cInt = Integer.parseInt(arrayTemp[5]);
				} catch (NumberFormatException e) {
					cInt = -1;
				}
				j = j+1;
				try {
					Route route = new Route(arrayTemp[0], aInt, arrayTemp[2], bInt, arrayTemp[4], cInt,arrayTemp[6], arrayTemp[7], arrayTemp[8]);
					//System.out.println(arrayTemp[2]);
					if (getAirportbyiata(arrayTemp[2])!=null) {
						getAirportbyiata(arrayTemp[2]).setRouteleave(route.toString(),arrayTemp[4]);
					}
					else if (getAirportbyiata(arrayTemp[4])!=null) {
						getAirportbyiata(arrayTemp[4]).setRoutearrrive(route.toString(),arrayTemp[2]);
					}
					
					if (Test.airLineHashMapHashMap.get(arrayTemp[0])!=null) {
						Test.airLineHashMapHashMap.get(arrayTemp[0]).setRoute(route.toString());
					}
					
				} catch (ArrayIndexOutOfBoundsException e) {
				
				}
				
			}
			//for (int i = 0; i < 3; i++) {
				//System.out.println(routes.get(66666).toString());
				//System.out.println(j);
			//}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
			if (dFileReader != null) dFileReader.close();
		}
		
		System.out.println(airLineHashMapHashMap.get("2B").getRoute().size());
		
	}
	
	public void initialAirLine() throws IOException, InterruptedException{
		try {
			
			dFileReader = new FileReader(new File("D:\\airlines.dat"));
			br = new BufferedReader(dFileReader);
			String s = null;
			String[] arrayTemp = null;
			int j = 0;
			
			while ((s = br.readLine()) != null) {
				if (s == " ") continue; 
				arrayTemp = s.split("\\,");
				int aInt;
				try {
					aInt = Integer.parseInt(arrayTemp[0]);
				} catch (NumberFormatException e) {
					aInt = -1;
				}
			
				for (int i = 0; i < arrayTemp.length; i++) {
					if (arrayTemp[i].contains("\"")) {
						arrayTemp[i] = arrayTemp[i].replaceAll("\"", "");
					}
				}
				
				try {
					airLineHashMapHashMap.put(arrayTemp[3],new AirLine(aInt, arrayTemp[1], arrayTemp[2], arrayTemp[3], arrayTemp[4], arrayTemp[5],arrayTemp[6], arrayTemp[7]));
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}
				
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
			if (dFileReader != null) dFileReader.close();
		}
	}
	
	public void initialAirPort() throws IOException, InterruptedException{
		try {
			
			dFileReader = new FileReader(new File("D:\\airports.dat"));
			br = new BufferedReader(dFileReader);
			String s = null;
			String[] arrayTemp = null;
			
			while ((s = br.readLine()) != null) {
				if (s.equals("\"")) continue; 
				arrayTemp = s.split("\\,");
				for (int i = 0; i < arrayTemp.length; i++) {
					if (arrayTemp[i].contains("\"")) {
						arrayTemp[i] = arrayTemp[i].replaceAll("\"", "");
					}
				}
				int aInt;
				try {
					aInt = Integer.parseInt(arrayTemp[0]);
				} catch (NumberFormatException e) {
					aInt = -1;
				}
			
				try {
					Airport airports = new Airport(aInt, arrayTemp[1], arrayTemp[2], arrayTemp[3], arrayTemp[4], arrayTemp[5],arrayTemp[6], arrayTemp[7], arrayTemp[8], arrayTemp[9],arrayTemp[10]);
					airportHashMap.put(arrayTemp[4], airports);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
			if (dFileReader != null) dFileReader.close();
		}
		
		
	}
	
	public static void main(String[] args)  {
		/*
		Test iTest = new Test();
		try {
			iTest.initialAirPort();
			iTest.initialAirLine();
			iTest.initialRoute();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getAirportbyiata("PEK"));
		System.out.println(getAirportbyiata("PEK").getRouteleave().size());
		for (int i = 0; i < getAirportbyiata("PEK").getRouteleave().size(); i++) {
			System.out.println( Test.airportHashMap.get("PEK").getRouteleave().get(i));
		}
		
		for (int i = 0; i < Test.airLineHashMapHashMap.get(751).getRoute().size(); i++) {
			System.out.println(Test.airLineHashMapHashMap.get(751).getRoute().get(i));
		}*/
		//System.out.println(countries.size());
	}
}
