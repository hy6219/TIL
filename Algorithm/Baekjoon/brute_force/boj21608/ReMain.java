package com.samsungBoj.boj21608;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

	static class Student{
		//��ǥ,ģ��ģ�����
		int x;
		int y;
		int[] friends;
		public Student(int x, int y, int[] friends) {
			super();
			this.x = x;
			this.y = y;
			this.friends = friends;
		}
		
	}
	
	
	
	static FastReader r=new FastReader();
	static int N;
	//�л���ȣ-�����ϴ� ģ�� �л��� ����
	//���л��� �ڸ��� ���� info�� ����ֱ�
	static Map<Integer,Student> info=new HashMap<>();
	
	//�� ��ǥ �ֺ��� �ڸ��� �󸶳� ����ִ��� �����صα�
	static int[][] empty;
	static int[][] classroom;
	static int N2;

	static int[][] dir= {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	
	static void input() {
		N=r.nextInt();
		N2=N*N;
		classroom=new int[N][N];
		
		fillEmptySeat();
		
		for(int i=0;i<N2;i++) {
			int key=r.nextInt();
			int v1=r.nextInt();
			int v2=r.nextInt();
			int v3=r.nextInt();
			int v4=r.nextInt();
			
			findSeat(key,new int[] {v1,v2,v3,v4});
		}
	}
	
	static void fillEmptySeat() {
		empty=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt=4;
				if(i==0||i==N-1) cnt--;
				if(j==0||j==N-1) cnt--;
				empty[i][j]=cnt;
			}
		}
	}
	
	static void findSeat(int key,int[] values) {
		//ģ��ģ�� �ڸ��� �̹� �����Ǿ��ٸ�, ģ���� ������ ���� ������ ������ �켱������ ������ �� �ֵ��� �ϴ� �迭
		int[][] nearScore=new int[N][N];
		
		for(int friend:values) {
			//��ϵǾ� �ִ��� Ȯ��==�̹� �ڸ��� ã�Ҵ��� Ȯ��
			if(info.containsKey(friend)) {
				Student s=info.get(friend);
				int x=s.x;
				int y=s.y;
				
				for(int i=0;i<4;i++) {
					int nx=x+dir[i][0];
					int ny=x+dir[i][1];
					
					if(nx>=0&&ny>=0 && nx<N&& ny<N && classroom[nx][ny]==0) nearScore[nx][ny]++;
				}
			}
		}
		
		//������ �켱������ �� ��, �̸� �̿��ؼ� �ڸ� ��ġ��Ű��
		int emptyCnt=-1;
		int nearScoreMax=-1;
		int choiceX=-1;
		int choiceY=-1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(classroom[i][j]!=0) continue;//�̹� �ش��ڸ��� �ִ� ���
				if(nearScoreMax<nearScore[i][j]) {
					//1�������� ���Ѱ�
					//�� ��ü
					nearScoreMax=nearScore[i][j];
					emptyCnt=empty[i][j];
					//��ǥ���� ��ü
					choiceX=i;
					choiceY=j;
				}else if(nearScoreMax==nearScore[i][j] && emptyCnt<empty[i][j]) {
					//2������
					//�ٸ� ������ ������ ���� �� ���� ���� ���
					emptyCnt=empty[i][j];
					choiceX=i;
					choiceY=j;
				}
			}
		}
		
		//�ڸ���ġ
		classroom[choiceX][choiceY]=key;
		info.put(key, new Student(choiceX,choiceY,values));
		
		//��ġ�� �ڸ� �ֺ� �ڸ� ������ �����ֱ�
		for(int i=0;i<4;i++) {
			int nx=choiceX+dir[i][0];
			int ny=choiceY+dir[i][1];
			
			if(nx>=0&&ny>=0 && nx<N&& ny<N && classroom[nx][ny]==0) empty[nx][ny]--;
		}
	}
	//����������
	static int satis() {
		int res=0;
		
		for(int i=1;i<=N2;i++) {
			Student s=info.get(i);
			int cnt=0;
			//3�������� ������ ������ �Ÿ��� ����Ͽ� ����
			for(int friend:s.friends) {
				if(Math.abs(info.get(friend).x-s.x)+Math.abs(info.get(friend).y-s.y)==1) {
					//������ ���
					cnt++;
				}
			}
			if(cnt==1) res++;
			else if(cnt==2) res+=10;
			else if(cnt==3) res+=100;
			else if(cnt==4) res+=1000;
			System.out.println("�л�: "+i+" "+Arrays.toString(s.friends));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		//����������
		int res=satis();
		System.out.println("classroom: "+Arrays.deepToString(classroom));
		System.out.println(res);
		
	}

}
