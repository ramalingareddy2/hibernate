package com.tpch.test;

import com.tpch.dao.InsurancePlanDao;
import com.tpch.entities.AccidentalInsurancePlan;
import com.tpch.entities.AutomobileInsurancePlan;
import com.tpch.entities.InsurancePlan;

public class TPCHTest {
	public static void main(String[] args) {
		InsurancePlanDao dao = new InsurancePlanDao();

		/*
		 * InsurancePlan ip = new InsurancePlan(); ip.setPlanName("Jeevan bheema");
		 * ip.setMinEligibilityAge(18); ip.setMaxEligibilityAge(60); ip.setMinTenure(5);
		 * ip.setMaxTenure(40); ip.setMinAmount(500000);
		 * 
		 * int ipPlanNo = dao.saveInsurancePlan(ip);
		 * System.out.println("insurance plan no : " + ipPlanNo);
		 * 
		 * AccidentalInsurancePlan aip = new AccidentalInsurancePlan();
		 * aip.setPlanName("Jeevan suraksha"); aip.setMinEligibilityAge(21);
		 * aip.setMaxEligibilityAge(59); aip.setMinTenure(1); aip.setMaxTenure(3);
		 * aip.setMinAmount(100000); aip.setInternationalCoverage(true);
		 * aip.setDisabilityCoveragePercentage(50); int aipPlanNo =
		 * dao.saveInsurancePlan(aip);
		 * 
		 * System.out.println("accidental insurance plan no : " + aipPlanNo);
		 * 
		 * AutomobileInsurancePlan amip = new AutomobileInsurancePlan();
		 * amip.setPlanName("totalprotection"); amip.setMinEligibilityAge(0);
		 * amip.setMaxEligibilityAge(16); amip.setMinTenure(1); amip.setMaxTenure(3);
		 * amip.setMinAmount(100000); amip.setFullCoverage(true);
		 * amip.setVehicleType("4 Wheeler");
		 * 
		 * int amipPlanNo = dao.saveInsurancePlan(amip);
		 * System.out.println("automobile insurance plan no : " + amipPlanNo);
		 */

		InsurancePlan ip = dao.getInsurancePlan(InsurancePlan.class, 1);
		System.out.println(ip);
	}
}
