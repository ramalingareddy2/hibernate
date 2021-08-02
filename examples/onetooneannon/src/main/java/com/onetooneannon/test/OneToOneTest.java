package com.onetooneannon.test;

import java.util.Date;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.onetooneannon.entities.ElectricityBill;
import com.onetooneannon.entities.Receipt;
import com.onetooneannon.helper.EntityManagerFactoryHelper;

public class OneToOneTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		ElectricityBill electricityBill = null;
		Receipt receipt = null;

		try {
			entityManagerFactory = EntityManagerFactoryHelper.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			/*
			 * electricityBill = new ElectricityBill();
			 * electricityBill.setServiceNo("SC0298393");
			 * electricityBill.setConsumerNo("C93839334"); electricityBill.setUnits(100);
			 * electricityBill.setBillAmount(1000); entityManager.persist(electricityBill);
			 * 
			 * receipt = new Receipt();
			 * receipt.setTransactionNo(UUID.randomUUID().toString());
			 * receipt.setPaidDate(new Date()); receipt.setAmount(1000);
			 * receipt.setElectricityBill(electricityBill); entityManager.persist(receipt);
			 */
			
			electricityBill = entityManager.find(ElectricityBill.class, 1);
			System.out.println("bill amount :"  +electricityBill.getBillAmount());
			System.out.println("reference no : "+ electricityBill.getReceipt().getTransactionNo());

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
