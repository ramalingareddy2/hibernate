package com.otmm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmm.entities.Contractor;
import com.otmm.entities.Workorder;
import com.otmm.helper.SessionFactoryRegistry;

public class OTMMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Workorder workorder1 = null;
		Workorder workorder2 = null;
		Map<String, Workorder> allotedWorkorders = null;
		Contractor contractor = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * workorder1 = new Workorder(); workorder1.setTitle("Road Contract");
			 * workorder1.setDescription("100 Feet Road"); workorder1.setStartDate(new
			 * Date()); workorder1.setBudget(100000); workorder1.setDuration(10);
			 * workorder1.setStatus("NEW"); int workorderNo1 = (int)
			 * session.save(workorder1);
			 * 
			 * workorder2 = new Workorder(); workorder2.setTitle("Drianage Work");
			 * workorder2.setDescription("Roadlining works"); workorder2.setStartDate(new
			 * Date()); workorder2.setBudget(200000); workorder2.setDuration(20);
			 * workorder2.setStatus("NEW"); int workorderNo2 = (int)
			 * session.save(workorder2);
			 * 
			 * contractor = new Contractor(); contractor.setOrganizationName("L & T");
			 * contractor.setEstablishedDate(new Date());
			 * contractor.setLicenseNo("L938393"); contractor.setContactNo("9838384994");
			 * contractor.setEmailAddress("landt@gmail.com");
			 * 
			 * allotedWorkorders = new HashMap<>(); allotedWorkorders.put("UC00022",
			 * workorder1); allotedWorkorders.put("UC00033", workorder2);
			 * 
			 * contractor.setAllotedWorkorders(allotedWorkorders); session.save(contractor);
			 */
			contractor = session.get(Contractor.class, 1);
			System.out.println(contractor);

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
