package com.bs3.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlSessionFactoryRegistryImpl implements SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure("com/bs3/common/bs3-hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable t) {
			t.printStackTrace();
		}
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
