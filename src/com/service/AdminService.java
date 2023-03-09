package com.service;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.AdminDao;
import com.entity.Admin;
import com.resource.DbResource;

public class AdminService {
	AdminDao ad = new AdminDao();
	public Admin searchAdmin(String email) {
		
		return ad.searchAdmin(email);
	}
	public boolean validateAdmin(Admin admin) {
		
		return ad.validateAdmin(admin);
	}
	public void updateAdminPassword(String email, String password) {
		
		
	}
}
