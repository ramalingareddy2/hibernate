package com.sar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sar.entities.Job;
import com.sar.helper.SessionFactoryRegistry;

public class JobDao {
	public Job getJob(int jobNo) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Job job = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			job = session.get(Job.class, jobNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return job;
	}
}
