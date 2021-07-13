package com.mtmlist.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtmlist.entities.Journey;
import com.mtmlist.entities.Passenger;
import com.mtmlist.helper.SessionFactoryRegistry;

public class MTMListTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Journey journey = null;
		Passenger passenger1 = null;
		Passenger passenger2 = null;
		List<Passenger> passengers = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * passenger1 = new Passenger(); passenger1.setFullname("Robert");
			 * passenger1.setAge(23); passenger1.setGender("Male");
			 * passenger1.setMobileNo("9837383382");
			 * passenger1.setEmailAddress("robert@gmail.com"); int passengerNo1 = (int)
			 * session.save(passenger1); System.out.println("passenger no1 : " +
			 * passengerNo1);
			 * 
			 * passenger2 = new Passenger(); passenger2.setFullname("Williams");
			 * passenger2.setAge(22); passenger2.setGender("FeMale");
			 * passenger2.setMobileNo("389289332");
			 * passenger2.setEmailAddress("Williams@gmail.com"); int passengerNo2 = (int)
			 * session.save(passenger2); System.out.println("passenger no1 : " +
			 * passengerNo2);
			 * 
			 * passengers = new ArrayList<>(); passengers.add(passenger2);
			 * passengers.add(passenger1);
			 * 
			 * journey = new Journey(); journey.setSource("Hyderabad");
			 * journey.setDestination("Banglore"); journey.setJourneyDate(new Date());
			 * journey.setAmount(2300); journey.setPassengers(passengers); int journeyNo =
			 * (int) session.save(journey); System.out.println("journey no : " + journeyNo);
			 */
			journey = session.get(Journey.class, 1);
			System.out.println(journey);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
		}

	}
}
