package com.bs3.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProgSessionFactoryRegistryImpl implements SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/vogodb");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperty("hibernate.show_sql", "true");

		configuration.addResource("com/bs3/entities/Bike.hbm.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
