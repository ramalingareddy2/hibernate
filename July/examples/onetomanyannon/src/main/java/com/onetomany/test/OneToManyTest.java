package com.onetomany.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.onetomany.entities.Enquiry;
import com.onetomany.entities.Property;
import com.onetomany.helper.EntityManagerFactoryHelper;

public class OneToManyTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		Property property = null;
		Enquiry enquiry1 = null;
		Enquiry enquiry2 = null;
		Set<Enquiry> enquiries = null;

		try {
			entityManagerFactory = EntityManagerFactoryHelper.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			/*
			 * property = new Property(); property.setTitle("3BHK Flat For Sale");
			 * property.setDescription("1600 SFT Flat"); property.setPropertyType("Flat");
			 * property.setAmount(1200000); entityManager.persist(property);
			 * 
			 * enquiry1 = new Enquiry(); enquiry1.setPersonName("Williams");
			 * enquiry1.setMobileNo("892839333");
			 * enquiry1.setEmailAddress("williams@gmail.com");
			 * enquiry1.setProperty(property); entityManager.persist(enquiry1);
			 * 
			 * enquiry2 = new Enquiry(); enquiry2.setPersonName("James");
			 * enquiry2.setMobileNo("24252525");
			 * enquiry2.setEmailAddress("James@gmail.com"); enquiry2.setProperty(property);
			 * entityManager.persist(enquiry2);
			 */
			property = entityManager.find(Property.class, 1);
			System.out.println("title : " + property.getTitle());
			enquiries = property.getEnquiries();
			for (Enquiry e : enquiries) {
				System.out.println("mobile no:" + e.getMobileNo());
			}

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
