package com.imooc.reflect;

import java.lang.reflect.Method;

public class BeanUtil {
	/**
	 * 根据标准javaBean对象的属性名获取其属性值
	 *
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static Object getValueByPropertyName(Object obj, String propertyName) {
		// 1.根据属性名称就可以获取其get方法
		String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
		System.out.println("getMethodName1: "+propertyName.substring(0, 1).toUpperCase());
		System.out.println("getMethodName2: "+propertyName.substring(1));
		System.out.println("getMethodName: "+getMethodName);
		//2.获取方法对象
		Class c = obj.getClass();
		try {
			//get方法都是public的且无参数
			Method m= c.getMethod(getMethodName);
			//3 通过方法的反射操作方法
			return m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
