package com.getvsload.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.getvsload.entities.IProduct;
import com.getvsload.helper.SessionFactoryRegistry;

public class GetVsLoadTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		IProduct product = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			product = session.load(IProduct.class, 3);
			System.out.println("classType : " + product.getClass().getCanonicalName());
			// System.out.println("productNo : " + product.getProductNo());

			System.out.println("productName: " + product.getProductName());

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
