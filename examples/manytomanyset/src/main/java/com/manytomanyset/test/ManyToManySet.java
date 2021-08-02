package com.manytomanyset.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manytomanyset.entities.Channel;
import com.manytomanyset.entities.DTHPackage;
import com.manytomanyset.helper.SessionFactoryRegistry;

public class ManyToManySet {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		DTHPackage dthPackage = null;
		Channel channel1 = null;
		Channel channel2 = null;
		Set<Channel> channels = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * channel1 = new Channel(); channel1.setChannelName("Disney Channel");
			 * channel1.setHd(true); channel1.setLanguage("Hindi");
			 * channel1.setSubscriptionCharges(40); int channel1No = (int)
			 * session.save(channel1); System.out.println("channel no 1:" + channel1No);
			 * 
			 * channel2 = new Channel(); channel2.setChannelName("Pogo");
			 * channel2.setHd(true); channel2.setLanguage("Hindi");
			 * channel2.setSubscriptionCharges(35); int channel2No = (int)
			 * session.save(channel2); System.out.println("channel no 1:" + channel2No);
			 * 
			 * channels = new HashSet<>(); channels.add(channel1); channels.add(channel2);
			 * 
			 * dthPackage = new DTHPackage();
			 * dthPackage.setPackageName("South supervalue pack");
			 * dthPackage.setRegion("South"); dthPackage.setActivationNo("2342");
			 * dthPackage.setMonthlyCharges(300); dthPackage.setChannels(channels);
			 * 
			 * int dthPackageNo = (int) session.save(dthPackage);
			 * System.out.println("dth package no : " + dthPackageNo);
			 */
			
			dthPackage = session.get(DTHPackage.class, 1);
			System.out.println(dthPackage);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				if (session != null) {
					session.close();
				}
			}
		}

	}
}
