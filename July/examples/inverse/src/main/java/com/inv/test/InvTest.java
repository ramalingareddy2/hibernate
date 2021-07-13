package com.inv.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.inv.entities.Member;
import com.inv.entities.Project;
import com.inv.helper.SessionFactoryRegistry;

public class InvTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Project project = null;
		Member member = null;
		Set<Member> members = null;
		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			project = new Project();
			project.setProjectName("hms");
			project.setStartDate(new Date());
			project.setDuration(36);

			member = new Member();
			member.setMemberName("Rick");
			member.setRole("lead");
			member.setExperience(8);
			member.setProject(project);

			members = new HashSet<>();
			members.add(member);
			project.setMembers(members);

			session.save(project);
			session.save(member);

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
