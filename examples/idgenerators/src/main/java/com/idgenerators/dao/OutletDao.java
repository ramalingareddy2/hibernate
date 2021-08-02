package com.idgenerators.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.idgenerators.entities.Outlet;
import com.idgenerators.helper.SessionFactoryRegistry;

public class OutletDao {
	public String saveOutlet(Outlet outlet) {
		String outletNo = null;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			outletNo = (String) session.save(outlet);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
		}

		return outletNo;
	}
}
