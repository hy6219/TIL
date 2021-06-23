package com.boj2108Re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	//평균
	public static int  mean(int[] arr) {
		int sum = 0;
		for(int i:arr) {
			sum +=i;
		}
		
		return (int)(Math.round((double)sum/arr.length));
	}
	//중앙값
	public static int mid(int[] arr) {
		return arr[arr.length/2];
	}
	
	//최빈값
	public static int freq(int[] arr) {
		int mode =0;
		//빈도수를 입력할 배열
		int[] freq = new int[8001];
		//최대 빈도
		int maxFreq = 0;
		//최대 빈도값을 갖는 인덱스
		int maxIdx = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			freq[arr[i]+4000]++;
		}
		
		//최대 빈도 구하기
		for(int i = 0 ; i < 8001; i++) {
			if(freq[i] > maxFreq) {
				maxFreq = freq[i];
			}
		}
		
		//두번 등장 구별
		boolean flag = false;
		
		for(int i = 0 ; i < 8001; i++) {
			//최빈값이면 플래그를 세우는데 두번 등장했다면 최빈값 인덱스는 4000을 뺀 값이 되어야 함
			if(freq[i]==maxFreq) {
				if(flag) {
					maxIdx = i - 4000;
					break;
				}
				maxIdx = i-4000;
				flag = true;
			}
		}
		
		mode = maxIdx;
		
		return mode;
	}
	
	//범위
	public static int range(int[] arr) {
		return arr[arr.length-1]-arr[0];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.valueOf(br.readLine());
		int[] arr = new int[T];
		int avg = 0;
		int mid = 0;
		int freq = 0;
		int range = 0;
		
		for(int i = 0 ;i < T; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(arr);
	//	System.out.println(Arrays.toString(arr));
		avg = mean(arr);
		mid = mid(arr);
		if(arr.length==1) {
			freq = arr[0];
		}else {
			freq = freq(arr);
		}
		range = range(arr);
		
		StringBuilder r = new StringBuilder(avg+"\n"+mid+"\n"+freq+"\n"+range+"\n");
		bw.write(r.toString());
		bw.close();
		br.close();
	}

}
