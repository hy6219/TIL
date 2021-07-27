package com.util.string_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "삼십만삼천백십오";
		System.out.println(input);
		System.out.println(hangulToNum(input));
	}
	
	public static long hangulToNum(String input)
	{
		long res = 0;
		long tmp = 0;
		long num = 0;
		
		final String NUMBER ="영일이삼사오육칠팔구";
		final String UNIT   ="십백천만억조";
		final long[] UNIT_NUM = {10, 100, 1000,
				10000,(long)1e8, (long)1e12};
		
		StringTokenizer st = 
				new StringTokenizer(input, UNIT, true);
		
		while(st.hasMoreTokens())
		{
			String token= st.nextToken();
			int check=
					NUMBER.indexOf(token);//숫자인지 단위인지 체크
			if(check == -1)
			{
				//단위인경우
				if("만억조".indexOf(token)==-1)
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
				//숫자
				num = check;
			}
		}
		return res + tmp + num;
	}
}
