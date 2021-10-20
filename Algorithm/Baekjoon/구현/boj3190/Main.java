package com.samsungBoj.boj3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
	
	
	static FastReader r=new FastReader();
	static int N,K,L;

	static int[][] dir= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
//	static int[][] dir= {
//			{0,-1},
//			{1,0},
//			{0,1},
//			{-1,0}
//	};
	//시간,방향 배열
	static char[] rec=new char[10001];
	static int[] serial=new int[10001];
	//보드
	static int[][] board;
	static int time=0;
	//뱀 기록
	static Deque<int[]> snake=new ArrayDeque<>();
	
	static void input() {
		N=r.nextInt();
		K=r.nextInt();//사과갯수
		
		board=new int[N+1][N+1];
			
		
		for(int i=0;i<K;i++) {
			int x=r.nextInt();
			int y=r.nextInt();
			
			board[x][y]=2;//사과가 있다는 것
		}
		L=r.nextInt();//이동정보
		//시간은 최대 10000
	
		for(int i=0;i<L;i++) {
			int time=r.nextInt();
			char dd=r.next().charAt(0);
			rec[i]=dd;
			serial[i]=time;
		
		}
	}
	
	static void simul(int x, int y,int d) {
		
		int turn=0;
		for(int i=0;i<10001;i++) {
	//		System.out.println("turn: "+turn+", serial: "+serial[turn]+",time: "+time);
			if(turn<L && serial[turn]==time) {				
				d=nextDir(d,rec[turn]);
				turn++;
			}
			
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			
			//머리를 다음칸에 위치
			snake.addFirst(new int[] {nx,ny});
			
			if(nx<=0 || ny<=0 || nx>N || ny>N) {
				++time;
				break;
			}
			
			if(board[nx][ny]==2) {
				//사과가 있는 경우
				board[nx][ny]=1;
			}else if(board[nx][ny]==0) {
				//사과가 없는 경우
				board[nx][ny]=1;
				//꼬리가 있는 칸 비워주기
				int[] tail=snake.pollLast();
				board[tail[0]][tail[1]]=0;
			}else {
				//자기자신과 부딪힌 경우
				++time;
				break;
			}

			x=nx; y=ny;
			++time;
			
		}
		
	}
	
	static int nextDir(int cur,char cmd) {
		int next=0;
		
		if(cmd=='L') {
			next=(cur+3)%4;
		}else {
			next=(cur+1)%4;
		}
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		board[1][1]=2;//뱀
		snake.addFirst(new int[] {1,1});
		simul(1,1,1);
		System.out.println(time);
	}

}
	