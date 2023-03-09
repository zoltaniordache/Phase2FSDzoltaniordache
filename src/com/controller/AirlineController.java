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

import com.service.AirlineService;


/**
 * Servlet implementation class AirlineController
 */
@WebServlet("/AirlineController")
public class AirlineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineController() {
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
//		AirlineService ps = new AirlineService();
//		List<Airline> listOfAirline = ps.allAirlineList();
//		pw.println("Number of airlines is "+listOfAirline.size());
//		Iterator<Airline> ii = listOfAirline.iterator();
//		while(ii.hasNext()) {
//			Airline p = ii.next();
//			pw.println("<div>");
//
//			pw.println("<span>PName is "+p.getAirlineName()+"</span>");
//			pw.println("<div>");
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String airlineName = request.getParameter("airlineName");


		Airline p = new Airline();
		p.setAirlineName(airlineName);
		AirlineService ps = new AirlineService();
		int result = ps.storeAirline(p);
		
		if(result >0){
			request.getRequestDispatcher("viewAirline.jsp").include(request, response);
			pw.print("<script> window.alert('Airline added successfully!')</script>");
		}
		}
}
		
		

		
	


