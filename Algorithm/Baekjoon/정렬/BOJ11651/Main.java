package com.boj11651;

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
		int input[][] = new int[N][2];
		StringBuilder sb = new StringBuilder();
		
		//배열 입력받기
		for(int i = 0 ; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			
			input[i][0] = Integer.valueOf(st.nextToken());
			input[i][1] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				//y좌표가 같으면 x 좌표 증가 순
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}else {
					//그 외에는 y좌표 증가 순
					return o1[1]-o2[1];
				}
			}
			
		});
		
		for(int i = 0 ; i < N; i++) {
			sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
