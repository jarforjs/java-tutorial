class ClassDemo2 
{
	public static void main(String[] args) 
	{
		Class c1 = int.class;//int��������
		Class c2 = String.class;//String��������� String���ֽ���
		Class c3=double.class;//double�������͵��ֽ���
		Class c4=Double.class;//Double����������ֽ����ʾ��ʽ
		Class c5 =void.class;

		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
	}
}
