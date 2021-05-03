package com.htxm.entities;

import java.io.Serializable;

public class LoanAccount implements Serializable {
	protected int loanAccountNo;
	protected String loanAccountHolderName;
	protected String loanType;
	protected int tenure;
	protected double amount;

	public int getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(int loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public String getLoanAccountHolderName() {
		return loanAccountHolderName;
	}

	public void setLoanAccountHolderName(String loanAccountHolderName) {
		this.loanAccountHolderName = loanAccountHolderName;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanAccountHolderName == null) ? 0 : loanAccountHolderName.hashCode());
		result = prime * result + loanAccountNo;
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
		result = prime * result + tenure;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanAccount other = (LoanAccount) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (loanAccountHolderName == null) {
			if (other.loanAccountHolderName != null)
				return false;
		} else if (!loanAccountHolderName.equals(other.loanAccountHolderName))
			return false;
		if (loanAccountNo != other.loanAccountNo)
			return false;
		if (loanType == null) {
			if (other.loanType != null)
				return false;
		} else if (!loanType.equals(other.loanType))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanAccount [loanAccountNo=" + loanAccountNo + ", loanAccountHolderName=" + loanAccountHolderName
				+ ", loanType=" + loanType + ", tenure=" + tenure + ", amount=" + amount + "]";
	}

}
