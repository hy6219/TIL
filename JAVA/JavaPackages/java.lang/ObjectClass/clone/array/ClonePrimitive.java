package com.objectClass.clone.primitive;

public class ClonePrimitive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		
		int[] cp = new int[arr.length];
		cp = arr.clone();
		
		for(int i = 0; i < cp.length; i++)
		{
			System.out.println("arr["+i+"]: "+arr[i] + ""
					+ ", cp["+i+"]: "+cp[i]);
		}
		
		System.out.println("arr hashcode: "+arr.hashCode()+","
				+ " cp hashcode: "+cp.hashCode());
		
		/**
		 * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone%28%29
		 * 
		 * 객체의 경우 CloneNotSupportedException 에러를 낼 수 있고 반환형태가 Object이므로
		 * "Cloneable" 인터페이스를 구현하여 사용해야 하지만,
		 * 
		 * 배열은 반환형태가 T[]이기 때문에 캐스팅도, Cloneable 인터페이스를 구현하지 않아도 됨
		 */
	}

}
