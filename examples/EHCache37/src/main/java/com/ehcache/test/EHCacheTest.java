package com.ehcache.test;

import java.io.IOException;
import java.util.List;

import com.ehcache.accessor.CityAccessor;

public class EHCacheTest {
	public static void main(String[] args) throws IOException {
		CityAccessor cityAccessor = new CityAccessor();
		List<String> cities = cityAccessor.getCities();
		cities.forEach(System.out::println);
		
		System.out.println("----------------------------- 2nd ------------------------");
		
		cities = cityAccessor.getCities();
		cities.forEach(System.out::println);
	}
}
