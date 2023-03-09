package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Airline;
import com.entity.Place;
import com.service.AirlineService;
import com.service.PlaceService;

/**
 * Servlet implementation class PlaceController
 */
@WebServlet("/PlaceController")
public class PlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html");
//		PlaceService ps = new PlaceService();
//		List<Place> listOfPlace = ps.allPlaceList();
//		pw.println("Number of Places is "+listOfPlace.size());
//		Iterator<Place> ii = listOfPlace.iterator();
//		while(ii.hasNext()) {
//			Place p = ii.next();
//			pw.println("<div>");
//
//			pw.println("<span>Country is "+p.getCountry()+"City is "+p.getCity()+"</span>");
//			pw.println("<div>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String country = request.getParameter("country");
		String city = request.getParameter("city");


		Place p = new Place();
		p.setCity(city);
		p.setCountry(country);
		PlaceService ps = new PlaceService();
		int result = ps.storePlace(p);
		
		if(result >0){
			request.getRequestDispatcher("viewPlace.jsp").include(request, response);
			pw.print("<script> window.alert('Place added successfully!')</script>");
		
		}
		
		
	}

}
