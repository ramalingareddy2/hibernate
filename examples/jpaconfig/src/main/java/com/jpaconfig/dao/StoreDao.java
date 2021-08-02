package com.jpaconfig.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import com.jpaconfig.entities.Store;
import com.jpaconfig.helper.EntityManagerFactoryRegistry;

public class StoreDao {
	public Store getStore(int storeNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		Store store = null;
		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory();
			em = emf.createEntityManager();
			store = em.find(Store.class, storeNo);
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return store;
	}
}
