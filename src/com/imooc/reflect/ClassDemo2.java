class ClassDemo2 
{
	public static void main(String[] args) 
	{
		Class c1 = int.class;//int的类类型
		Class c2 = String.class;//String类的类类型 String类字节码
		Class c3=double.class;//double数据类型的字节码
		Class c4=Double.class;//Double类的类类型字节码表示方式
		Class c5 =void.class;

		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
	}
}
