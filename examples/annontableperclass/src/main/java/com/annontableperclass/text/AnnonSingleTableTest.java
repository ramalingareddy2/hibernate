package com.annontableperclass.text;

import com.annontableperclass.dao.TourDao;
import com.annontableperclass.entities.DomesticTour;
import com.annontableperclass.entities.InternationalTour;
import com.annontableperclass.entities.Tour;

public class AnnonSingleTableTest {
	public static void main(String[] args) {
		Tour tour = null;
		TourDao dao = null;
		DomesticTour domesticTour = null;
		InternationalTour internationalTour = null;

		dao = new TourDao();

		/*
		 * tour = new Tour(); tour.setSource("Hyderabad");
		 * tour.setDestination("Warangal");
		 * tour.setTourPackageName("local state tour for historic"); tour.setDays(1);
		 * tour.setAmount(6000); int tourNo = dao.saveTour(tour);
		 * System.out.println("tourNo : " + tourNo);
		 * 
		 * domesticTour = new DomesticTour(); domesticTour.setSource("Hyderabad");
		 * domesticTour.setDestination("Delhi"); domesticTour.setDays(3);
		 * domesticTour.setTourPackageName("Delhi Tour"); domesticTour.setAmount(9000);
		 * domesticTour.setAdditionalStateCharges(500);
		 * domesticTour.setTollTaxesToBePaid(1000); int dTourNo =
		 * dao.saveTour(domesticTour); System.out.println("domestic tour no : " +
		 * dTourNo);
		 * 
		 * internationalTour = new InternationalTour();
		 * internationalTour.setSource("India");
		 * internationalTour.setDestination("Singapur"); internationalTour.setDays(10);
		 * internationalTour.setTourPackageName("Singapur Tour");
		 * internationalTour.setAmount(100000);
		 * internationalTour.setPassportNo("P9383839");
		 * internationalTour.setVisaRequired(true);
		 * internationalTour.setVisaCharges(15000); int iTourNo =
		 * dao.saveTour(internationalTour); System.out.println("international tour no :"
		 * + iTourNo);
		 */

		tour = dao.find(Tour.class, 9);
		System.out.println(tour);

	}
}
