package com.objectClass.toString;

public class CardToString {

	/**
	 * 
	 * @param args
	 * 
	 * public String toString()
	 * {
	 * 		return getClass().getName()+"@"+Integer.toHexString(HashCode());
	 * }
	 * -->해시코드 반환
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c = new Card();
		System.out.println("오버라이딩 안하고 toString쓰기: "+c.toString());
	}
	
}
