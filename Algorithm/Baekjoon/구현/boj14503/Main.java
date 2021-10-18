package com.samsungBoj.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
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
	}
	
	
	static FastReader scan=new FastReader();
	static int N,M;
	//로봇청소기 rcd
	static int r,c,d;
	//공간
	static int[][] room;
	//방향
	//일부러 인덱스를 d와 일치시켜서 맞춰주었음
	static int[][] dir= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	//청소영역 세기
	static int cnt=0;
	
	static void input() {
		N=scan.nextInt();
		M=scan.nextInt();
		
		room=new int[N][M];
		
		r=scan.nextInt();
		c=scan.nextInt();
		d=scan.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				room[i][j]=scan.nextInt();
			}
		}
		
	}
	
	//재귀적으로 탐색할 필요가 있음
	
	static void dfs(int raw,int col,int direction) {
		//네 방향 청소 확인
		boolean flag=false;
		//방향 킵
		int t=direction;
		//1.현재 위치 청소
		if(room[raw][col]==0) {
			room[raw][col]=3;
			cnt++;
		}
		
		for(int i=0;i<4;i++) {
			//왼쪽부터 천천히 살피면서 청소
			int nd=(direction+3)%4;//먼저 왼쪽부터 탐색
			int nx=raw+dir[nd][0];
			int ny=col+dir[nd][1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				//청소가 되지 않은 경우
				if(room[nx][ny]==0) {
					dfs(nx,ny,nd);//처음에 주어진 방향값으로 청소가 되지 않았다면 i=3 즉 왼쪽부터 살펴보게 될 것
					flag=true;
					return;//종료-네 방향 중 청소가 되지 않은 부분에 대해서도 처리완료->종료
				}
			}
			direction=(direction+3)%4;
		}
		
		if(!flag) {
			//네 방향 모두 청소된 경우
			int nd=(t+2)%4;
			int nx=raw+dir[nd][0];
			int ny=col+dir[nd][1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				//청소가 안되어 있거나, 혹은 청소가 된 경우 <=>벽이 아닌 경우
				//바라본 방향 유지한 채 후진(그러면 위의 단계에서 자연스럽게 통과될것)
				if(room[nx][ny]!=1) {
					//바라본 방향 그대로 후진
					dfs(nx,ny,t);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dfs(r,c,d);

		System.out.println(cnt);
	}

}
