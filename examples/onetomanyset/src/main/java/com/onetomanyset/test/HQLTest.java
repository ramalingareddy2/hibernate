package com.onetomanyset.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.onetomanyset.dto.ProductDto;
import com.onetomanyset.entities.Product;
import com.onetomanyset.helper.SessionFactoryRegistry;

public class HQLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			/*
			 * Query query = session.createQuery("from Product"); List<Product> products =
			 * query.getResultList(); for (Product product : products) {
			 * System.out.println(product.getProductName()); }
			 */
			/*
			 * TypedQuery<Product> typedQuery = session.createQuery("from Product",
			 * Product.class); List<Product> products = typedQuery.getResultList();
			 * products.stream().forEach(System.out::println);
			 */
			// showProductsByManufacturer(session, "LG");
			// showNoOfProducts(session);
			// showProductsBetweenPriceOrderByManufacturer(session, 2000, 25000);
			// showProductNameAndPrice(session);
			// showProductDto(session);
			showProductsByReviewerImplicit(session, "Patrik");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static void showProductsByManufacturer(Session session, String manufacturer) {
		TypedQuery<Product> typedQuery = null;

		typedQuery = session.createQuery("from Product p where p.manufacturer = :manufacturer", Product.class);
		typedQuery.setParameter("manufacturer", manufacturer);
		typedQuery.getResultList().stream().forEach(System.out::println);
	}

	private static void showNoOfProducts(Session session) {
		TypedQuery<Long> typedQuery = null;

		typedQuery = session.createQuery("select count(p) from Product p", Long.class);
		System.out.println("no of products : " + typedQuery.getResultList().get(0));
	}

	private static void showProductsBetweenPriceOrderByManufacturer(Session session, double minPrice, double maxPrice) {
		TypedQuery<Product> typedQuery = null;

		typedQuery = session.createQuery(
				"from Product p where p.amount between :minPrice and :maxPrice order by p.manufacturer", Product.class);
		typedQuery.setParameter("minPrice", minPrice);
		typedQuery.setParameter("maxPrice", maxPrice);
		typedQuery.getResultList().stream().forEach(System.out::println);
	}

	private static void showProductNameAndPrice(Session session) {
		TypedQuery<Object[]> typedQuery = null;
		List<Object[]> records = null;

		typedQuery = session.createQuery("select p.productName, p.amount from Product p", Object[].class);
		records = typedQuery.getResultList();
		for (Object[] record : records) {
			System.out.println("productName : " + record[0] + " amount : " + record[1]);
		}
	}

	private static void showProductDto(Session session) {
		TypedQuery<ProductDto> typedQuery = null;
		List<ProductDto> products = null;

		typedQuery = session.createQuery(
				"select new com.onetomanyset.dto.ProductDto(p.productNo, p.productName, p.amount) from Product p",
				ProductDto.class);
		products = typedQuery.getResultList();
		products.stream().forEach((prod) -> {
			System.out.println(prod.getProductName());
		});
	}

	// give me all products who has average rating of 3
	private static void showProductsByReviewer(Session session, String reviewedBy) {
		TypedQuery<Object[]> typedQuery = null;
		List<Object[]> records = null;

		typedQuery = session.createQuery(
				"select p.productNo, p.productName, r.rating, r.reviewedBy from Product p inner join p.productReviews r where r.reviewedBy like :rb",
				Object[].class);
		typedQuery.setParameter("rb", reviewedBy);
		records = typedQuery.getResultList();
		records.stream().forEach((record) -> {
			System.out.println(record[0] + " - " + record[1] + " - " + record[2]);
		});
	}

	private static void showProductsByReviewerImplicit(Session session, String reviewedBy) {
		TypedQuery<Object[]> typedQuery = null;
		List<Object[]> records = null;

		typedQuery = session.createQuery(
				"select r.product.productNo, r.product.productName, r.rating from Review r where r.reviewedBy like :rb",
				Object[].class);
		typedQuery.setParameter("rb", reviewedBy);
		records = typedQuery.getResultList();
		records.stream().forEach((record) -> {
			System.out.println(record[0] + " - " + record[1] + " - " + record[2]);
		});
	}

}
