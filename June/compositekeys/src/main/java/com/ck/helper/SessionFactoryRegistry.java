package com.ck.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata()
				.buildSessionFactory();
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
