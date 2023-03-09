package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Airline;
import com.entity.Flight;
import com.entity.Place;

import com.service.AirlineService;
import com.service.FlightService;
import com.service.PlaceService;

/**
 * Servlet implementation class FlightController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html");
//		FlightService ps = new FlightService();
//		List<Flight> listOfFlight = ps.allFlightList();
//		pw.println("Number of Flights is "+listOfFlight.size());
//		Iterator<Flight> ii = listOfFlight.iterator();
//		
//		Airline airline = new Airline();
//		AirlineService airlineService = new AirlineService();	
//		
//		
//		Place placeSource = new Place();	
//		Place placeDestination = new Place();
//		PlaceService placeService = new PlaceService();	
//		
//		while(ii.hasNext()) {
//			Flight p = ii.next();
//			//find airline object
//			airline = airlineService.findAirlineById(p.getFairlineId());
//			//find place object
//			placeSource = placeService.findPlaceById(p.getFsourceId());	
//			placeDestination = placeService.findPlaceById(p.getFdestinationId());	
//			pw.println("<div>");
//
//			pw.println("<span>"
//					+ " Flight Name is "+p.getFlightName()
//					+ " Source is "+placeSource.getCity()
//					+ " Destination is "+placeDestination.getCity()
//					+ " Airline is "+airline.getAirlineName()
//					+ " Price is "+p.getPrice()
//					+ " Seats is "+p.getSeats()
//					+ " Date of Flight is "+p.getDateOfFligh()+
//					
//					"</span>");
//			pw.println("<div>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String flightName = request.getParameter("flightName");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String airline = request.getParameter("airline");
		double price = Double.parseDouble(request.getParameter("price"));;
		int seats = Integer.parseInt(request.getParameter("seats"));
		String dateOfFligh = request.getParameter("dateOfFlight");
		

		
		Airline a = new Airline();
		AirlineService ps = new AirlineService();	
		a = ps.findAirlineByCity(airline);
		
		Place sourcePlace = new Place();	
		PlaceService sourceService = new PlaceService();	
		sourcePlace = sourceService.findPlaceByCity(source);	
		
		Place destinationPlace = new Place();
		PlaceService destinationService = new PlaceService();	
		destinationPlace = destinationService.findPlaceByCity(destination);	
		
		Flight flight = new Flight();
		flight.setFlightName(flightName);
		flight.setFairlineId(a.getAirlineId());
		flight.setFsourceId(sourcePlace.getPlaceId());
		flight.setFdestinationId(destinationPlace.getPlaceId());
		flight.setPrice(price);
		flight.setSeats(seats);
		try {
			flight.setDateOfFligh(dateOfFligh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FlightService fs = new FlightService();
		int  result= fs.storeFlight(flight);

	
			
			if(result >0)
			{
				request.getRequestDispatcher("viewFlight.jsp").include(request, response);
				pw.print("<script> window.alert('Flight added successfully!')</script>");
			}
	}

}