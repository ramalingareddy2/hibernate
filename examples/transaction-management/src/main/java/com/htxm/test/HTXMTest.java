package com.htxm.test;

import com.htxm.dao.LoanAccountDao;
import com.htxm.entities.LoanAccount;
import com.htxm.helper.SessionFactoryRegistry;

public class HTXMTest {
	public static void main(String[] args) {
		try {
			LoanAccountDao loanAccountDao = new LoanAccountDao();
			LoanAccount loanAccount = new LoanAccount();
			loanAccount.setLoanAccountNo(299);
			loanAccount.setLoanAccountHolderName("Paul");
			loanAccount.setLoanType("Home Loan");
			loanAccount.setTenure(120);
			loanAccount.setAmount(2300000);

			loanAccountDao.saveLoanAccount(loanAccount);
			System.out.println("loanAccount saved");
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
