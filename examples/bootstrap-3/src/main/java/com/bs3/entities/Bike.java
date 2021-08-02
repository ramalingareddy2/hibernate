package com.bs3.entities;

import java.io.Serializable;

public class Bike implements Serializable {
	private static final long serialVersionUID = 450543678070675972L;
	protected int bikeNo;
	protected String bikeModelName;
	protected String manufacturer;
	protected String rtaRegistrationNo;
	protected double price;

	public int getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(int bikeNo) {
		this.bikeNo = bikeNo;
	}

	public String getBikeModelName() {
		return bikeModelName;
	}

	public void setBikeModelName(String bikeModelName) {
		this.bikeModelName = bikeModelName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getRtaRegistrationNo() {
		return rtaRegistrationNo;
	}

	public void setRtaRegistrationNo(String rtaRegistrationNo) {
		this.rtaRegistrationNo = rtaRegistrationNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bikeModelName == null) ? 0 : bikeModelName.hashCode());
		result = prime * result + bikeNo;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rtaRegistrationNo == null) ? 0 : rtaRegistrationNo.hashCode());
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
		Bike other = (Bike) obj;
		if (bikeModelName == null) {
			if (other.bikeModelName != null)
				return false;
		} else if (!bikeModelName.equals(other.bikeModelName))
			return false;
		if (bikeNo != other.bikeNo)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rtaRegistrationNo == null) {
			if (other.rtaRegistrationNo != null)
				return false;
		} else if (!rtaRegistrationNo.equals(other.rtaRegistrationNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bike [bikeNo=" + bikeNo + ", bikeModelName=" + bikeModelName + ", manufacturer=" + manufacturer
				+ ", rtaRegistrationNo=" + rtaRegistrationNo + ", price=" + price + "]";
	}

}
