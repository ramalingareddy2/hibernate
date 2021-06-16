package com.dmlops.test;

import java.util.Date;

import com.dmlops.dao.FeedbackDao;
import com.dmlops.entities.Feedback;

public class DMLOPSTest {
	public static void main(String[] args) {
		int feedbackNo = 0;
		FeedbackDao dao = null;
		Feedback feedback = null;

		feedback = new Feedback();
		feedback.setFeedbackNo(2);
		feedback.setComments("color is very dull");
		feedback.setRating(3);
		feedback.setFeedbackDate(new Date());

		dao = new FeedbackDao();
		dao.updatePartialFeedback(feedback);
		
		//dao.deleteFeedback(3);
		//dao.mergeFeedback(feedback);
		// System.out.println("feedbackNo : " + feedbackNo);
	}
}
