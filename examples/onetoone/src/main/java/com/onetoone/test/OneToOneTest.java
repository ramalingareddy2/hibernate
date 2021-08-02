package com.onetoone.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onetoone.entities.Bill;
import com.onetoone.entities.ItemizedBill;
import com.onetoone.helper.SessionFactoryRegistry;

public class OneToOneTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Bill bill = null;
		ItemizedBill itemizedBill = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * bill = new Bill(); bill.setConsumerName("Alex");
			 * bill.setBillGeneratedDate(new Date()); bill.setDueDate(new Date());
			 * bill.setAmount(2500); int billNo = (int) session.save(bill);
			 * System.out.println("billNo : " + billNo);
			 * 
			 * itemizedBill = new ItemizedBill(); itemizedBill.setLocalCallMinutes(1000);
			 * itemizedBill.setInternationalCallMinutes(100);
			 * itemizedBill.setDataConsumed(10000); itemizedBill.setVoiceCallCharges(2000);
			 * itemizedBill.setDataCharges(500); itemizedBill.setBill(bill); int
			 * itemizedBillNo = (int) session.save(itemizedBill);
			 * System.out.println("itemized bill no : " + itemizedBillNo);
			 */
			itemizedBill = session.get(ItemizedBill.class, 1);
			System.out.println(itemizedBill);

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
