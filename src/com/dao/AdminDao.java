package com.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Admin;
import com.entity.Airline;
import com.resource.DbResource;

public class AdminDao{
	public Admin searchAdmin(String email) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		
		TypedQuery<Admin> tq = session.createQuery("from Admin where email = :email");
		tq.setParameter("email", email);
		Admin admin = new Admin();
		try{
			 admin = tq.getSingleResult();
		}
		catch (NoResultException nre){
			 admin = new Admin("notvalid","notvalid");
		}
		session.close();
		return admin;
	}
	public boolean validateAdmin(Admin admin) {
		boolean valid = false;
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin admindResult = searchAdmin(email);
		if(email.equals(admindResult.getEmail()) && password.equals(admindResult.getPassword()))
			valid = true;
		
		return valid;
	
	}
	public void updateAdminPassword(String email, String password) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		Admin admin = searchAdmin(email);
		admin.setPassword(password);
		
		session.update(admin);
		tran.commit();
		session.close();
		
	
	
	}
}
