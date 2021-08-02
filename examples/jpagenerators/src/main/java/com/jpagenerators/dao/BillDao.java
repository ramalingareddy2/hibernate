package com.jpagenerators.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jpagenerators.entities.Bill;
import com.jpagenerators.helper.EntityManagerFactoryRegistry;

public class BillDao {
	public int saveBill(Bill bill) {
		int billNo = 0;
		boolean flag = false;
		EntityManager em = null;
		EntityTransaction et = null;
		EntityManagerFactory emf = null;

		try {
			emf = EntityManagerFactoryRegistry.getEntityManagerFactory();
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();

			em.persist(bill);
			billNo = bill.getBillNo(); // fetch back the generated pk value from entity class
			flag = true;
		} finally {
			if (et != null) {
				if (flag) {
					et.commit();
				} else {
					et.rollback();
				}
			}
			if (em != null) {
				em.close();
			}
		}

		return billNo;
	}
}
