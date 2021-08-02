package com.vogo.bs4.test;

import com.vogo.bs4.dao.CustomerDao;
import com.vogo.bs4.entities.Customer;
import com.vogo.bs4.helper.SessionFactoryRegistry;

public class BS4Test {
	public static void main(String[] args) {
		CustomerDao customerDao = null;

		try {
			customerDao = new CustomerDao();
			Customer customer = customerDao.getCustomer(1);
			System.out.println(customer);
		} finally {
			//SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
