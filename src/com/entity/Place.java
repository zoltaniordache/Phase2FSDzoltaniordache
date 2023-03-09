package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private int placeId;
 private String country;
 @Column(unique=true)
 private String city;
 @OneToMany
 @JoinColumn(name = "fsourceId") 			// this annotation is used to link fk in student table
 private List<Flight> listOfFlightsSource;
 @OneToMany
 @JoinColumn(name = "fdestinationId") 			// this annotation is used to link fk in student table
 private List<Flight> listOfFlightsDestination;
public int getPlaceId() {
	return placeId;
}
public void setPlaceId(int placeId) {
	this.placeId = placeId;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public List<Flight> getListOfFlightsSource() {
	return listOfFlightsSource;
}
public void setListOfFlightsSource(List<Flight> listOfFlightsSource) {
	this.listOfFlightsSource = listOfFlightsSource;
}
public List<Flight> getListOfFlightsDestination() {
	return listOfFlightsDestination;
}
public void setListOfFlightsDestination(List<Flight> listOfFlightsDestination) {
	this.listOfFlightsDestination = listOfFlightsDestination;
}
public Place(int placeId, String country, String city, List<Flight> listOfFlightsSource,
		List<Flight> listOfFlightsDestination) {
	super();
	this.placeId = placeId;
	this.country = country;
	this.city = city;
	this.listOfFlightsSource = listOfFlightsSource;
	this.listOfFlightsDestination = listOfFlightsDestination;
}
public Place() {
	super();
	// TODO Auto-generated constructor stub
}

}

