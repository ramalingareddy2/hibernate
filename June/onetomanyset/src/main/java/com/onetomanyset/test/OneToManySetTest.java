package com.onetomanyset.test;

import java.util.Set;

import com.onetomanyset.dao.ProductDao;
import com.onetomanyset.dao.ReviewDao;
import com.onetomanyset.entities.Product;
import com.onetomanyset.entities.Review;

public class OneToManySetTest {
	public static void main(String[] args) {
		ProductDao productDao = null;
		ReviewDao reviewDao = null;
		Product product = null;
		Review review1 = null;
		Review review2 = null;
		Set<Review> productReviews = null;

		productDao = new ProductDao();
		reviewDao = new ReviewDao();

		/*
		 * review1 = new Review(); review1.setRating(3);
		 * review1.setComment("Cheaper but doesnt meets expectation");
		 * review1.setReviewPostedDate(new Date()); review1.setReviewedBy("Charles");
		 * int reviewNo1 = reviewDao.saveReview(review1);
		 * System.out.println("review no1 : " + reviewNo1);
		 * 
		 * review2 = new Review(); review2.setRating(4);
		 * review2.setComment("Looks Good, for the price");
		 * review2.setReviewPostedDate(new Date()); review2.setReviewedBy("Robert"); int
		 * reviewNo2 = reviewDao.saveReview(review2); System.out.println("review no1 : "
		 * + reviewNo2);
		 * 
		 * product = new Product(); product.setProductName("LG Led 32 inch fullhd");
		 * product.setDescription("FullHD led tv"); product.setManufacturer("LG");
		 * product.setAmount(12000);
		 * 
		 * productReviews = new HashSet<>(); productReviews.add(review1);
		 * productReviews.add(review2); product.setProductReviews(productReviews);
		 * 
		 * int productNo = productDao.saveProduct(product);
		 * System.out.println("productNo : " + productNo);
		 */
		
		//review1 = reviewDao.getReview(2);
		//System.out.println(review1);
		
		product = productDao.getProduct(1);
		System.out.println(product.getProductName());
		Set<Review> reviews = product.getProductReviews();
		
		System.out.println(reviews);
		

	}

}



