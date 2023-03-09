package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	@Column(unique=true)
	private String flightName;
	private Integer fsourceId;
	private Integer fdestinationId;
	private Integer fairlineId;
	private double price;
	private int seats;
	private Date dateOfFligh;
	public Flight(int flightId, String flightName, Integer fsourceId, Integer fdestinationId, Integer fairlineId,
			double price, int seats, Date dateOfFligh) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.fsourceId = fsourceId;
		this.fdestinationId = fdestinationId;
		this.fairlineId = fairlineId;
		this.price = price;
		this.seats = seats;
		this.dateOfFligh = dateOfFligh;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Integer getFsourceId() {
		return fsourceId;
	}
	public void setFsourceId(Integer fsourceId) {
		this.fsourceId = fsourceId;
	}
	public Integer getFdestinationId() {
		return fdestinationId;
	}
	public void setFdestinationId(Integer fdestinationId) {
		this.fdestinationId = fdestinationId;
	}
	public Integer getFairlineId() {
		return fairlineId;
	}
	public void setFairlineId(Integer fairlineId) {
		this.fairlineId = fairlineId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Date getDateOfFligh() {
		return dateOfFligh;
	}
	public void setDateOfFligh(Date dateOfFligh) {
		this.dateOfFligh = dateOfFligh;
	}
	public void setDateOfFligh(String dateOfFligh) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.dateOfFligh = format.parse(dateOfFligh);
	}
	
	
	
	
	
	
	
}
