package interface_default_method;

public class DefaultMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c=new Child();
		System.out.println("�پ��� �������̽� �� "
				+ "�޼��� ���� ������ "
				+ "'�������̽��� ������ Ŭ����'����"
				+ " ����Ʈ �޼��带 �������̵�!");
		c.method1();//override
		System.out.println("���� Ŭ���� ���� �ִ� �޼����"
				+ " �������̽� ���� �ִ� ������ �޼����� �̸���"
				+ " ������ ����Ʈ �޼���� ����!");
		c.method2();//Parent
		//static �޼���� �������̽� �ȿ� ����
		/*method2�� ����Ŭ������ Parent ���� �ִ� �Ͱ�
		 * MyInterface ���� �ִ°��� �̸��� ����!
		 * ���� �������̽��޼��尡 �ƴ� ParentŬ������
		 * �ִ� ���� ȣ��� ��
		 * 
		 */
		//static �޼��尡 �����ڰ� default�̹Ƿ�
		//Ŭ���������� ����
		System.out.println("�������̽�-static method");
		System.out.println("MyInterface");
		MyInterface.staticMethod();
		System.out.println("MyInterface2");
		MyInterface2.staticMethod();
	}

}
