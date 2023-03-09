<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
<h2>Search Flight</h2>

<form >
<label>Source</label>

<%@ page import="com.entity.Place" %>
<%@ page import="com.entity.Flight" %>
<%@ page import="com.entity.Airline" %>
<%@ page import="com.service.AirlineService" %>
<%@ page import="com.service.PlaceService" %>
<%@ page import="com.service.FlightService" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>


<%PlaceService ps = new PlaceService();
List<Place> listOfSource= ps.allPlaceList();
Iterator<Place> sourceIterator = listOfSource.iterator();
out.println("<select name = \"source\">");
		while(sourceIterator.hasNext()) {
			Place source = sourceIterator.next();
			

			out.println("<option>"+source.getCity()+"</option>");
			
		}
		out.println("<select>");%>

 </br>
<label>Destination</label>


<%PlaceService ds = new PlaceService();
List<Place> listOfDestination = ds.allPlaceList();
Iterator<Place> destinationIterator = listOfDestination.iterator();
out.println("<select name = \"destination\">");
		while(destinationIterator.hasNext()) {
			Place destination = destinationIterator.next();
			

			out.println("<option>"+destination.getCity()+"</option>");
			
		}
		out.println("<select>");%>

 </br>
<label>Date of Flight</label>
<input type="date" name ="dateOfFlight"></br>
<input type ="submit" value ="Search Flight" name = "submit">
<%
if (request.getParameter("submit") != null) {
	
	

String source = request.getParameter("source");
String destination = request.getParameter("destination");
String dateOfFligh = request.getParameter("dateOfFlight");




Place sourcePlace = new Place();	
PlaceService sourceService = new PlaceService();	
sourcePlace = sourceService.findPlaceByCity(source);	

Place destinationPlace = new Place();
PlaceService destinationService = new PlaceService();	
destinationPlace = destinationService.findPlaceByCity(destination);	

FlightService flightService = new FlightService();
List<Flight> flightList = flightService.getFlightList(sourcePlace.getPlaceId(), destinationPlace.getPlaceId(), dateOfFligh);




Iterator<Flight> ii = flightList.iterator();

Airline airline = new Airline();
AirlineService airlineService = new AirlineService();	


Place placeSource = new Place();	
Place placeDestination = new Place();
PlaceService placeService = new PlaceService();	

while(ii.hasNext()) {
	Flight p = ii.next();
	//find airline object
	airline = airlineService.findAirlineById(p.getFairlineId());
	//find place object
	placeSource = placeService.findPlaceById(p.getFsourceId());	
	placeDestination = placeService.findPlaceById(p.getFdestinationId());	
	out.println("<form>");

	out.println("<div>"
			+ "<div name = \"source\"> Source is "+placeSource.getCity()+"</div>"
			+ "<div name = \"destination\"> Destination is "+placeDestination.getCity()+"</div>"
			+ "<div name = \"airline\"> Airline is "+airline.getAirlineName()+"</div>"
			+ "<div name = \"price\"> Price is "+p.getPrice()+"</div>"
			+ "<div name = \"seats\"> Seats is "+p.getSeats()+"</div>"
			+ "<div name = \"dateOfFlight\"> Date of Flight is "+p.getDateOfFligh()+"</div>"+
			
			"</div>");

	out.println("<input type =\"submit\" value =\"Book\" name =\"book\">" );
	out.println("</form>");
	RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
	rd.forward(request, response);
}
}
if (request.getParameter("book") != null) {
	String source = request.getParameter("source");
	String destination = request.getParameter("destination");
	String dateOfFligh = request.getParameter("dateOfFlight");
	out.println(source+" "+destination+" "+dateOfFligh);
	
}
%>

</form>
</body>
</html>