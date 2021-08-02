package com.jpaconfig.test;

import com.jpaconfig.dao.StoreDao;
import com.jpaconfig.entities.Store;

public class JpaConfigTest {
	public static void main(String[] args) {
		StoreDao dao = new StoreDao();
		Store store = dao.getStore(1);
		System.out.println(store);
	}
}
