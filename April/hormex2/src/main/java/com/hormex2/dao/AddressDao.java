package com.hormex2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hormex2.entities.Address;
import com.hormex2.helper.SessionFactoryRegistry;

public class AddressDao {
	public Address getAddress(int addressNo) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Address address = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			address = session.get(Address.class, addressNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return address;
	}
}
