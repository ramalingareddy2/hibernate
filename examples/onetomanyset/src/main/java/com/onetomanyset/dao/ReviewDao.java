package com.onetomanyset.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetomanyset.entities.Review;
import com.onetomanyset.helper.SessionFactoryRegistry;

public class ReviewDao {
	public int saveReview(Review review) {
		int reviewNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			reviewNo = (int) session.save(review);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
		}
		return reviewNo;
	}

	public Review getReview(int reviewNo) {
		Review review = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			review = session.get(Review.class, reviewNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return review;
	}
}
