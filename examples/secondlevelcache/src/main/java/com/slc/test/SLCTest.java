package com.slc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.slc.entities.Job;
import com.slc.entities.Organization;
import com.slc.helper.SessionFactoryRegistry;

public class SLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Organization org = null;
		Job job1 = null;
		Job job2 = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			org = new Organization();
			org.setOrganizationName("Cognizant");
			org.setLocation("Hyderabad");
			org.setContactNo("939303434");
			session.save(org);

			job1 = new Job();
			job1.setTitle("Java developer");
			job1.setDescription("3 years senior java developer");
			job1.setExperience(3);
			job1.setOrganization(org);
			session.save(job1);
			
			job2 = new Job();
			job2.setTitle("Senior Java developer");
			job2.setDescription("5 years senior java developer");
			job2.setExperience(5);
			job2.setOrganization(org);
			session.save(job2);
			

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
