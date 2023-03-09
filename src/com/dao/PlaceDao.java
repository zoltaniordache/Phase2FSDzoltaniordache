package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Airline;
import com.entity.Place;
import com.resource.DbResource;

public class PlaceDao {
	public int storePlace(Place place) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(place);
		tran.commit();
		session.close();
		return 1;
	}
	public List<Place> allPlaceList(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session=sf.openSession();
		List<Place> placeList= session.createQuery("from Place",Place.class).list();
		session.close();
		return placeList;
		
	}
	public Place findPlaceByCity(String city) {
		
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();	
		
		TypedQuery<Place> tq = session.createQuery("from Place where city = :n");
		tq.setParameter("n", city);
		Place  place = tq.getSingleResult();
		session.close();
		return place;
		

	}
	public Place findPlaceById(int id) {
		
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();	
		
		TypedQuery<Place> tq = session.createQuery("from Place where placeId = :id");
		tq.setParameter("id", id);
		Place  place = tq.getSingleResult();
		session.close();
		return place;
		

	}
}
