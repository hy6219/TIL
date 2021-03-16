package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "A broken hand works,"
				+ " but not a broken heart";
		
		String pattern= "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);//다른 *, [ ,..등을 사용하지 않고
		//문자열로도 가능 (<-broken이 들어간 첫 구간을 찾는다고 생각)
		
		Matcher m = p.matcher(source);//source에서 일치하는 곳이 있는지 찾기
		
		System.out.println("source: "+source);
		
		int i = 0 ;
		//find로 패턴과 일치하는 부분찾기
		while(m.find())
		{
			System.out.println(
					(++i)+" 번째 매칭 : "+m.start()+"~"+m.end()
					);
			
			//broken을 beautiful으로 치환하고
			//찾을때마다, 등장위치전까지의 문자 + 치환된 문자를 sb에 저장
			m.appendReplacement(sb, "beautiful");
		}
		//추가위치에서 시작하여 지정된 문자열 버퍼에 문자 추가
		m.appendTail(sb);
		//마지막으로 치환된 이후의 부분을 sb에 덧붙이기
		System.out.println("Replacement count: "+i);
		System.out.println("result: "+sb.toString());
		
	}

}
