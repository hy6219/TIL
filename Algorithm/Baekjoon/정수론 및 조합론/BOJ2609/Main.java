package com.boj2609;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		
		int min = (a < b)?a:b;
		int max = (a > b)?a:b;
		
		int gcd = gcd(min,max);
		int lcd = gcd * (min/gcd)*(max/gcd);
		
		bw.write(gcd+"\n");
		bw.write(lcd+"\n");
		
		bw.close();
		br.close();
		
	}

}
