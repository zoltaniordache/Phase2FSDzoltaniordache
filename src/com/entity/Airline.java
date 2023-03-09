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
@Table(name = "airline")
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private int airlineId;
@Column(unique=true)
 private String airlineName;
 @OneToMany
 @JoinColumn(name = "fairlineId") 			// this annotation is used to link fk in student table
 private List<Flight> listOfFlights;
public int getAirlineId() {
	return airlineId;
}
public void setAirlineId(int airlineId) {
	this.airlineId = airlineId;
}
public String getAirlineName() {
	return airlineName;
}



public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}
public List<Flight> getListOfFlights() {
	return listOfFlights;
}
public void setListOfFlights(List<Flight> listOfFlights) {
	this.listOfFlights = listOfFlights;
}
public Airline(int airlineId, String airlineName, List<Flight> listOfFlights) {
	super();
	this.airlineId = airlineId;
	this.airlineName = airlineName;
	this.listOfFlights = listOfFlights;
}
@Override
public String toString() {
	return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", listOfFlights=" + listOfFlights
			+ "]";
}
public Airline() {
	super();
	// TODO Auto-generated constructor stub
}	

 

 
 

}
