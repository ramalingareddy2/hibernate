package com.hibannon.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant implements Serializable {
	@Id
	@Column(name = "merchant_no")
	protected int merchantNo;
	@Column(name = "merchant_nm")
	protected String merchantName;
	@Column(name = "business_nm")
	protected String businessName;
	@Column(name = "contact_no")
	protected String contactNo;
	@Column(name = "email_address")
	protected String emailAddress;
	protected String location;

	public int getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(int merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Merchant [merchantNo=" + merchantNo + ", merchantName=" + merchantName + ", businessName="
				+ businessName + ", contactNo=" + contactNo + ", emailAddress=" + emailAddress + ", location="
				+ location + "]";
	}

}
