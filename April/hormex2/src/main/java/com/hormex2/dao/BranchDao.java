package com.hormex2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hormex2.entities.Branch;
import com.hormex2.helper.SessionFactoryRegistry;

public class BranchDao {
	public Branch getBranch(int branchNo) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Branch branch = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			branch = session.get(Branch.class, branchNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return branch;
	}
}
