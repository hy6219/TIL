package com.boj10814;

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
		Object[][] arr = new Object[T][2];
		
		for(int i =0; i < T; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<Object[]>() {

			@Override
			public int compare(Object[] o1, Object[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) {
					//나이가 같으면 가입 순 정렬(정렬을 안하면 됨)
					return 0;
				}else {
					//나이가 다르면 나이순 정렬
					int i1 = (int)o1[0];
					int i2 = (int)o2[0];
					return Integer.compare(i1, i2);
				}
			}
			
		});
		
		for(int i =0; i < T; i++) {
			StringBuilder sb = new StringBuilder(arr[i][0]+" "+arr[i][1]);
			bw.write(sb+"\n");
		}
		
		bw.close();
		br.close();
		
	}

}
