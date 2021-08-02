package com.sar.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sar.service.initiator.BlazeConnectionProviderImplInitiator;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		/*
		 * Configuration configuration = new Configuration().configure(); sessionFactory
		 * = configuration.buildSessionFactory();
		 */
		Configuration configuration = new Configuration();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure()
				.addInitiator(new BlazeConnectionProviderImplInitiator());
		StandardServiceRegistry registry = builder.build();
		sessionFactory = configuration.buildSessionFactory(registry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
