package com.boj10757;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger sum = new BigInteger("0");
		
		while(st.hasMoreTokens()) {
			BigInteger tmp = new BigInteger(st.nextToken());
			sum=sum.add(tmp);
		}
		bw.write(sum.toString(10));
		bw.close();
		//System.out.println(sum);
		br.close();
		
	}

}
