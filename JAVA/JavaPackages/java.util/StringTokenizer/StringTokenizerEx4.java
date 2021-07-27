package com.util.string_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "��ʸ���õ��ʿ�";
		System.out.println(input);
		System.out.println(hangulToNum(input));
	}
	
	public static long hangulToNum(String input)
	{
		long res = 0;
		long tmp = 0;
		long num = 0;
		
		final String NUMBER ="�����̻�����ĥ�ȱ�";
		final String UNIT   ="�ʹ�õ������";
		final long[] UNIT_NUM = {10, 100, 1000,
				10000,(long)1e8, (long)1e12};
		
		StringTokenizer st = 
				new StringTokenizer(input, UNIT, true);
		
		while(st.hasMoreTokens())
		{
			String token= st.nextToken();
			int check=
					NUMBER.indexOf(token);//�������� �������� üũ
			if(check == -1)
			{
				//�����ΰ��
				if("������".indexOf(token)==-1)
				{
					tmp +=(num!=0? num : 1) * UNIT_NUM[UNIT.indexOf(token)];
				}
				else
				{
					tmp += num;
					res +=(tmp!=0 ? tmp: 1)* UNIT_NUM[UNIT.indexOf(token)];
					tmp = 0;
				}
				num =0;
			}
			else
			{
				//����
				num = check;
			}
		}
		return res + tmp + num;
	}
}
