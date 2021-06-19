package com.boj1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main{
	public static void swap(Object[] o, int idx1, int idx2) {
		Object temp = o[idx1];
		o[idx1]     = o[idx2];
		o[idx2]		= temp;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.valueOf(br.readLine());
		String[] arr = null;
		Set<String> space = new HashSet<>();
		for(int i = 0; i < N; i++) {
			//중복 제거
			String tmp = br.readLine();
			space.add(tmp);
		}
		
		//배열크기
		int size = space.size();
		//배열에 옮기기
		arr = new String[size];
		
		Iterator<String> iter = space.iterator();
		int k = 0;
		while(iter.hasNext()) {
			arr[k++] = iter.next();
		}
		
		//길이 순 정렬
		for(int i = 0; i < size-1; i++) {
			for(int j = i+1; j< size; j++) {
				if(arr[i].length() > arr[j].length()) {
					swap(arr,i,j);
				}else if(arr[i].length()==arr[j].length() && arr[i].compareTo(arr[j])>0) {
					//길이가 같은데 사전순 정렬이 안된 경우
					swap(arr,i,j);
				}
			}
		}
		
		for(int i = 0; i < size; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.close();
		br.close();
	}

	

	

}
