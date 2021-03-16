package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {
				"bat", "baby", "bonus","bc","Bc","bC","bcde","bca","abc",
				"c","cA","ca","CA","ca","CAB","Cab","Ca1","C1","CAB2","C가나다",
				"c.","ca.","c.a","c1","c123","c00","ca가", "c123", "c123a",
				"cab","ca1","ca12",
				"date","day",
				"eat"
				};
		
		//0.패턴을 String배열로 만들어서 정리하기(문자열 배열인 이유: 각 경우를 
		//문자열이라면 charAt으로 접근하는데에 한계가 있기 때문, 용이성을 위함)
		String[] pattern = {
				
				".*", "c[a-z]*","c[a-zA-Z]*","c[a-zA-Z0-9]*",
				"c[a-zA-Z0-9][a-zA-Z0-9]","c\\w","c\\d",
				"c\\d*","c\\d{3}","c\\w{2}.*","c\\w{1}\\d{1}.*"
				};
		
		//1.패턴객체
		for(int x = 0 ; x < pattern.length; x++)
		{
			//각 패턴에 대해서 확인해볼 것
			for(int y = 0; y < data.length; y++)
			{
				Pattern p = Pattern.compile(pattern[x]);//regex parameter
				
				//2&3.matcher 객체 만들어 확인
				Matcher m = p.matcher(data[y]);
				if(m.matches())
				{
					System.out.println(data[y]+" ");
				}
			}
			System.out.println("=================================================");
			System.out.println();
		}
	}

}
