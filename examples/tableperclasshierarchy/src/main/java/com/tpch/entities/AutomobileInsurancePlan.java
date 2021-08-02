package com.tpch.entities;

import lombok.Data;

@Data
public class AutomobileInsurancePlan extends InsurancePlan {
	protected boolean fullCoverage;
	protected String vehicleType;
}
