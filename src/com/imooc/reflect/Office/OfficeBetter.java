class OfficeBetter 
{
	public static void main(String[] args) 
	{
		try
		{
			// ��̬�����࣬������ʱ�̼���
			Class c = Class.forName(args[0]);
			// ͨ�������ʹ�������Ķ���
			OfficeAble oa =(OfficeAble)c.newInstance();
			oa.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
