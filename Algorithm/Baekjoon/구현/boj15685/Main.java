package com.samsungBoj.boj15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
	static int N;
	static int cnt=0;

	//방문처리를 진행해서 그 방문처리된 부분된 점을 기준으로 네 방향을 살펴보고 영역표시하기
	static boolean[][] visit;
	
	
	static void input() {
		N=scan.nextInt();
		visit=new boolean[102][102];
		for(int i=0;i<N;i++) {
			//마킹처리
			int x=scan.nextInt();
			int y=scan.nextInt();
			int d=scan.nextInt();
			int g=scan.nextInt();
			draw(x,y,getGroupDir(d,g));
		}
	}
	
	static List<Integer> getGroupDir(int d,int g) {
		//현재 방향부터 넣어야 함
		List<Integer> res=new ArrayList<>();
		res.add(d);
		
		while(g-->0) {
			//역순으로 넣어주어야 방향이 맞음
			for(int i=res.size()-1;i>=0;i--) {
				int dd=(res.get(i)+1)%4;
				res.add(dd);
			}
		}
		
		return res;
	}
	
	static void draw(int x, int y, List<Integer> direct) {
		//시작점 마킹
		visit[x][y]=true;
		
		for(int direction:direct) {
			switch(direction) {
			case 0:
				//오른쪽
				visit[++x][y]=true;
				break;
			case 1:
				//위쪽
				visit[x][--y]=true;
				break;
			case 2:
				//왼쪽
				visit[--x][y]=true;
				break;
			case 3:
				//아래쪽
				visit[x][++y]=true;
				break;
			}
		}
	}
	

	static void square() {
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {

				int curX=i; int curY=j;
				
				if(visit[curX][curY]==true &&
						  visit[curX][curY+1]==true &&
						  visit[curX+1][curY]==true &&
						  visit[curX+1][curY+1]==true) {
							cnt++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();	
		square();
		System.out.println(cnt);
	}

}
