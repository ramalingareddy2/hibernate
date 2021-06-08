package com.ck.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ck.entities.Guarage;
import com.ck.entities.GuaragePk;
import com.ck.helper.SessionFactoryRegistry;

public class GuarageDao {
	public void saveGuarage(Guarage guarage) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(guarage);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}

	}

	public Guarage getGuarage(String guarageClubRegNo, String guarageName) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Guarage guarage = null;
		GuaragePk id = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			id = new GuaragePk();
			id.setGuarageClubRegNo(guarageClubRegNo);
			id.setGuarageName(guarageName);
			guarage = session.get(Guarage.class, id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return guarage;
	}
}
