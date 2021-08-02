package com.criteriaapi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.criteriaapi.entities.Member;
import com.criteriaapi.entities.Member_;
import com.criteriaapi.entities.Task;
import com.criteriaapi.entities.Task_;
import com.criteriaapi.helper.EntityManagerFactoryHelper;

public class CriteriaApiTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = EntityManagerFactoryHelper.getEntityManagerFactory();
			em = emf.createEntityManager();
			// printMembers(em);
			// printMemberNames(em);
			// printMemberDetails(em);
			// showMembersByExperience(em, 5);
			// showMembersByExperienceAndRole(em, 5, "Developer");
			// showMemberNameAndExperienceByMemberName(em, "S");
			// showMemberRoleAndCount(em);
			// showMembersWithTaskStatus(em, "N");
			showMembersByTaskDuration(em, 10);
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

	private static void printMembers(EntityManager em) {
		Root<Member> root = null;
		CriteriaBuilder cb = null;
		CriteriaQuery<Member> cq = null;
		TypedQuery<Member> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Member.class);

		root = cq.from(Member.class);
		cq.select(root);

		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach((e) -> {
			System.out.println(e.getMemberName());
		});
	}

	public static void printMemberNames(EntityManager em) {
		Root<Member> root = null;
		CriteriaBuilder cb = null;
		CriteriaQuery<String> cq = null;
		TypedQuery<String> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(String.class); // what you are going to get out of executing the query

		root = cq.from(Member.class);
		cq.select(root.get("memberName")); // MetaModel of the Entity class where we can pass the columns we want to
											// select from the table member.MemberName
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().stream().forEach(System.out::println);
	}

	private static void printMemberDetails(EntityManager em) {
		Root<Member> root = null; // metamodel of the Entity
		CriteriaBuilder cb = null;
		CriteriaQuery<Object[]> cq = null;
		TypedQuery<Object[]> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Object[].class); // output of the query

		root = cq.from(Member.class); // table from which we want query the data
		cq.multiselect(root.get("memberName"), root.get("role"), root.get("experience"));
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach((record) -> {
			System.out.println(record[0] + " - " + record[1] + " - " + record[2]);
		});
	}

	private static void showMembersByExperience(EntityManager em, int experience) {
		Root<Member> root = null; // metamodel of the Entity
		CriteriaBuilder cb = null;
		CriteriaQuery<Member> cq = null;
		TypedQuery<Member> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Member.class);

		root = cq.from(Member.class);
		cq.select(root);
		cq.where(cb.greaterThan(root.get("experience"), experience));
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e.getMemberName() + " - " + e.getExperience());
		});
	}

	private static void showMembersByExperienceAndRole(EntityManager em, int experience, String role) {
		Root<Member> root = null; // metamodel of the Entity
		CriteriaBuilder cb = null;
		CriteriaQuery<Member> cq = null;
		TypedQuery<Member> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Member.class);
		root = cq.from(Member.class); // dynamic meta model of the Entity will be created and returned as Root

		cq.select(root);
		cq.where(cb.and(cb.greaterThanOrEqualTo(root.get("experience"), experience), cb.like(root.get("role"), role)));
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e.getMemberName() + " - " + e.getExperience() + " - " + e.getRole());
		});
	}

	private static void showMemberNameAndExperienceByMemberName(EntityManager em, String memberName) {
		CriteriaBuilder cb = null;
		CriteriaQuery<Object[]> cq = null;
		TypedQuery<Object[]> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Object[].class);
		Root<Member> root = cq.from(Member.class);

		cq.multiselect(root.get(Member_.memberName), root.get(Member_.experience));
		cq.where(cb.like(root.get(Member_.memberName), "%" + memberName + "%"));
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e[0] + " - " + e[1]);
		});

	}

	private static void showMemberRoleAndCount(EntityManager em) {
		Root<Member> root = null;
		CriteriaBuilder cb = null;
		CriteriaQuery<Object[]> cq = null;
		TypedQuery<Object[]> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Object[].class);
		root = cq.from(Member.class);

		cq.multiselect(cb.count(root.get(Member_.memberNo)), root.get(Member_.role));
		cq.groupBy(root.get(Member_.role));

		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e[0] + " - " + e[1]);
		});

	}

	private static void showMembersWithTaskStatus(EntityManager em, String taskStatus) {
		Root<Member> root = null;
		CriteriaBuilder cb = null;
		CriteriaQuery<Object[]> cq = null;
		TypedQuery<Object[]> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Object[].class);
		root = cq.from(Member.class);
		Join<Member, Task> join = root.join(Member_.assignedTasks);
		cq.where(cb.like(join.get(Task_.status), taskStatus));
		cq.multiselect(root.get(Member_.memberName), join.get(Task_.title));

		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e[0] + "-" + e[1]);
		});
	}

	public static void showMembersByTaskDuration(EntityManager em, int duration) {
		Root<Member> root = null;
		CriteriaBuilder cb = null;
		CriteriaQuery<Object[]> cq = null;
		TypedQuery<Object[]> typedQuery = null;

		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Object[].class);
		root = cq.from(Member.class);
		Join<Member, Task> assignedTasks = root.join(Member_.assignedTasks);

		cq.multiselect(root.get(Member_.memberName), assignedTasks.get(Task_.title), assignedTasks.get(Task_.duration));
		cq.where(cb.greaterThanOrEqualTo(assignedTasks.get(Task_.duration), duration));
		typedQuery = em.createQuery(cq);
		typedQuery.getResultList().forEach(e -> {
			System.out.println(e[0] + " - " + e[1] + " - " + e[2]);
		});
	}
}
