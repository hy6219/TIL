package com.objectClass.string;

import java.util.StringJoiner;

public class joinNStringjoiner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String animals = "dog,"
				+ "cat,"
				+ "bear";
		
		String[] arr = animals.split(",");

		
		String s = String.join("-", arr);//(join할 구분자, 문자열배열)
		//구분자, 문자열1개--> 이을 것이 없어서 그냥 문자열이 출력됨
	
		String cs =String.join("-", "dog","cat","bear");
		String comp = String.join("-", "dogcatbear");
		System.out.println("s: "+s+", hashCode: "+s.hashCode()+
				", identity: "+System.identityHashCode(s));//dog-cat-bear
		System.out.println("cs: "+cs+", hashCode: "+cs.hashCode()+
				", identity: "+System.identityHashCode(cs));//dog-cat-bear
		System.out.println("comp: "+comp+", hashCode: "+comp.hashCode()+
				", identity: "+System.identityHashCode(comp));//dogcatbear
		
		System.out.println("======================");
		System.out.println("StringJoiner");//java.util.StringJoiner
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i = 0 ; i < arr.length; i++)
		{
			sj.add(arr[i]);
		}
		//StringJoiner sj = new StringJoiner(구분자,앞에 붙일 문자,뒤에 붙일 문자);
		System.out.println(sj.toString());
		
		StringJoiner sjj = new StringJoiner(",");
		
		for(int i = 0 ; i < arr.length; i++)
		{
			sjj.add(arr[i]);
		}
		//StringJoiner sjj = new StringJoiner(구분자);==
		//StringJoiner sjj = new StringJoiner(구분자,"","");
		System.out.println(sjj.toString());
	}

}
