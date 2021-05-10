package com.getvsload.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		/*
		 * StandardServiceRegistry registry = new
		 * StandardServiceRegistryBuilder().configure().build(); MetadataSources
		 * metadataSources = new MetadataSources(registry); MetadataBuilder
		 * metadataBuilder = metadataSources.getMetadataBuilder(); Metadata metadata =
		 * metadataBuilder.build();
		 * 
		 * SessionFactoryBuilder sessionFactoryBuilder =
		 * metadata.getSessionFactoryBuilder();
		 * sessionFactoryBuilder.applyAutoClosing(true);
		 * 
		 * sessionFactory = sessionFactoryBuilder.build();
		 */
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata()
				.getSessionFactoryBuilder().applyAutoClosing(true).build();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
