package com.tpsc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpsc.entities.InsurancePlan;
import com.tpsc.helper.SessionFactoryRegistry;

public class InsurancePlanDao {
	public int saveInsurancePlan(InsurancePlan insurancePlan) {
		int planNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			planNo = (Integer) session.save(insurancePlan);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				if (session != null) {
					session.close();
				}
			}
		}

		return planNo;
	}

	public InsurancePlan getInsurancePlan(Class<?> entityClass, int planNo) {
		Session session = null;
		InsurancePlan insurancePlan = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			insurancePlan = (InsurancePlan) session.get(entityClass, planNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return insurancePlan;
	}
}
