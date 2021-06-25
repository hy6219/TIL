package com.boj2523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());
		int row = 2 * N -1;
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i = N; i < row; i++) {
			for(int j = 0 ; j <row-i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
