package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Airline;
import com.entity.Flight;
import com.resource.DbResource;

public class FlightDao {
		
	public int storeFlight(Flight flight) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(flight);
		tran.commit();
		session.close();
		return 1;
	}
	
	// get flights
	public List<Flight> getFlightList(int  sourceId, int destinationId, String dateOfFlightString) {
		List<Flight> flightList = null;
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfFligh = new Date();
		try {
			dateOfFligh = format.parse(dateOfFlightString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TypedQuery tq = session.createQuery("from Flight f  where fsourceId = :src and fdestinationId = :dst and dateOfFligh = :date");
		tq.setParameter("src", sourceId);
		tq.setParameter("dst", destinationId);
		tq.setParameter("date", dateOfFligh);
		
		flightList= tq.getResultList();		
		session.close();
		return flightList;
		
		
		
		
		
	}
	
	public List<Flight> allFlightList(){
		
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		List<Flight> flightList= session.createQuery("from Flight",Flight.class).list();
		session.close();
		return flightList;
		
	}
}
