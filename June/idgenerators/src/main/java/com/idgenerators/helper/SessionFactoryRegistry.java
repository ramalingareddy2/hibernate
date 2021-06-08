package com.idgenerators.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		/*
		 * sessionFactory = new MetadataSources(new
		 * StandardServiceRegistryBuilder().configure().build()).buildMetadata()
		 * .buildSessionFactory();
		 */
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
