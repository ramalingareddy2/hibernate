package com.hbmtools.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
				.buildMetadata().buildSessionFactory();
		sessionFactory.close();
		
	}
}
