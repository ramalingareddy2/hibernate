package com.manytomanyset.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory = new MetadataSources(
			new StandardServiceRegistryBuilder().configure().build()).buildMetadata().getSessionFactoryBuilder()
					.applyAutoClosing(true).build();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
