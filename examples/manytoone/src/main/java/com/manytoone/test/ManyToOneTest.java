package com.manytoone.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manytoone.entities.GoldLoan;
import com.manytoone.entities.Ornament;
import com.manytoone.helper.SessionFactoryRegistry;

public class ManyToOneTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		GoldLoan goldLoan = null;
		Ornament ornament = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * goldLoan = new GoldLoan();
			 * goldLoan.setDescription("Gold loan for house purchase purpose");
			 * goldLoan.setInterestRate(18); goldLoan.setTotalWeight(80);
			 * goldLoan.setLoanAmount(400000); int goldLoanNo = (int)
			 * session.save(goldLoan); System.out.println("gold loan no : " + goldLoanNo);
			 * 
			 * ornament = new Ornament(); ornament.setDescription("Chain");
			 * ornament.setWeight(20); ornament.setEstimatedValue(20000);
			 * ornament.setGoldLoan(goldLoan); int ornamentNo = (int)
			 * session.save(ornament);
			 * 
			 * System.out.println("ornamentNo : " + ornamentNo);
			 */
			ornament = session.get(Ornament.class, 1);
			System.out.println(ornament);
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



