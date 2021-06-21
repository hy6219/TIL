package com.boj2693;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[10];
		
		for(int i = 0 ; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int j = 0;
			//배열 값 넣기
			while(st.hasMoreTokens()) {
				arr[j++] = Integer.valueOf(st.nextToken());
			}
			
			j = 0;
			for(j = 0; j < 9; j++) {
				for(int k = j+1; k < 10; k++) {
					int temp = 0;
					
					if(arr[j] < arr[k]) {
						temp = arr[j];
						arr[j] = arr[k];
						arr[k] = temp;
					}
				}
			}
			
			bw.write(arr[2]+"\n");
		}
		
		bw.close();
		br.close();
		
	}

}
