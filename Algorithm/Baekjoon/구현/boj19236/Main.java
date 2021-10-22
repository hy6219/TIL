package com.samsungBoj.boj19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	//물고기 객체
	static class Fish{
		int x;
		int y;
		int num;
		int dir;
		//살아 있는지
		boolean isAlive=true;
		public Fish(int x, int y, int num, int dir, boolean isAlive) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.isAlive = isAlive;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getDir() {
			return dir;
		}
		public void setDir(int dir) {
			this.dir = dir;
		}
		public boolean isAlive() {
			return isAlive;
		}
		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}
		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", num=" + num + ", dir=" + dir + ", isAlive=" + isAlive + "]";
		}
		
	}

	static FastReader scan=new FastReader();
	//먹은 물고기 기록
	static Fish[] fishes=new Fish[17];
	//물고기 위치 보드
	static int [][] board=new int[4][4];
	static int[][] dir= {
			{-1,0},
			{-1,-1},
			{0,-1},
			{1,-1},
			{1,0},
			{1,1},
			{0,1},
			{-1,1}
	};
	//상어위치,방향
	static int sx=0,sy=0,sd=0;
	static int ans=Integer.MIN_VALUE;
	
	static void input() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int num=scan.nextInt();
				int dir=scan.nextInt()-1;
				
				board[i][j]=num;//물고기 번호만 저장
				fishes[num]=new Fish(i,j,num,dir,true);
			}
		}
		
	}
	
	static void pro() {
		/**
		 * 1. 상어가 (0,0)부터 시작해서 그 칸의 물고기를 먹고 시작
		 * 2. 물고기 이동
		 * 3. 상어 이동시, 방향 내에서 이동할 수 있는 칸으로 이동(이동 불가한 경우, 반시계방향 45도 회전)
		 * */
		//1.(0,0)칸의 물고기를 상어가 먹고, 상어가 그 방향까지 차지
		//물고기 번호저장
		int eat=board[0][0];
		fishes[eat].isAlive=false;
		sd=fishes[eat].dir;
		board[0][0]=-1;//상어가 차지한다~
		//dfs로 이동
		dfs(sx,sy,sd,eat);
		System.out.println(ans);
	}
	
	static void dfs(int sx,int sy,int sd,int eat) {
		//번호 갱신
		ans=Math.max(ans, eat);
		//2.물고기가 이동한다~
		//모든 경우의 수를 계산하기 위해서 초기화해주어야 함
		Fish[] tempFishes=new Fish[17];
		int[][] tempBoard=new int[4][4];
	
		for(int i=1;i<=16;i++) {
			tempFishes[i]=new Fish(fishes[i].x,fishes[i].y,fishes[i].num,fishes[i].dir,fishes[i].isAlive);
		}
		
		for(int i=0;i<4;i++) {
			System.arraycopy(board[i], 0, tempBoard[i], 0, board.length);
		}
		//물고기 이동
		moveFish();
		
		//상어이동
		//4 by 4 배열임을 이용
		for(int i=1;i<4;i++) {
			int nx=sx+dir[sd][0]*i;
			int ny=sy+dir[sd][1]*i;
		
			if(nx >=0 && ny >=0 && nx<4 && ny<4 && board[nx][ny]!=0) {
				//영역을 벗어나지 않고, 빈칸이 아닌 (지금 벌써 물고기 이동경우를 진행했으므로 물고기가 없는 빈칸임) 경우
				int target=board[nx][ny];//대상번호

				int nd=fishes[target].dir;
				//상어가 이동하므로 빈칸으로 만들어주기
				board[sx][sy]=0;
				//상어가 이동하면서 그 위치를 마킹해주기
				board[nx][ny]=-1;
				//물고기 먹기
				fishes[target].isAlive=false;

				
				dfs(nx,ny,nd,eat+target);//번호는 누적~
				
				//원상복귀
				board[sx][sy]=-1;
				board[nx][ny]=target;
				fishes[target].isAlive=true;
			}
		}
		//배열 복귀
		for(int i=1;i<17;i++) {
			fishes[i]=new Fish(tempFishes[i].x,tempFishes[i].y,tempFishes[i].num,tempFishes[i].dir,tempFishes[i].isAlive);
		}
		
		for(int i=0;i<4;i++) {
			System.arraycopy(tempBoard[i], 0, board[i], 0, board.length);
		}
		
	}
	
	static void moveFish() {
		for(int i=1;i<17;i++) {
			//물고기가 없는. 즉 죽었다면 갈 수 없음
			if(!fishes[i].isAlive) continue;
			
			int d=fishes[i].dir;
			int num=fishes[i].num;
			
			for(int j=0;j<8;j++) {
				d=d%8;
				fishes[i].dir=d;
				int nx=fishes[i].x+dir[d][0];
				int ny=fishes[i].y+dir[d][1];
				//틀을 벗어나거나, 상어가 있다면 이동불가
				if(nx>=0 && ny>=0 && nx<4 && ny<4 && (board[nx][ny]!=-1)) {
					//빈칸인 경우
					if(board[nx][ny]==0) {
						//이동
						//기존위치를 빈칸으로 만들기
						board[fishes[i].x][fishes[i].y]=0;
						fishes[i].x=nx;
						fishes[i].y=ny;
						//물고기 넣어주기
						board[nx][ny]=i;
					}else {
						//이동할 위치에 다른 물고기가 있는 경우
						//그 예상위치의 물고기 위치를 지금 물고기 위치로 변경
						int trans=fishes[board[nx][ny]].num;
						fishes[trans].x=fishes[i].x;
						fishes[trans].y=fishes[i].y;
						board[fishes[trans].x][fishes[trans].y]=trans;
						
						fishes[i].x=nx;
						fishes[i].y=ny;
						//물고기 넣어주기
						board[nx][ny]=i;
					}
					break;
				}else {
					d++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		input();
		pro();
		// TODO Auto-generated method stub
		
	}

}
