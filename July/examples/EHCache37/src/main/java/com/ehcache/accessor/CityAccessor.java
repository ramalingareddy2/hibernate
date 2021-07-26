package com.ehcache.accessor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class CityAccessor {
	private CacheManager cacheManager;

	public CityAccessor() {
		URL url = null;
		url = this.getClass().getClassLoader().getResource("cache.xml");
		Configuration configuration = new XmlConfiguration(url);
		cacheManager = CacheManagerBuilder.newCacheManager(configuration);
		cacheManager.init();
	}

	public List<String> getCities() throws IOException {

		final List<String> cities = new ArrayList<String>();

		final Cache<Integer, String> citiesCache = cacheManager.getCache("citiesCache", Integer.class, String.class);
		boolean hasData = citiesCache.iterator().hasNext();

		if (hasData == false) {
			System.out.println("from file");
			final Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("cities.properties"));
			props.keySet().forEach(propKey -> {
				citiesCache.put(Integer.parseInt((String) propKey), props.getProperty((String) propKey));
			});
		}

		citiesCache.forEach(entry -> {
			cities.add(entry.getValue());
		});

		return cities;
	}
}
