package com.firstlevelcache.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.firstlevelcache.entities.Category;
import com.firstlevelcache.helper.SessionFactoryRegistry;

public class FLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Category category1 = session.get(Category.class, 1);
			
			category1.setCategoryName("Fashion and Style");
			session.update(category1);
			
			category1.setCategoryName("Fashion and Style for Men and Women");
			session.update(category1);
			// session.evict(category1);
			//session.clear();
			// Category category2 = session.get(Category.class, 1);

			/*
			 * Session session2 = sessionFactory.openSession(); Category category3 =
			 * session2.get(Category.class, 1);
			 */

			// System.out.println("category1 == category2 ? : " + (category1 == category2));
			// System.out.println("category1 == category3 ? : " + (category1 == category3));
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag == false) {
					transaction.rollback();
				} else {
					transaction.commit();
				}
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
