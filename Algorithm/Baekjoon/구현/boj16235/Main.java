package com.samsungBoj.boj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
	

	static class Tree{
		int r;
		int c;
		//원래 나이
		int origin;
		public Tree() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Tree(int r, int c, int origin) {
			super();
			this.r = r;
			this.c = c;
			this.origin = origin;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getOrigin() {
			return origin;
		}
		public void setOrigin(int origin) {
			this.origin = origin;
		}
		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", origin=" + origin + "]";
		}
		
		
	}
	
	static FastReader r=new FastReader();
	static int N,M,K;
	static int[][] A;//양분정보
	static int[][] cp;//양분정보
	static LinkedList<Tree> tree=new LinkedList<>();//나무정보(좌표,[나이])
	//언제 죽었는지도 기록
	static Queue<Tree> death=new LinkedList<>();
	
	//인접행렬
	static int[][] dir= {
			{-1,-1},{-1,0},{-1,1},
			{0,-1},{0,1},{1,-1},
			{1,0},{1,1}
	};
	static boolean[][] visit;
	//살아남은 나무수 구하기
	static int cnt=0;
	
	static void input() {
		N=r.nextInt();
		M=r.nextInt();
		K=r.nextInt();
		
		A=new int[N+1][N+1];
		cp=new int[N+1][N+1];
		visit=new boolean[N+1][N+1];
		//양분정보
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				A[i][j]=5;//처음에는 모두 5씩 들어있었음
				cp[i][j]=r.nextInt();
			}
		}

		
		for(int i=0;i<M;i++) {
			Tree t=new Tree(r.nextInt(),r.nextInt(),r.nextInt());
			tree.add(t);
		}
	}
	
	static void simulate() {
		int year=0;
		while(true) {
			if(year==K) return;
			
			//봄
			Iterator<Tree> iterator=tree.iterator();
			
			while(iterator.hasNext()) {
				Tree t=iterator.next();
				int r=t.getR();
				int c=t.getC();
				int age=t.getOrigin();
				

				if(A[r][c]<age) {
					//양분을 먹지 못하고 죽음
					death.add(t);
					iterator.remove();
				}else {
					//양분을 먹을 수 있음!!
					A[r][c]-=age;
					//나이는 증가~
					t.origin++;
				}
			}
			
			//여름
			while(!death.isEmpty()) {
				Tree t=death.poll();
				A[t.r][t.c]+=t.getOrigin()/2;//양분이 증가됨
			}
			
			//가을(번식)
			Queue<Tree> bunsik=new LinkedList<>();//>3<재밌당
			
			for(Tree t:tree) {
				int r=t.getR();
				int c=t.getC();
				
				//5배수 나이가 아니면 볼 필요도 없음
				if(t.getOrigin()%5!=0) continue;
				//5배수 나이인 경우~
				for(int d=0;d<8;d++) {
					int nr=r+dir[d][0];
					int nc=c+dir[d][1];
					
					//틀을 벗어난 경우(r,c>=1)
					if(nr<1 || nc<1 || nr>=N+1 || nc>=N+1) continue;
					bunsik.add(new Tree(nr,nc,1));
					
				}
			}
			
			//본체에 합체~
			tree.addAll(0,bunsik);
			
			//겨울
			//각칸에 양분더주기~
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N;c++) {
					A[r][c]+=cp[r][c];
				}
			}
			
			year++;//연도 증가
		}
	}
	
	
	static void pro() {
		simulate();
		System.out.println(tree.size());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
