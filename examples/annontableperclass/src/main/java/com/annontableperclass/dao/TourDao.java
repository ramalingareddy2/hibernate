package com.annontableperclass.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.annontableperclass.entities.Tour;
import com.annontableperclass.helper.EntityManagerFactoryRegistry;

public class TourDao {
	public int saveTour(Tour tour) {
		EntityTransaction transaction = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		boolean flag = false;
		int tourNo = 0;

		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory();
			em = emf.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			em.persist(tour);
			tourNo = tour.getTourNo();
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				em.close();
			}
		}
		return tourNo;
	}

	public <S extends Tour> Tour find(Class<S> clazzType, Object id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		Tour tour = null;
		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory();
			em = emf.createEntityManager();

			tour = em.find(clazzType, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return tour;
	}
}
