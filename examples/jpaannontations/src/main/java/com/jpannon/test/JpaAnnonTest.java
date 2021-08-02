package com.jpannon.test;

import com.jpaannon.dao.StoreDao;
import com.jpaannon.entities.Store;
import com.jpaannon.helper.EntityManagerFactoryRegistry;

public class JpaAnnonTest {
	public static void main(String[] args) {
		try {
			StoreDao dao = new StoreDao();
			Store store = dao.getStore(1);
			System.out.println(store);
		} finally {
			EntityManagerFactoryRegistry.closeEntityManagerFactory();
		}
	}
}
