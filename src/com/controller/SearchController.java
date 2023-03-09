package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Flight;
import com.entity.Place;
import com.service.FlightService;
import com.service.PlaceService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String dateOfFligh = request.getParameter("date");
		String travellers = request.getParameter("travellers");
		
		HttpSession session = request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("date", dateOfFligh);
		session.setAttribute("travellers", travellers);

		
		Place sourcePlace = new Place();	
		PlaceService sourceService = new PlaceService();	
		sourcePlace = sourceService.findPlaceByCity(source);	
		
		Place destinationPlace = new Place();
		PlaceService destinationService = new PlaceService();	
		destinationPlace = destinationService.findPlaceByCity(destination);	
		
		FlightService flightService = new FlightService();
		List<Flight> flightList = flightService.getFlightList(sourcePlace.getPlaceId(), destinationPlace.getPlaceId(), dateOfFligh);

		
		
		session.setAttribute("flights", flightList);
		response.sendRedirect("searchResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
