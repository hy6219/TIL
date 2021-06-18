package com.boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		int  cnt = 0;
		int  tot = 0;
		int  res = 0;//남는것
		
		
		for(int i = 0; i < cro.length; i++) {
			
			String target = cro[i];
			//길이가 3인 경우부터 거르기
			for(int j = 0 ; j < input.length()-2; ) {
				StringBuilder sb = new StringBuilder();
				char f = input.charAt(j);
				char s = input.charAt(j+1);
				char t = input.charAt(j+2);
				
				String comp = sb.append(f).append(s).append(t).toString();
				
				if(comp.equals(target)) {
					cnt++;
//					String temp1 = input.substring(0,j);
//					String temp2 = input.substring(j+3);
//					input = temp1.concat(temp2);
//					System.out.println(input);
				//	System.out.println("j: "+j+", comp: "+comp+", target: "+target);
					j = j+3;
				}else {
					j++;
				}
				
			}
			
		}
		res = input.length()-(3*cnt);
	//	System.out.println("===");
		for(int i = 0 ; i < cro.length; i++) {
			String target = cro[i];
			//길이 2인 경우만 남음
			for(int j = 0 ; j < input.length()-1;) {
				StringBuilder sb = new StringBuilder();
				char f = input.charAt(j);
				char s = input.charAt(j+1);
				
				String comp = sb.append(f).append(s).toString();
				
				if(comp.equals(target)) {
					cnt++;
					
//					String temp1 = input.substring(0,j);
//					String temp2 = input.substring(j+2);
//					input = temp1.concat(temp2);
			//		System.out.println("j: "+j+", comp: "+comp+", target: "+target);
					j=j+2;
				}else {
					j++;
				}
				
			}
			
		}
		
		res = input.length()-(2*cnt);
	//	res = input.length();
		tot = cnt + res;
	//	System.out.println("now: input-"+input);
		System.out.println(tot);
		br.close();
		
	}

}
