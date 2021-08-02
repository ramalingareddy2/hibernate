package com.criteriaapi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.criteriaapi.entities.Member;
import com.criteriaapi.helper.EntityManagerFactoryHelper;

public class HQLTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = EntityManagerFactoryHelper.getEntityManagerFactory();
			em = emf.createEntityManager();

			TypedQuery<Member> typedQuery = em.createNamedQuery("getMembersByExperience", Member.class);
			typedQuery.setParameter("experience", 5);
			typedQuery.getResultList().forEach(e -> {
				System.out.println(e.getMemberName());
			});
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
