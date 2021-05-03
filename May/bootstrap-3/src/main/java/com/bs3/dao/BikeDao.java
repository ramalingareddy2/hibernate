package com.bs3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs3.entities.Bike;
import com.bs3.helper.SessionFactoryRegistry;
import com.bs3.helper.XmlSessionFactoryRegistryImpl;

public class BikeDao {
	public Bike getBike(int bikeNo) {
		SessionFactoryRegistry sessionFactoryRegistry = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Bike bike = null;

		try {
			sessionFactoryRegistry = new XmlSessionFactoryRegistryImpl();
			sessionFactory = sessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			bike = session.get(Bike.class, bikeNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return bike;
	}
}
