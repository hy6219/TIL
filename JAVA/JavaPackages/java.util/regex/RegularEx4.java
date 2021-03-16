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
		
		Pattern p = Pattern.compile(pattern);//�ٸ� *, [ ,..���� ������� �ʰ�
		//���ڿ��ε� ���� (<-broken�� �� ù ������ ã�´ٰ� ����)
		
		Matcher m = p.matcher(source);//source���� ��ġ�ϴ� ���� �ִ��� ã��
		
		System.out.println("source: "+source);
		
		int i = 0 ;
		//find�� ���ϰ� ��ġ�ϴ� �κ�ã��
		while(m.find())
		{
			System.out.println(
					(++i)+" ��° ��Ī : "+m.start()+"~"+m.end()
					);
			
			//broken�� beautiful���� ġȯ�ϰ�
			//ã��������, ������ġ�������� ���� + ġȯ�� ���ڸ� sb�� ����
			m.appendReplacement(sb, "beautiful");
		}
		//�߰���ġ���� �����Ͽ� ������ ���ڿ� ���ۿ� ���� �߰�
		m.appendTail(sb);
		//���������� ġȯ�� ������ �κ��� sb�� �����̱�
		System.out.println("Replacement count: "+i);
		System.out.println("result: "+sb.toString());
		
	}

}
