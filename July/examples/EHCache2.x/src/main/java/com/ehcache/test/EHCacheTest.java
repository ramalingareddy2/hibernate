package com.ehcache.test;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EHCacheTest {
	public static void main(String[] args) {
		CacheManager cacheManager = new CacheManager();
		Ehcache cache = cacheManager.getEhcache("citiesCache");

		cache.put(new Element(1, "Hyderabad"));

		Element e = cache.get(1);
		System.out.println(e.getValue());

	}
}
