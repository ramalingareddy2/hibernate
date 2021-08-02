package com.slc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.slc.entities.Job;
import com.slc.entities.Organization;
import com.slc.helper.SessionFactoryRegistry;

public class Check2NDTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean flag = false;
		Organization org = null;
		Organization org2 = null;
		Job job1 = null;
		Job job2 = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			org = session.get(Organization.class, 1);
			System.out.println(org.getOrganizationName());
			job1 = org.getJobs().iterator().next();
			System.out.println(job1.getTitle());
			

			session.close();
			session = sessionFactory.openSession();

			org2 = session.get(Organization.class, 1);
			System.out.println(org2.getOrganizationName());
			job1 = org2.getJobs().iterator().next();
			System.out.println(job1.getTitle());

			flag = true;
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}
}
