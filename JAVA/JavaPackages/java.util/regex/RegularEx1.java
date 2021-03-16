package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {
			"bat", "baby", "bonus","bc","Bc","bC","bcde","bca","abc",
			"c","cA","ca","CA","ca","CAB","Cab","Ca1","C1","CAB2","C������",
			"c.","ca.","c.a","c1","c123",
			"date","day",
			"eat"
			};
		System.out.println("c�� �����ϴ� �ҹ��� ���ܾ�(���̿� ����)");
		//����
		Pattern p = Pattern.compile("c[a-z]*");
		//c�� �����ϴ� �ҹ��� ���ܾ�(���ڱ��̴� �������)
		
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
		 * c�� �����ϴ� ���ڸ� ���ܾ� c[a-z]
		 */
		System.out.println("=======================================");
		System.out.println("c�� �����ϸ鼭 �ҹ��� �ѱ��ڷ� �̷���� ���(�α���)");
		int j = 0 ;
		//1.����
		p = Pattern.compile("c[a-z]");
		for(j = 0 ; j < data.length;j ++)
		{
			//2.MatcherŸ���� �޼��� �̿�->Matcher �ν��Ͻ� ����
			Matcher m = p.matcher(data[j]);
			//3.boolean matches()->���ԽĿ� �����ϴ��� Ȯ��
			if(m.matches())
			{
				System.out.print(data[j]+"\t");//ca	ca	
			}
		}
		System.out.println();
		System.out.println("=======================================");
		
		System.out.println("c�� �����ϸ鼭, �빮�� ���ܾ �����ϴ� ���(�α���)");
		//1.����
		p = Pattern.compile("c[A-Z]");
		for(j = 0 ; j < data.length;j ++)
		{
			//2.MatcherŸ���� �޼��� �̿�->Matcher �ν��Ͻ� ����
			Matcher m = p.matcher(data[j]);
			//3.boolean matches()->���ԽĿ� �����ϴ��� Ȯ��
			if(m.matches())
			{
				System.out.print(data[j]+"\t");//ca	ca	
			}
		}
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("c�� �����ϸ鼭, ��ҹ��� ��� ���̿��ܾ �����ϴ� ���(�α���)");
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
		System.out.println("c�� �����ϸ鼭, ��ҹ��� ��� ���̿��ܾ �����ϴ� ���(���� ��� ����)");
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
		System.out.println("c�� C�� �����ϸ鼭, ��ҹ��� ��� ���̿��ܾ �����ϴ� ���(���� ��� ����)");
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
		System.out.println("c�� C�� �����ϸ鼭, ��ҹ��� ��� ���̿��ܾ �����ϴ� ���(�α���)");
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
		System.out.println("c�� C�� �����ϸ鼭, ��ҹ��� ��� ���̿��ܾ �����ϰ�, 0-9 ���� ����(�α���)");
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
		System.out.println("c�� C�� �����ϸ鼭, �ι�°&&����°�� ��ҹ��� ��� ���̿��ܾ �����ϰ�, 0-9 ���� ����(������)");
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
		System.out.println("c�� C�� �����ϸ鼭, �ι�°���Ĵ� ��ҹ��� ��� ���̿��ܾ �����ϰ�, 0-9 ���� ����(���� ���� �������)");
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
		System.out.println("c�� C�� �����ϸ鼭, ���ڿ� ����� ���յ� ����(�α���)");
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
		System.out.println("c�� C�� �����ϸ鼭, ���ڿ� ����� ���յ� ����(���� ���� ���x)");
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
		System.out.println("c�� C�� �����ϴ� ���ڸ� ���ڿ�");
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
		System.out.println("c�� C�� �����ϴ� ��� ���ڿ�(���� ���x)");
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
		System.out.println("c�� C�� �����ϴ� ���ڸ� ���ڿ�");
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
		System.out.println("c. Ȥ�� C.");
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
		
		System.out.println("c�� ���ڷ� ������ ���ڿ�1");
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
		
		System.out.println("c�� ���ڷ� ������ ���ڿ�2");
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
		System.out.println("b�Ǵ� c�� �����ϴ� ���ڿ�0-���̻��x");
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
		System.out.println("b�Ǵ� c�� �����ϴ� ���ڿ�0-���̰� 2");
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
		System.out.println("b�Ǵ� c�� �����ϴ� ���ڿ�1");
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
		System.out.println("b�Ǵ� c�� �����ϴ� ���ڿ�2");
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
		System.out.println("b�Ǵ� c�� �������� �ʴ� ���ڿ�0");
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
		System.out.println("b�Ǵ� c�� �������� �ʴ� ���ڿ�1");
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
		System.out.println("b�Ǵ� c�� �������� �ʴ� ���ڿ�2");
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
		System.out.println("a�� �����ϴ� ��� ���ڿ�");
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
		System.out.println("a�� �����ϴ� ���ڿ�(���� a�� �� ���� ����)");
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
		System.out.println("b�Ǵ� c�� �����ϴ� �� �ڸ� ���ڿ�");
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
