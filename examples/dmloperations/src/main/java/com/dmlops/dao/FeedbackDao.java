package com.dmlops.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dmlops.entities.Feedback;
import com.dmlops.helper.SessionFactoryRegistry;

public class FeedbackDao {
	public int saveFeedback(Feedback feedback) {
		int feedbackNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			feedbackNo = (Integer) session.save(feedback);
			System.out.println("feedbackNo in entityObject : " + feedback.getFeedbackNo());
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

		return feedbackNo;
	}

	public int persistFeedback(Feedback feedback) {
		int feedbackNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.persist(feedback);
			System.out.println("feedbackNo in entityObject : " + feedback.getFeedbackNo());
			feedbackNo = feedback.getFeedbackNo(); // WARNING! no guarantee that id will be reflected before flushing
													// the changes

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

		return feedbackNo;
	}

	public int saveOrUpdateFeedback(Feedback feedback) {
		int feedbackNo = 0;
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(feedback);
			System.out.println("feedbackNo in entityObject : " + feedback.getFeedbackNo());
			feedbackNo = feedback.getFeedbackNo();
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

		return feedbackNo;
	}

	public void updatePartialFeedback(Feedback feedback) {
		boolean flag = false;
		Session session = null;
		Feedback e_Feedback = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			e_Feedback = session.get(Feedback.class, feedback.getFeedbackNo());

			e_Feedback.setFeedbackDate(feedback.getFeedbackDate());
			e_Feedback.setRating(feedback.getRating());
			e_Feedback.setComments(feedback.getComments());

			//session.update(e_Feedback);

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

	public void mergeFeedback(Feedback feedback) {
		boolean flag = false;
		Session session = null;
		Feedback e_Feedback = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			e_Feedback = session.get(Feedback.class, feedback.getFeedbackNo());

			feedback.setProvidedBy(e_Feedback.getProvidedBy());
			feedback.setEmailAddress(e_Feedback.getEmailAddress());

			session.merge(feedback);

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

	public int deleteFeedback(int feedbackNo) {
		boolean flag = false;
		Session session = null;
		Feedback e_Feedback = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			e_Feedback = session.get(Feedback.class, feedbackNo);
			if (e_Feedback != null) {
				session.delete(e_Feedback);
			} else {
				throw new RuntimeException("entity object not found to delete");
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
			if (session != null) {
				session.close();
			}
		}

		return feedbackNo;
	}
}
