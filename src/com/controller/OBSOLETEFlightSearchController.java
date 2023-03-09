package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Airline;
import com.entity.Place;
import com.entity.Flight;
import com.service.AirlineService;
import com.service.FlightService;
import com.service.PlaceService;


/**
 * Servlet implementation class FlightSearchController
 */
@WebServlet("/FlightSearchController")
public class OBSOLETEFlightSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OBSOLETEFlightSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html");
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
//		String dateOfFligh = request.getParameter("dateOfFlight");
//
//	
//		
//	
//		Place sourcePlace = new Place();	
//		PlaceService sourceService = new PlaceService();	
//		sourcePlace = sourceService.findPlaceByCity(source);	
//		
//		Place destinationPlace = new Place();
//		PlaceService destinationService = new PlaceService();	
//		destinationPlace = destinationService.findPlaceByCity(destination);	
//		
//		FlightService flightService = new FlightService();
//		List<Flight> flightList = flightService.getFlightList(sourcePlace.getPlaceId(), destinationPlace.getPlaceId(), dateOfFligh);
//		
//		
//		
//		
//		Iterator<Flight> ii = flightList.iterator();
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
//			pw.println("<form action = \"FlightSearchController\" method = \"post\">");
//
//			pw.println("<div>"
//					+ "<div name = \"source\"> Source is "+placeSource.getCity()+"</div>"
//					+ "<div name = \"destination\"> Destination is "+placeDestination.getCity()+"</div>"
//					+ "<div name = \"airline\"> Airline is "+airline.getAirlineName()+"</div>"
//					+ "<div name = \"price\"> Price is "+p.getPrice()+"</div>"
//					+ "<div name = \"seats\"> Seats is "+p.getSeats()+"</div>"
//					+ "<div name = \"dateOfFlight\"> Date of Flight is "+p.getDateOfFligh()+"</div>"+
//					
//					"</div>");
//	
//			pw.println("<input type =\"submit\" value =\"Book\">" );
//			pw.println("</form>");
//		}
//		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html");
//		String source = request.getParameter("source");
//		String destination = request.getParameter("destination");
//		String dateOfFligh = request.getParameter("dateOfFlight");
//		pw.println(source+" "+destination+" "+dateOfFligh);
	}

}
