package com.greedy.boj5086;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input ="";
		String res   = "";
		//두 수가 같은 경우는 없으므로 내부 a, b 분기에서 그부분은 생각x
		while(!(input=br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			if(b%a==0) {
				res="factor";
			}else if(a%b==0) {
				res="multiple";
			}else {
				res="neither";
			}
			bw.write(res+"\n");
		}
		
		bw.close();
		br.close();
	}

}
