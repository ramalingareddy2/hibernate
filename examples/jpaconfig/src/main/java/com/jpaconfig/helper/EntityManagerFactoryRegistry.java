package com.jpaconfig.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryRegistry {
	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("vogopu");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}
	}

}
