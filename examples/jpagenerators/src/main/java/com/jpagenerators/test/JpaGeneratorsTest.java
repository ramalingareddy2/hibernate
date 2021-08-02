package com.jpagenerators.test;

import java.util.Date;

import com.jpagenerators.dao.BillDao;
import com.jpagenerators.entities.Bill;

public class JpaGeneratorsTest {
	public static void main(String[] args) {
		BillDao billDao = null;
		Bill bill = null;

		bill = new Bill();
		bill.setBillDate(new Date());
		bill.setCustomerName("Paul");
		bill.setDescription("Bike Tyre");
		bill.setAmount(2000);

		billDao = new BillDao();
		int billNo = billDao.saveBill(bill);
		System.out.println("bill no :" + billNo);
	}
}
