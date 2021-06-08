package com.jpagenerators.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryRegistry {
	private static EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("vogodb");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void closeEntityManagerFactory() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
}
