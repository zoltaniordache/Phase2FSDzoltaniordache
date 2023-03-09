package com.service;

import java.util.List;

import com.dao.PlaceDao;
import com.entity.Airline;
import com.entity.Place;

public class PlaceService {
	PlaceDao pl = new PlaceDao();
	
	public int storePlace(Place place) {
		if(pl.storePlace(place)>0) {
			return 1;
		}else {
			return 0;
				
		}
	}
	
	public List<Place> allPlaceList() {
		return pl.allPlaceList();
	}
	
public Place findPlaceByCity(String  city) {
		

		return pl.findPlaceByCity(city);
		

	}
public Place findPlaceById(int  id) {
	

	return pl.findPlaceById(id);
	

}
}
