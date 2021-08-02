package com.mtma.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.mtma.entities.Customer;
import com.mtma.entities.Loan;
import com.mtma.helper.EntityManagerFactoryHelper;

public class MTMATest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		Customer customer1 = null;
		Customer customer2 = null;
		Loan loan = null;
		Set<Customer> customers = null;

		try {
			entityManagerFactory = EntityManagerFactoryHelper.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			/*
			 * customer1 = new Customer(); customer1.setCustomerName("Rick");
			 * customer1.setAge(23); customer1.setGender("Male"); //
			 * entityManager.persist(customer1);
			 * 
			 * customer2 = new Customer(); customer2.setCustomerName("Johnson");
			 * customer2.setAge(25); customer2.setGender("Male"); //
			 * entityManager.persist(customer2);
			 * 
			 * customers = new HashSet<>(); customers.add(customer1);
			 * customers.add(customer2);
			 * 
			 * loan = new Loan(); loan.setLoanType("home loan");
			 * loan.setInterestRate(7.65f); loan.setPrincipleAmount(6000000);
			 * loan.setTenure(113); loan.setCustomers(customers);
			 * 
			 * entityManager.persist(loan);
			 */
			loan = entityManager.find(Loan.class, 1);
			System.out.println("interestRate :" + loan.getInterestRate());

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
