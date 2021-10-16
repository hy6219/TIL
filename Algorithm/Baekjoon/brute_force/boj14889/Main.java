package com.samsungBoj.boj14889;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		
		public FastReader(String s) throws FileNotFoundException{
			br=new BufferedReader(new FileReader(new File(s)));
		}
		
		String nextLine() {
			String str="";
			
			try {
				str=br.readLine();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			return str;
		}
		
		String next() {
			while(st==null || !st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.valueOf(next());
		}
		
		long nextLong() {
			return Long.valueOf(next());
		}
		
		double nextDouble() {
			return Double.valueOf(next());
		}
		
	}
	
	
	static FastReader r=new FastReader();
	static int N;
	static int[][] skill;

	//차이 최솟값
	static int min=Integer.MAX_VALUE;
	//중복체크를 위한 플래그배열
	static boolean[] visit;
	
	static void input() {
		N=r.nextInt();
		skill=new int[N][N];
		visit=new boolean[N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				skill[i][j]=r.nextInt();
			}
		}
		

	}
	
	static void calc() {
		//true->스타트팀
		//false->링크팀
		//각 팀의 능력치 계산
		int st=0;
		int link=0;
		
	//	System.out.println("visit: "+Arrays.toString(visit));
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				//스타트팀
				if(visit[i] && visit[j]) {
					//i와 j가 모두 스타트팀인 경우
					st+=skill[i][j];
					st+=skill[j][i];
				}
				//링크팀
				else if(!visit[i] && !visit[j]) {
					//i와 j가 모두 링크팀인 경우
					link+=skill[i][j];
					link+=skill[j][i];
				}
			}
		}
		
		//두 팀 점수차이가 0이면 그것이 최솟값이므로 종료
		int limit=Math.abs(st-link);
		
		if(limit==0) {
			System.out.println(limit);
			System.exit(0);
		}
		
		min=Math.min(min, limit);
//		System.out.println("스타트팀 점수: "+st+", 링크팀 점수: "+link);
	}
	
	
	static void rec_func(int idx,int k) {
		if(k==N/2) {
			//링크팀과 스타트팀으로 나누기+
			//각 팀 점수 계산
			calc();
			return;
		}else {
			//탐색
			for(int cand=idx+1;cand<N;cand++) {
				//k번째 스타트팀 팀원으로 cand를 기록
				if(!visit[cand]) {
					visit[cand]=true;
					//완전탐색
					rec_func(cand,k+1);
					//초기화
					visit[cand]=false;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		rec_func(0,0);
		System.out.println(min);
	}

}
