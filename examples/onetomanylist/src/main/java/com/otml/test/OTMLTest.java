package com.otml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otml.entities.Member;
import com.otml.entities.Task;
import com.otml.helper.SessionFactoryRegistry;

public class OTMLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Member member = null;
		Task task = null;
		List<Task> assignedTasks = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * task = new Task(); task.setTitle("implement login functionality");
			 * task.setDescription("login functionality for the application");
			 * task.setDuration(8); task.setStatus("Open"); assignedTasks = new
			 * ArrayList<>(); assignedTasks.add(task); int taskNo1 = (int)
			 * session.save(task);
			 * 
			 * System.out.println("task no 1: " + taskNo1);
			 * 
			 * task = new Task(); task.setTitle("reset password task"); task.
			 * setDescription("reset password post login of the user to change password");
			 * task.setDuration(6); task.setStatus("Open"); assignedTasks.add(task); int
			 * taskNo2 = (int) session.save(task);
			 * 
			 * System.out.println("task no 1: " + taskNo2);
			 * 
			 * member = new Member(); member.setMemberName("Steve");
			 * member.setProjectName("HMS"); member.setRole("lead"); member.setStartDate(new
			 * Date()); member.setExperience(8); member.setAssignedTasks(assignedTasks); int
			 * memberNo = (int) session.save(member); System.out.println("member no : " +
			 * memberNo);
			 */
			member = session.get(Member.class, 1);
			System.out.println(member);
			
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
