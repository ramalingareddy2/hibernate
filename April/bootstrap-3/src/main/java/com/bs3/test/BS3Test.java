package com.bs3.test;

import com.bs3.dao.BikeDao;
import com.bs3.entities.Bike;
import com.bs3.helper.XmlSessionFactoryRegistryImpl;

public class BS3Test {
	public static void main(String[] args) {
		BikeDao bikeDao = null;
		Bike bike = null;

		try {
			bikeDao = new BikeDao();
			bike = bikeDao.getBike(1);
			System.out.println(bike);
		} finally {
			new XmlSessionFactoryRegistryImpl().closeSessionFactory();
		}
	}
}
