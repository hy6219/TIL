package interface_default_method;

public class Child extends Parent implements MyInterface, MyInterface2{

	/**
	 * �̸��� ���� �޼��尡 �ΰ� �̻� �������̽���
	 * ������ ���,
	 * �������̽� 1�� �������̽� 2 �� �� ����
	 * �ִ� �޼��带 �������̵����ֱ�!
	 * 
	 * 1)overriding
	 * public void method1(){A}
	 * public void method1(){B}
	 * 
	 * ++�������̵�: ����Ÿ��, �Ű�����, �̸���
	 * ������!!
	 * ������ �ٸ���!
	 * 
	 * 2)overloading
	 * public void method(){}
	 * public void method(int x){}
	 * public void method(int x, int y){}
	 * public int method(int x){return x;}
	 *++�����ε�: �Ű����� or ����Ÿ���� �޶�� ��!-->
	 *�ٺ������� ���� ����� ������ 
	 *�۸��� �ϴ� ���� ���� ���ŷο��� �����ϴµ�
	 *�̸� ���� �� ����
	 *
	 *
	 */
	//MyInterface,MyInterface2�� method1�� ��ħ!
	//-->�������̵��ؾ�!
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("method1() in Child");
	}


}
