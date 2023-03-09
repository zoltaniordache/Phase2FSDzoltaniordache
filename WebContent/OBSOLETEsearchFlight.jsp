<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
<h2>Search Flight</h2>

<form action = "FlightSearchController" method = "get">
<label>Source</label>


<%@ page import="com.entity.Place" %>
<%@ page import="com.service.PlaceService" %>
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
<input type ="submit" value ="Search Flight">


</form>
</body>
</html>