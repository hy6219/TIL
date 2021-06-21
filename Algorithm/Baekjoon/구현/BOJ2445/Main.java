package com.boj2445;

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
		
		int N = Integer.valueOf(br.readLine());
		int i = 0;
		
		for(i = 0 ; i <=N-1; i++) {
			for(int j = 0; j<= i; j++) {
				bw.write('*');
			}
			for(int j=i+1; j<=2*N-2-i;j++) {
				bw.write(' ');
			}
			for(int j = (2*N-1)-i; j <=(2*N-1); j++) {
				bw.write('*');
			}
			bw.write('\n');
		}
		
		for(i = N; i <=2*N-1; i++) {
			for(int j =0; j<=(2*N-2)-i; j++) {
				bw.write('*');
			}
			for(int j = (2*N-1)-i; j <=i; j++) {
				bw.write(' ');
			}
			for(int j = i+1; j<=(2*N-1); j++) {
				bw.write('*');
			}
			bw.write('\n');
		}
		
		bw.close();
		br.close();
		
	}

}
