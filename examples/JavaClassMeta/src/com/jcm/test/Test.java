package com.jcm.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Class<?> accountAccessorClass = AccountAccessor.class;
		Class<?> accountAccessorClass = Class.forName("com.jcm.accessor.AccountAccessor");

		Field[] fields = accountAccessorClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}

		Method[] methods = accountAccessorClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		Constructor<?>[] contructors = accountAccessorClass.getDeclaredConstructors();
		for (Constructor<?> constructor : contructors) {
			System.out.println(constructor.getName());
		}

		Method method = accountAccessorClass.getDeclaredMethod("getAccountHolderName", int.class);
		System.out.println(method.getName());
		Object obj = accountAccessorClass.newInstance();
		String accountHolderName = (String) method.invoke(obj, 10);
		System.out.println("accountHolderName : " + accountHolderName);

	}
	
}













