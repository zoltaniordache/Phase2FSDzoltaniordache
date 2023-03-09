package com.service;

import java.util.Date;
import java.util.List;

import com.dao.FlightDao;
import com.entity.Flight;

public class FlightService {
	FlightDao fl = new FlightDao();
	
	public int storeFlight(Flight airline) {
		if(fl.storeFlight(airline)>0) {
			return 1;
		}else {
			return 0;
				
		}
	}
	
	public List<Flight> allFlightList() {
		return fl.allFlightList();
	}
	
	public List<Flight> getFlightList(int source, int destination, String dateOfFlight){
		return fl.getFlightList(source,destination,dateOfFlight);
	}
}
