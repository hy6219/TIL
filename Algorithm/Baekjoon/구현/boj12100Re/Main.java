package com.samsungBoj.boj12100Re;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//bfs
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
	//바둑판 배열
	static int[][] board1=new int[21][21];
	//실제 기울임에 따라 실질적으로 움직이게 될 배열
	static int[][] board2=new int[21][21];
	
	
	static void input() {
		N=r.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board1[i][j]=r.nextInt();

			}
		}
	}
	
	//보드를 회전시키기
	static void rotate() {
		//복사해두기
		int[][] temp=new int[21][21];
		
		for(int i=0;i<N;i++) {
			//실제 움직여지는 배열을 복사해두기
			for(int j=0;j<N;j++) {
				temp[i][j]=board2[i][j];
			}
		}
		
		//회전(temp에 담아둔 것을 board2에 회전과 동시에 적용해주기)
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board2[i][j]=temp[N-1-j][i];//B[x][y]=A[N-1-y][x]
			}
		}
	}
	
	
	//게임판을 상하좌우로 기울이기
	static void tilt(int dir) {
		while(dir-->=0) rotate();//다음 방향으로 시계방향으로 90도 회전시키기
		for(int i=0;i<N;i++) {
			//기울였을때 왼쪽/오른족/아래/위 방향으로 쏠리는데, 한 행을 기준으로 쏠리도록 하기
			int[] tilted=new int[21];
			//다음에 놓을 수 있는지 확인하기 위한 인덱스
			int idx=0;
			for(int j=0;j<N;j++) {
				//비어있다면  볼 필요없음
				if(board2[i][j]==0) continue;
				//기울임배열의 값이 0이라면, 기울였을때 둘 곳이 있다는 것
				//값 옮기기
				if(tilted[idx]==0) {
					tilted[idx]=board2[i][j];
				}else if(tilted[idx]==board2[i][j]) {
					//비어있지 않은데,지금 기울여진 배열위치값이 같은 행의 보드의 열값과 같으면
					//2배 처리를 해준 '후', 다음칸으로 이동
					tilted[idx++]*=2;
				}else {
					//기울임배열이 비어있지도 않고, 값이 같지도 않다면,
					//그저 그 행 내에서 열 자리를 이동시키고,
					//그 곳에 그 값을 넣기
					tilted[++idx]=board2[i][j];
				}
				
			}
			//기울임배열의 결과를 다음에도 적용시키기 위해서 board2에 저장해두기
			for(int j=0;j<N;j++) {
				board2[i][j]=tilted[j];
			}
		}
	}

	static void pro() {
		//최댓값 찾기
		int max=Integer.MIN_VALUE;
		//블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴
		for(int i=0;i<1024;i++) {
			//방향은 4가지이고, 그 네 개 중 하나를 수행한 후에는
			//다음 '회차'를 "탐색"해야 하므로 "탐색"이라는 의미에 맞게 brute 변수 사용
			//dir=brute%4, 그 이후에는 brute/=4
			//그 후에는 보드를 회전시키고, 기울여서 합치기
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					board2[j][k]=board1[j][k];//복사
				}
			}
			int brute=i;
			
			for(int j=0;j<5;j++) {
				int dir=brute%4;
				brute/=4;
				tilt(dir);
				//System.out.println("board2: "+Arrays.deepToString(board2));
			}
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					max=Math.max(max, board2[j][k]);
				}
			}
		}
		
		
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
