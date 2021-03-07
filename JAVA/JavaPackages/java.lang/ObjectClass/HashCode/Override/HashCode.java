package com.objectClass.hashCode;

import java.util.Objects;
/**
 * 
 * @author gs813
 *equals를 오버라이딩할 때에는 hashCode를 반드시 오버라이딩해주어야 한다!.PNG
 */
public class HashCode {

	String name;
	int age;
	String pass;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashCode h = new HashCode();
		h.name = "홍길동";
		h.age  = 123;
		h.pass = "pass";
		
		HashCode h1 = new HashCode();
		h1.name = "홍길동";
		h1.age  = 123;
		h1.pass = "pass";
		System.out.println("h.name의 해시코드: "+h.name.hashCode());
		System.out.println("h.pass의 해시코드: "+h.pass.hashCode());
		System.out.println("h의 해시코드: "+h.hashCode());
		
		System.out.println();
		
		System.out.println("h1.name의 해시코드: "+h1.name.hashCode());
		System.out.println("h1.pass의 해시코드: "+h1.pass.hashCode());
		System.out.println("h1의 해시코드: "+h1.hashCode());
		
		System.out.println();
		System.out.println("h1.equals(h)?"+h1.equals(h));
	}
//	@Override
//	public int hashCode()
//	{
//		//https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
//		int res = 17;
//		res = 31 * res + name.hashCode();
//		//res = 31 * res + age.hashCode();//Cannot invoke hashCode() on the primitive type int
//		res = 31 * res + age;
//		res = 31 * res + pass.hashCode();
//		return res;
//	}
	@Override
	public int hashCode()
	{
		return Objects.hash(name, age, pass);
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof HashCode)
		{
			if(((HashCode)obj).name.equals(name) && ((HashCode)obj).pass.equals(pass) && ((HashCode)obj).age == age)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
