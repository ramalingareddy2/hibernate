package com.vogo.bs4.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vogo.bs4.entities.Customer;
import com.vogo.bs4.helper.SessionFactoryRegistry;

public class CustomerDao {
	public Customer getCustomer(int customerNo) {
		Session session = null;
		Customer customer = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			customer = session.get(Customer.class, customerNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return customer;
	}
}
