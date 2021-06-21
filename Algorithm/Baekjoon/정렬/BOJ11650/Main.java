package com.boj11650;

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
		
		int T = Integer.valueOf(br.readLine());
		int[][] plot = new int[T][2];
		
		//좌표 입력받기
		for(int i = 0; i < T; i++) {
			String line = br.readLine();
			
			StringTokenizer st = new StringTokenizer(line);
			
			plot[i][0] = Integer.valueOf(st.nextToken());
			plot[i][1] = Integer.valueOf(st.nextToken());
			
		}
		
		Arrays.sort(plot,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) {
					//x좌표가 같은 경우
					return o1[1]-o2[1];
				}else {
					//x좌표가 다른 경우
					return o1[0]-o2[0];
				}
			}
			
		});

		for(int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(plot[i][0]).append(" ").append(plot[i][1]).append("\n");
			bw.write(sb.toString());
		}
		bw.close();
		br.close();
	}

}
