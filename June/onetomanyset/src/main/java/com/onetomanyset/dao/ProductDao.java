package com.onetomanyset.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetomanyset.entities.Product;
import com.onetomanyset.helper.SessionFactoryRegistry;

public class ProductDao {
	public int saveProduct(Product product) {
		int productNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			productNo = (int) session.save(product);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
		}
		return productNo;
	}

	public Product getProduct(int productNo) {
		Product product = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			product = session.get(Product.class, productNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

}
