package com.onetomany.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.onetomany.entities.Enquiry;
import com.onetomany.entities.Property;
import com.onetomany.helper.EntityManagerFactoryHelper;

public class JPQLTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = EntityManagerFactoryHelper.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			// showEnquriesByPropertyType(entityManager, "Flat");
			// showPropertiesEnquired(entityManager, "892839333");
			showPropertyEnquiryCount(entityManager, 1);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	private static void showEnquriesByPropertyType(EntityManager entityManager, String propertyType) {
		TypedQuery<Enquiry> typedQuery = null;
		List<Enquiry> enquiries = null;

		/*
		 * typedQuery = entityManager.
		 * createQuery("select e from Enquiry e where e.property.propertyType like :propertyType"
		 * , Enquiry.class);
		 */
		typedQuery = entityManager.createQuery(
				"select e from Property p inner join p.enquiries e where p.propertyType like :propertyType",
				Enquiry.class);
		typedQuery.setParameter("propertyType", propertyType);
		// here select clause and where clause both are not dereferrincing the
		// collection property so we wrote implicit join
		enquiries = typedQuery.getResultList();
		enquiries.stream().forEach((e) -> {
			System.out.println(e.getEmailAddress());
		});
	}

	private static void showPropertiesEnquired(EntityManager entityManager, String mobileNo) {
		TypedQuery<Property> typedQuery = null;
		List<Property> properties = null;

		typedQuery = entityManager.createQuery("select e.property from Enquiry e where e.mobileNo like :mobNo",
				Property.class);
		typedQuery.setParameter("mobNo", mobileNo);
		properties = typedQuery.getResultList();
		properties.stream().forEach((p) -> {
			System.out.println(p.getTitle());
		});
	}

	private static void showPropertyEnquiryCount(EntityManager entityManager, long n) {
		TypedQuery<Object[]> typedQuery = null;
		List<Object[]> records = null;

		typedQuery = entityManager.createQuery(
				"select e.property.title, count(e) from Enquiry e group by e.property having count(e) > :n",
				Object[].class);
		typedQuery.setParameter("n", n);
		records = typedQuery.getResultList();
		records.stream().forEach((record) -> {
			System.out.println(record[0] + " = " + record[1]);
		});
	}

}
// 892839333
