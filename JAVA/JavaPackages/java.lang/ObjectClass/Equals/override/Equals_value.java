package com.objectClass.equals;

public class Equals_value{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value_re[] v = new Value_re[3];
		
		for(int i = 0 ; i < v.length ; i++)
		{
			v[i] = new Value_re((int)(Math.random() * ((i + 1) * 10)));
		}
		System.out.println("복사 전: ");
		int temp = v[0].value;
		/*
		 * 추가
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
				System.out.println("v[0]과 v["+i+"]는 같습니다");
				
			}
			else
			{
				System.out.println("v[0]과 v["+i+"]는 다릅니다");
			}
			
//			if(temp == v[i].Value_re)
//			{
//				System.out.println("v[0].Value_re와 v["+i+"].Value_re는 같습니다");
//			}
//			else
//			{
//				System.out.println("v[0].Value_re와 v["+i+"].Value_re는 다릅니다");
//			}
			
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
		
		
		System.out.println("복사 후: ");
		/*
		 * 추가
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
				System.out.println("v[0]과 v["+i+"]는 같습니다");
			}
			else
			{
				System.out.println("v[0]과 v["+i+"]는 다릅니다");
			}
			
//			if(temp == v[i].Value_re)
//			{
//				System.out.println("v[0].Value_re와 v["+i+"].Value_re는 같습니다");
//			}
//			else
//			{
//				System.out.println("v[0].Value_re와 v["+i+"].Value_re는 다릅니다");
//			}
			System.out.println("v[0] hashcode: "+v[0].hashCode()+", v[0].value: "+temp);
			System.out.println("v["+i+"] hashcode: "+v[i].hashCode()+", v["+i+"].value: "+v[i].value);
		}
	}

}
