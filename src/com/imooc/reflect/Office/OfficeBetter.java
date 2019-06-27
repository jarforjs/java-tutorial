package com.imooc.reflect.Office;

class OfficeBetter {
	public static void main(String[] args)
	{
		try
		{
			// 动态加载类，在运行时刻加载
			Class c = Class.forName(args[0]);
			// 通过类类型创建该类的对象
			OfficeAble oa =(OfficeAble)c.newInstance();
			oa.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
