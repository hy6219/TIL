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
	
	//����� ��ü
	static class Fish{
		int x;
		int y;
		int num;
		int dir;
		//��� �ִ���
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
	//���� ����� ���
	static Fish[] fishes=new Fish[17];
	//����� ��ġ ����
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
	//�����ġ,����
	static int sx=0,sy=0,sd=0;
	static int ans=Integer.MIN_VALUE;
	
	static void input() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int num=scan.nextInt();
				int dir=scan.nextInt()-1;
				
				board[i][j]=num;//����� ��ȣ�� ����
				fishes[num]=new Fish(i,j,num,dir,true);
			}
		}
		
	}
	
	static void pro() {
		/**
		 * 1. �� (0,0)���� �����ؼ� �� ĭ�� ����⸦ �԰� ����
		 * 2. ����� �̵�
		 * 3. ��� �̵���, ���� ������ �̵��� �� �ִ� ĭ���� �̵�(�̵� �Ұ��� ���, �ݽð���� 45�� ȸ��)
		 * */
		//1.(0,0)ĭ�� ����⸦ �� �԰�, �� �� ������� ����
		//����� ��ȣ����
		int eat=board[0][0];
		fishes[eat].isAlive=false;
		sd=fishes[eat].dir;
		board[0][0]=-1;//�� �����Ѵ�~
		//dfs�� �̵�
		dfs(sx,sy,sd,eat);
		System.out.println(ans);
	}
	
	static void dfs(int sx,int sy,int sd,int eat) {
		//��ȣ ����
		ans=Math.max(ans, eat);
		//2.����Ⱑ �̵��Ѵ�~
		//��� ����� ���� ����ϱ� ���ؼ� �ʱ�ȭ���־�� ��
		Fish[] tempFishes=new Fish[17];
		int[][] tempBoard=new int[4][4];
	
		for(int i=1;i<=16;i++) {
			tempFishes[i]=new Fish(fishes[i].x,fishes[i].y,fishes[i].num,fishes[i].dir,fishes[i].isAlive);
		}
		
		for(int i=0;i<4;i++) {
			System.arraycopy(board[i], 0, tempBoard[i], 0, board.length);
		}
		//����� �̵�
		moveFish();
		
		//����̵�
		//4 by 4 �迭���� �̿�
		for(int i=1;i<4;i++) {
			int nx=sx+dir[sd][0]*i;
			int ny=sy+dir[sd][1]*i;
		
			if(nx >=0 && ny >=0 && nx<4 && ny<4 && board[nx][ny]!=0) {
				//������ ����� �ʰ�, ��ĭ�� �ƴ� (���� ���� ����� �̵���츦 ���������Ƿ� ����Ⱑ ���� ��ĭ��) ���
				int target=board[nx][ny];//����ȣ

				int nd=fishes[target].dir;
				//�� �̵��ϹǷ� ��ĭ���� ������ֱ�
				board[sx][sy]=0;
				//�� �̵��ϸ鼭 �� ��ġ�� ��ŷ���ֱ�
				board[nx][ny]=-1;
				//����� �Ա�
				fishes[target].isAlive=false;

				
				dfs(nx,ny,nd,eat+target);//��ȣ�� ����~
				
				//���󺹱�
				board[sx][sy]=-1;
				board[nx][ny]=target;
				fishes[target].isAlive=true;
			}
		}
		//�迭 ����
		for(int i=1;i<17;i++) {
			fishes[i]=new Fish(tempFishes[i].x,tempFishes[i].y,tempFishes[i].num,tempFishes[i].dir,tempFishes[i].isAlive);
		}
		
		for(int i=0;i<4;i++) {
			System.arraycopy(tempBoard[i], 0, board[i], 0, board.length);
		}
		
	}
	
	static void moveFish() {
		for(int i=1;i<17;i++) {
			//����Ⱑ ����. �� �׾��ٸ� �� �� ����
			if(!fishes[i].isAlive) continue;
			
			int d=fishes[i].dir;
			int num=fishes[i].num;
			
			for(int j=0;j<8;j++) {
				d=d%8;
				fishes[i].dir=d;
				int nx=fishes[i].x+dir[d][0];
				int ny=fishes[i].y+dir[d][1];
				//Ʋ�� ����ų�, �� �ִٸ� �̵��Ұ�
				if(nx>=0 && ny>=0 && nx<4 && ny<4 && (board[nx][ny]!=-1)) {
					//��ĭ�� ���
					if(board[nx][ny]==0) {
						//�̵�
						//������ġ�� ��ĭ���� �����
						board[fishes[i].x][fishes[i].y]=0;
						fishes[i].x=nx;
						fishes[i].y=ny;
						//����� �־��ֱ�
						board[nx][ny]=i;
					}else {
						//�̵��� ��ġ�� �ٸ� ����Ⱑ �ִ� ���
						//�� ������ġ�� ����� ��ġ�� ���� ����� ��ġ�� ����
						int trans=fishes[board[nx][ny]].num;
						fishes[trans].x=fishes[i].x;
						fishes[trans].y=fishes[i].y;
						board[fishes[trans].x][fishes[trans].y]=trans;
						
						fishes[i].x=nx;
						fishes[i].y=ny;
						//����� �־��ֱ�
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
