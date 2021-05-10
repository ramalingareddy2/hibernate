package com.hibannon.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibannon.entities.Merchant;
import com.hibannon.helper.SessionFactoryRegistry;

public class HibAnnonTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Merchant merchant = null;
		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			merchant = session.get(Merchant.class, 1);
			System.out.println(merchant);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
