package com.samsungBoj.boj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	/**
	 * 1. 먹을 수 있는 물고기 갯수 파악하기
	 * - 빈칸이 여러개->0 출력 후 종료
	 * - 아기상어 크기> 물고기크기 인 경우 카운트 후, 그 수가 1개이면 그 위치로 이동하는 최소 시간 기록
	 * 
	 * 2. 물고기 갯수가 여러개인 경우, 
	 * - 네방향으로 거리를 확장시키면서 거리가 동일할때, 먹을수 있는 물고기 갯수가 여러개인지 확인하고 왼쪽물고기 먹기
	 * - 만약 위의 경우에서 벗어난다면, 가장 가까운 물고기를 먹기
	 * */
	//물고기나 상어나 좌표정보와 거리정보가 관리될 필요가 있음
	static class Fish{
		int x;
		int y;
		int dist;
		public Fish() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Fish(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
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
		public int getDist() {
			return dist;
		}
		public void setDist(int dist) {
			this.dist = dist;
		}
		
		
	}
	
	
	static FastReader r=new FastReader();
	static int N;
	static int[][] board;
	static ArrayList<Fish> fishes=new ArrayList<>();

	static int[][] dir= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	
	static int[][] rec;
	//아기상어크기
	static int shark=2;
	//아기상어 위치
	static int sx,sy;
	//시간 기록
	static int time;
	//먹은 물고기 갯수 누적
	static int sum=0;
	
	static void input() {
		N=r.nextInt();

		rec=new int[N+1][N+1];
		board=new int[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int numeric=r.nextInt();
				board[i][j]=numeric;
				if(numeric==9) {
					sx=i; sy=j;
					board[i][j]=0;//빈칸으로 두기
				}
			}
		}
	}
	
	static boolean rangeCheck(int r,int c) {
		return (r<0||c<0||r>=N||c>=N);
	}
	
	
	static void dynamicBfs() {
		//상어가 움직이면서 살펴볼 상황들이 여럿 있음
		while(true) {
			fishes=new ArrayList<>();
			boolean[][] visit=new boolean[N+1][N+1];
			Queue<Fish> que=new LinkedList<>();
			
			que.add(new Fish(sx,sy,0));
			visit[sx][sy]=true;
			
			while(!que.isEmpty()) {
				Fish fish=que.poll();
				
				for(int i=0;i<4;i++) {
					//네방향으로 탐색
					int nx=fish.x+dir[i][0];
					int ny=fish.y+dir[i][1];
					
					boolean flag=rangeCheck(nx,ny);
					
					if(flag) continue;
					if(visit[nx][ny]) continue;
					
					//먹이를 찾은 경우
					//아기상어크기가 더 크고, 보드에 기록된 값이 0이 아닌 경우
					if(board[nx][ny]>0 && shark>board[nx][ny]) {
						que.add(new Fish(nx,ny,fish.dist+1));
						visit[nx][ny]=true;
						fishes.add(new Fish(nx,ny,fish.dist+1));
					}
					
					//먹을수는 없지만, 지나갈 수 있는 경우(0이거나 아기상어크기가 동일한 경우)
					if(board[nx][ny]==0 || board[nx][ny]==shark) {
						//먹을수는 없기 때문에 먹은 기록인 fishes에는 추가하지 않음
						que.add(new Fish(nx,ny,fish.dist+1));
						visit[nx][ny]=true;
					}
					
				}
			}
			//기록된 먹은 기록이 0개인 경우는 아무것도 먹을 수 없다는 것이므로 시간 출력 후 종료
			if(fishes.size()==0) {
				System.out.println(time);
				return;
			}
			//먹을 물고기가 존재하는 경우
			Fish target=fishes.get(0);
			for(int i=1;i<fishes.size();i++) {
				//거리가 최소인 물고기먹기위해 대상 교체
				if(fishes.get(i).dist<target.dist) {
					target=fishes.get(i);
				}
				//거리가 같은 경우 왼쪽이 최우선
				if(fishes.get(i).dist==target.dist) {
					if(fishes.get(i).x<target.x) {
						target=fishes.get(i);
					}else if(fishes.get(i).x==target.x) {
						//x축값이 같다면 위쪽을 보기
						if(fishes.get(i).y<target.y) {
							target=fishes.get(i);
						}
					}
				}
			}
			
			//거리이동할때마다 시간 1씩증가
			time+=target.dist;
			//먹은 물고기 갯수 증가
			sum++;
			board[target.x][target.y]=0;//빈칸으로 돌리기
			
			//먹은 갯수==상어크기->상어 크기 증가
			if(sum==shark) {
				shark++;
				//먹은 갯수 초기화
				sum=0;
			}
			//상어 위치 갱신
			sx=target.x;
			sy=target.y;
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		dynamicBfs();
	}

}
