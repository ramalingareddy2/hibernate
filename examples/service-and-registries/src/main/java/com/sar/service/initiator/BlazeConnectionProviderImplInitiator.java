package com.sar.service.initiator;

import java.util.Map;

import org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.ServiceRegistryImplementor;

import com.sar.service.BlazeConnectionProviderImpl;

public class BlazeConnectionProviderImplInitiator extends ConnectionProviderInitiator {
	@Override
	public ConnectionProvider initiateService(Map configurationValues, ServiceRegistryImplementor registry) {
		System.out.println("BlazeConnectionProviderImplInitiator.initiateService()");
		return new BlazeConnectionProviderImpl();
	}
}
