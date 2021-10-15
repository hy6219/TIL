package com.samsungBoj.boj15683;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReMain {
	
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
	static int N,M;
	//cctv 좌표
	static Stack<int[]> cctv=new Stack<>();
	//최초에 입력받은 board 저장
	static int[][] board1;
	//사각지대 갯수 세기
	static int[][] board2;
	//사각지대 최소 크기
	static int min=0;
	
	static int[][] dir= {
			{1,0},//우
			{0,1},//하
			{-1,0},//좌
			{0,-1}//상
	};
	
	static void input() {
		N=r.nextInt(); M=r.nextInt();
		
		board1=new int[10][10];
		board2=new int[10][10];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				board1[i][j]=r.nextInt();
				
				if(board1[i][j]!=0 && board1[i][j]!=6) cctv.push(new int[] {i,j});
				//처음 빈칸갯수로 사각지대 초기화
				if(board1[i][j]==0) min++;
			}
		}
	}
	
	//4진법->방향 지정
	static void direction() {
		for(int i=0;i<(1<<(2*cctv.size()));i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					//배열 복사
					board2[j][k]=board1[j][k];
				}
			}
			
			//방향 정하기
			int brute=i;
			
			for(int j=0;j<cctv.size();j++) {
				int d=brute%4;
				brute/=4;
				int[] o=cctv.get(j);
				int x=o[0];
				int y=o[1];
				
				//원래 있었던 cctv가 무엇인지는 원본에서만 알 수 있음
				if(board1[x][y]==1) {
					wall(x,y,d);
				}else if(board1[x][y]==2) {
					//cctv 2
					//일부러 각도에 맞춰서 요소를 배치해두었음
					wall(x,y,d);
					wall(x,y,d+2);
				}else if(board1[x][y]==3) {
					//cctv3
					wall(x,y,d);
					wall(x,y,d+1);
				}else if(board1[x][y]==4) {
					//cctv4
					wall(x,y,d);
					wall(x,y,d+1);
					wall(x,y,d+2);
				}else {
					//cctv5
					wall(x,y,d);
					wall(x,y,d+1);
					wall(x,y,d+2);
					wall(x,y,d+3);
				}
			}
	//		System.out.println("board2: "+Arrays.deepToString(board2));
			
			//최솟값 찾기
			int v=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(board2[j][k]==0) {
						v++;
					}
				}
			}
			min=Math.min(min, v);
		}
	}

	
	//특정방향으로 지정했을때 벽을 만나기 전까지 7로 값을 채우기
	static void wall(int x, int y ,int d) {
		d%=4;
		while(true) {
			x+=dir[d][0];
			y+=dir[d][1];
			if(x<0||y<0||x>=N || y>=M) return;
			if(board2[x][y]==6) return;
			if(board2[x][y]!=0) continue;//벽이 있는 상황을 배재한 상황에서 cctv가 존재한다면 넘어감
			board2[x][y]=7;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		direction();
		System.out.println(min);
	}

}
