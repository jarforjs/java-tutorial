package com.imooc.reflect;

import java.lang.reflect.Method;

public class BeanUtil {
	/**
	 * ���ݱ�׼javaBean�������������ȡ������ֵ
	 *
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static Object getValueByPropertyName(Object obj, String propertyName) {
		// 1.�����������ƾͿ��Ի�ȡ��get����
		String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
		System.out.println("getMethodName1: "+propertyName.substring(0, 1).toUpperCase());
		System.out.println("getMethodName2: "+propertyName.substring(1));
		System.out.println("getMethodName: "+getMethodName);
		//2.��ȡ��������
		Class c = obj.getClass();
		try {
			//get��������public�����޲���
			Method m= c.getMethod(getMethodName);
			//3 ͨ�������ķ����������
			return m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
