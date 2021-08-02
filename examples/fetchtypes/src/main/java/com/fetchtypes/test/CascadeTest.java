package com.fetchtypes.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fetchtypes.entities.Member;
import com.fetchtypes.entities.Task;
import com.fetchtypes.helper.SessionFactoryRegistry;

public class CascadeTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Member member = null;
		Task task = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * member = new Member(); member.setMemberName("Williams");
			 * member.setRole("Lead Developer"); member.setExperience(6);
			 */
			// session.save(member);

			/*
			 * task = new Task(); task.setTitle("service logic build business logic");
			 * task.setDescription("business layer"); task.setDuration(4);
			 * task.setMember(member);
			 */
			// session.save(task);

			/*
			 * task = session.get(Task.class, 12);
			 * task.setTitle("Business logic in Service Layer"); member =task.getMember();
			 * member.setExperience(9); session.update(task);
			 */
			// member = session.get(Member.class, 4);
			/*
			 * Set<Task> tasks = member.getTasks(); for (Task t : tasks) {
			 * member.getTasks().remove(t); session.delete(t); }
			 */
			// session.delete(member);

			member = session.get(Member.class, 6);
			Task t = session.get(Task.class, 12);
			member.getTasks().remove(t);
			session.update(member);

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
