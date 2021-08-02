package com.idgenerators.test;

import com.idgenerators.dao.OutletDao;
import com.idgenerators.entities.Outlet;

public class IDGeneratorsTest {
	public static void main(String[] args) {
		OutletDao dao = new OutletDao();
		Outlet outlet = new Outlet();
		outlet.setOutletName("Kondapur Outlet");
		outlet.setDescription("Kothapet busstop center");
		outlet.setCapacity(20);
		outlet.setInChargeName("Joe");
		outlet.setLocation("Begumpet");
		outlet.setContactNo("9238393494");

		String outletNo = dao.saveOutlet(outlet);
		System.out.println("outlet no : " + outletNo);
		
		/*
		 * outlet = new Outlet(); outlet.setOutletName("Kothapet Outlet");
		 * outlet.setDescription("Kothapet busstop center"); outlet.setCapacity(20);
		 * outlet.setInChargeName("Joe"); outlet.setLocation("Begumpet");
		 * outlet.setContactNo("9238393494");
		 * 
		 * outletNo = dao.saveOutlet(outlet); System.out.println("outlet no : " +
		 * outletNo);
		 */
	}
}
