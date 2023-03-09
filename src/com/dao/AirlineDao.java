package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Airline;

import com.resource.DbResource;

public class AirlineDao {
	public int storeAirline(Airline airline) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(airline);
		tran.commit();
		session.close();
		return 1;
	}
	public List<Airline> allAirlineList(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();

		List<Airline> airlineList= session.createQuery("from Airline",Airline.class).list();
		session.close();
		return airlineList;
	}
	public Airline findAirlineByCity(String name) {
		
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();	
		
		TypedQuery<Airline> tq = session.createQuery("from Airline where airlineName = :n");
		tq.setParameter("n", name);
		Airline  airline = tq.getSingleResult();
		session.close();
		return airline;
		

	}	
	public Airline findAirlineById(int id) {
		
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();	
		
		TypedQuery<Airline> tq = session.createQuery("from Airline where airlineId = :id");
		tq.setParameter("id", id);
		Airline  airline = tq.getSingleResult();
		session.close();
		return airline;
		
		

	}	
}
