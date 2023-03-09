package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.AirlineDao;
import com.entity.Airline;
import com.resource.DbResource;

public class AirlineService {
	AirlineDao al = new AirlineDao();
	
	public int storeAirline(Airline airline) {
		if(al.storeAirline(airline)>0) {
			return 1;
		}else {
			return 0;
				
		}
	}
	
	public List<Airline> allAirlineList() {
		return al.allAirlineList();
	}
	
public Airline findAirlineByCity(String  name) {
		

		return al.findAirlineByCity(name);
		

	}
public Airline findAirlineById(int  id) {
	

	return al.findAirlineById(id);
	

}
}
