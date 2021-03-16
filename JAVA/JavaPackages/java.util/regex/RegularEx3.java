package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {
				"bat", "baby", "bonus","bc","Bc","bC","bcde","bca","abc",
				"c","cA","ca","CA","ca","CAB","Cab","Ca1","C1","CAB2","C������",
				"c.","ca.","c.a","c1","c123","c00","ca��", "c123", "c123a",
				"cab","ca1","ca12",
				"date","day",
				"eat"
				};
		
		//0.������ String�迭�� ���� �����ϱ�(���ڿ� �迭�� ����: �� ��츦 
		//���ڿ��̶�� charAt���� �����ϴµ��� �Ѱ谡 �ֱ� ����, ���̼��� ����)
		String[] pattern = {
				
				".*", "c[a-z]*","c[a-zA-Z]*","c[a-zA-Z0-9]*",
				"c[a-zA-Z0-9][a-zA-Z0-9]","c\\w","c\\d",
				"c\\d*","c\\d{3}","c\\w{2}.*","c\\w{1}\\d{1}.*"
				};
		
		//1.���ϰ�ü
		for(int x = 0 ; x < pattern.length; x++)
		{
			//�� ���Ͽ� ���ؼ� Ȯ���غ� ��
			for(int y = 0; y < data.length; y++)
			{
				Pattern p = Pattern.compile(pattern[x]);//regex parameter
				
				//2&3.matcher ��ü ����� Ȯ��
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
