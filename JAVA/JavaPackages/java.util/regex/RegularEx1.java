package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {
			"bat", "baby", "bonus","bc","Bc","bC","bcde","bca","abc",
			"c","cA","ca","CA","ca","CAB","Cab","Ca1","C1","CAB2","C가나다",
			"c.","ca.","c.a","c1","c123",
			"date","day",
			"eat"
			};
		System.out.println("c로 시작하는 소문자 영단어(길이와 무관)");
		//패턴
		Pattern p = Pattern.compile("c[a-z]*");
		//c로 시작하는 소문자 영단어(글자길이는 상관없음)
		
		for(int i = 0 ; i < data.length; i++)
		{
			Matcher m = p.matcher(data[i]);
			if(m.matches())
			{
				System.out.print(data[i]+" ");//c ca ca 
			}
		}
		System.out.println();
		/*
		 * c로 시작하는 두자리 영단어 c[a-z]
		 */
		System.out.println("=======================================");
		System.out.println("c로 시작하면서 소문자 한글자로 이루어진 경우(두글자)");
		int j = 0 ;
		//1.패턴
		p = Pattern.compile("c[a-z]");
		for(j = 0 ; j < data.length;j ++)
		{
			//2.Matcher타입의 메서드 이용->Matcher 인스턴스 얻음
			Matcher m = p.matcher(data[j]);
			//3.boolean matches()->정규식에 부합하는지 확인
			if(m.matches())
			{
				System.out.print(data[j]+"\t");//ca	ca	
			}
		}
		System.out.println();
		System.out.println("=======================================");
		
		System.out.println("c로 시작하면서, 대문자 영단어를 포함하는 경우(두글자)");
		//1.패턴
		p = Pattern.compile("c[A-Z]");
		for(j = 0 ; j < data.length;j ++)
		{
			//2.Matcher타입의 메서드 이용->Matcher 인스턴스 얻음
			Matcher m = p.matcher(data[j]);
			//3.boolean matches()->정규식에 부합하는지 확인
			if(m.matches())
			{
				System.out.print(data[j]+"\t");//ca	ca	
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c로 시작하면서, 대소문자 상관 없이영단어를 포함하는 경우(두글자)");
		p = Pattern.compile("c[a-zA-Z]");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c로 시작하면서, 대소문자 상관 없이영단어를 포함하는 경우(글자 상관 없이)");
		p = Pattern.compile("c[a-zA-Z]*");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 대소문자 상관 없이영단어를 포함하는 경우(글자 상관 없이)");
		p = Pattern.compile("[cC][a-zA-Z]*");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 대소문자 상관 없이영단어를 포함하는 경우(두글자)");
		p = Pattern.compile("[cC][a-zA-Z]");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 대소문자 상관 없이영단어를 포함하고, 0-9 숫자 포함(두글자)");
		p = Pattern.compile("[cC][a-zA-Z0-9]");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 두번째&&세번째는 대소문자 상관 없이영단어를 포함하고, 0-9 숫자 포함(세글자)");
		p = Pattern.compile("[cC][a-zA-Z0-9][a-zA-Z0-9]");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 두번째이후는 대소문자 상관 없이영단어를 포함하고, 0-9 숫자 포함(글자 길이 상관없음)");
		p = Pattern.compile("[cC][a-zA-Z0-9]*");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 숫자와 영어로 조합된 글자(두글자)");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[Cc]\\w");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하면서, 숫자와 영어로 조합된 글자(글자 길이 상관x)");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[Cc]\\w*");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하는 두자리 문자열");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[cC].");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하는 모든 문자열(길이 상관x)");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[cC].*");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c나 C로 시작하는 두자리 문자열");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[cC].");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c. 혹은 C.");
//		p = Pattern.compile("[cC]\w");
		p= Pattern.compile("[cC]\\.");
		for(j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		
		System.out.println("c와 숫자로 구성된 문자열1");
		p = Pattern.compile("c\\d");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		
		System.out.println("c와 숫자로 구성된 문자열2");
		p = Pattern.compile("c[0-9]");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			
			if(m.matches())
			{
				System.out.print(data[j]+"\t");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하는 문자열0-길이상관x");
		p = Pattern.compile("[b|c].*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
			
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하는 문자열0-길이가 2");
		p = Pattern.compile("[b|c].");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
			
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하는 문자열1");
		p=Pattern.compile("[bc].*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하는 문자열2");
		p = Pattern.compile("[b-c].*");
		for(j = 0 ; j  < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하지 않는 문자열0");
		p= Pattern.compile("[^b|c].*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하지 않는 문자열1");
		p = Pattern.compile("[^bc].*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하지 않는 문자열2");
		p = Pattern.compile("[^b-c].*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("a를 포함하는 모든 문자열");
		p= Pattern.compile(".*a.*");
		for(j = 0 ; j < data.length; j++)
		{
			Matcher m = p.matcher(data[j]);
			
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("a를 포함하는 문자열(끝에 a가 들어간 경우는 제외)");
		p = Pattern.compile(".*a.+");
		for( j = 0 ; j < data.length ; j++)
		{
			Matcher m = p.matcher(data[j]);
			
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		System.out.println("=======================================");
		System.out.println("b또는 c로 시작하는 세 자리 문자열");
		p= Pattern.compile("[b-c].{2}");
		for( j = 0 ; j < data.length; j ++)
		{
			Matcher m = p.matcher(data[j]);
			if(m.matches())
			{
				System.out.print(data[j]+" ");
			}
		}
		System.out.println();
		
	}

}
