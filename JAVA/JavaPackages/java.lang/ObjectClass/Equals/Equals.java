package com.objectClass.equals;

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Value v1 = new Value(10);
//		Value v2 = new Value(20);
//		Value v3 = new Value(10);
		
		Value[] v = new Value[3];
		
		for(int i = 0 ; i < v.length ; i++)
		{
			v[i] = new Value((int)(Math.random() * ((i + 1) * 10)));
		}
		System.out.println("���� ��: ");
		int temp = v[0].value;
		/*
		 * �߰�
		 */
		for(int i = 0 ; i < v. length; i++)
		{
			System.out.println("v["+i+"]. hashcode: "+v[i].hashCode()+
					", v["+i+"]. value: "+v[i].value);
		}
		for(int i = 1 ; i < v. length; i++)
		{
			
			if(v[0].equals(v[i]))
			{
				System.out.println("v[0]�� v["+i+"]�� �����ϴ�");
				
			}
			else
			{
				System.out.println("v[0]�� v["+i+"]�� �ٸ��ϴ�");
			}
			
			if(temp == v[i].value)
			{
				System.out.println("v[0].value�� v["+i+"].value�� �����ϴ�");
			}
			else
			{
				System.out.println("v[0].value�� v["+i+"].value�� �ٸ��ϴ�");
			}
			
			System.out.println("v[0] hashcode: "+v[0].hashCode()+", v[0].value: "+temp);
			System.out.println("v["+i+"] hashcode: "+v[i].hashCode()+", v["+i+"].value: "+v[i].value);
		}
	
		/**
		 * deep copy
		 */
		for(int i = 1; i < v.length; i++)
		{
			v[i].value = v[0].value;
		}
		
		
		System.out.println("���� ��: ");
		/*
		 * �߰�
		 */
		for(int i = 0 ; i < v. length; i++)
		{
			System.out.println("v["+i+"]. hashcode: "+v[i].hashCode()+
					", v["+i+"]. value: "+v[i].value);
		}
		for(int i = 1 ; i < v. length; i++)
		{
			if(v[0].equals(v[i]))
			{
				System.out.println("v[0]�� v["+i+"]�� �����ϴ�");
			}
			else
			{
				System.out.println("v[0]�� v["+i+"]�� �ٸ��ϴ�");
			}
			
			if(temp == v[i].value)
			{
				System.out.println("v[0].value�� v["+i+"].value�� �����ϴ�");
			}
			else
			{
				System.out.println("v[0].value�� v["+i+"].value�� �ٸ��ϴ�");
			}
			System.out.println("v[0] hashcode: "+v[0].hashCode()+", v[0].value: "+temp);
			System.out.println("v["+i+"] hashcode: "+v[i].hashCode()+", v["+i+"].value: "+v[i].value);
		}
	}

}
