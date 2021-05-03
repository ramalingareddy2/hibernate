package com.bs3.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropsSessionFactoryRegistryImpl implements SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addResource("com/bs3/entities/Bike.hbm.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
