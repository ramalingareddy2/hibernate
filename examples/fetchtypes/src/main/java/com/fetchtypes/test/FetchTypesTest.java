package com.fetchtypes.test;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fetchtypes.entities.Member;
import com.fetchtypes.entities.Task;
import com.fetchtypes.helper.SessionFactoryRegistry;

public class FetchTypesTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Member member = null;
		Set<Task> tasks = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * member = session.get(Member.class, 1); System.out.println("member Name: " +
			 * member.getMemberName());
			 * 
			 * tasks = member.getTasks(); for (Task task : tasks) {
			 * System.out.println(task.getTitle()); }
			 */
			Query query = session.createQuery("from Member");
			List<Member> members = query.getResultList();

			for (Member member1 : members) {
				System.out.println(member1.getMemberName() + " Tasks: ");
				for(Task task : member1.getTasks()) {
					System.out.println(task.getTitle());
				}
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

	}

}
