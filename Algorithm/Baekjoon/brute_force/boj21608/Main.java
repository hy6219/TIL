package com.samsungBoj.boj21608;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

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
	static ArrayList<Integer>[] conn;//��������
	static int[][] room;//�ڸ�

	static int[][] dir= {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	//�������
	static ArrayList<Integer> order=new ArrayList<>();
	
	static void input() {
		N=r.nextInt();
		conn=new ArrayList[N*N+1];
		room=new int[N+1][N+1];
		
		for(int i=0;i<conn.length;i++) {
			conn[i]=new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			String temp=r.nextLine();
			StringTokenizer st=new StringTokenizer(temp," ");
			int key=Integer.valueOf(st.nextToken());
			order.add(key);
			while(st.hasMoreTokens()) {
				int val=Integer.valueOf(st.nextToken());
				conn[key].add(val);
				conn[val].add(key);
			}
		}
	}
	
	//�����ϴ� �л��� ���� ĭ���� �̵��� �� �ִ� ĭ ���� Ȯ���ϱ�
	static void like(int key){
		//�����ϴ� �л���(value)�����ͼ�
		//�� ���� ��ġ�ϰ� �Ǿ��� �� ������ ���� value���� �󸶳� �ֺ��� �ִ��� Ȯ���ϰ�
		//�ִ��� ���Ž����ָ鼭 (��ǥ, �����ϴ��л���) ����Ʈ�� �����л����� �������� �������� ����
		//����, �ִ��� ��찡 �����̸� 2�����ǿ� ���� �޼��带 ����
		//�׷��� �ʴٸ� �ڸ��� �����ְ� ������
		
		ArrayList<Integer> value=conn[key];
		int cx=0,cy=0;
		int max=Integer.MIN_VALUE;
		//(��ǥ, �����ϴ� �л� ��)
		Map<int[],Integer> like=new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cx=i; cy=j;
				for(int k=0;k<4;k++) {
					int nx=cx+dir[k][0];
					int ny=cy+dir[k][1];
					
					if(nx<0 || ny<0 || nx>=N||ny>=N) continue;
					int cnt=0;
					for(int l=0;l<value.size();k++) {
						if(room[nx][ny]==value.get(l)) cnt++;
					}
					max=Math.max(max, cnt);
					like.putIfAbsent(new int[] {nx, ny},max);
					max=Integer.MIN_VALUE;//�ʱ�ȭ
				}
			}
		}
		
		//����
		List<Map.Entry<int[],Integer>> list=new ArrayList<>(like.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<int[],Integer>>() {

			@Override
			public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
				// TODO Auto-generated method stub
				Integer v1=o1.getValue();
				Integer v2=o2.getValue();
				return v2.compareTo(v1);//������������
			}
			
		});
		
		//�ִ��� ���������� Ȯ��
		boolean flag=false;
		for(int i=0;i<list.size()-1;i++) {
			int one=list.get(i).getValue();
			int two=list.get(i+1).getValue();
			if(one==two) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			//�������� ��� 2������ ����
			second(key);
		}else {
			//�׷��� ������ �ڸ� �����ֱ�
			int[] plot=list.get(0).getKey();
			int x=plot[0];
			int y=plot[1];
			
			if(room[x][y]==0) {
				room[x][y]=key;
			}
		}
		
	}	
	
	//2������
	//��ǥ�� �����̸鼭 ����ִ� ĭ ������ ���� ���� ĭ Ȯ��(1���� �����ϰ�, ������ �����ϴ� ��찡 ������
	//3���������� �����)
	static void second(int key) {
		int cx=0,cy=0,nx=0,ny=0;
		
		//(��ǥ, �׶� ����ĭ ����)
		Map<int[],Integer> like=new HashMap<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cx=i;cy=j;
				int cnt=countEmptyRoom(cx,cy);
				like.put(new int[] {cx,cy},cnt);
			}
		}
		
		//value�������� ����
		List<Map.Entry<int[],Integer>> list=new ArrayList<>(like.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<int[],Integer>>() {

			@Override
			public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
				// TODO Auto-generated method stub
				Integer v1=o1.getValue();
				Integer v2=o2.getValue();
				return v2.compareTo(v1);//������������
			}
			
		});
		
		
		//�ִ��� ���������� Ȯ��
		boolean flag=false;
		for(int i=0;i<list.size()-1;i++) {
			int one=list.get(i).getValue();
			int two=list.get(i+1).getValue();
			if(one==two) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			//�������� ��� 3������ ����
			//����Ʈ���� Ű���鿡 ���ؼ��� ��->�� ������ ����
			List<int[]> keyList=new ArrayList<>(like.keySet());
			Collections.sort(keyList,new Comparator<int[]>(){

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					Integer r1=o1[0];
					Integer r2=o2[0];
					
					Integer c1=o1[1];
					Integer c2=o2[1];
					
					if(r1==r2) {
						//���ȣ�� ������ ����ȣ �������� ����
						return c1.compareTo(c2);
					}
					
					return r1.compareTo(r2);
				}
				
			});
		}else {
			//�׷��� ������ �ڸ� �����ֱ�
			int[] plot=list.get(0).getKey();
			int x=plot[0];
			int y=plot[1];
			
			if(room[x][y]==0) {
				room[x][y]=key;
			}
		}
	}
	
	
	//������ ĭ �� ����ִ� ĭ ���� ����
	static int countEmptyRoom(int x,int y) {
		int cnt=0;
		int nx=0,ny=0;
		for(int i=0;i<4;i++) {
		
			nx=x+dir[i][0];
			ny=x+dir[i][1];
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(room[nx][ny]==0) cnt++;
		}
		
		return cnt;
	}
	
	//����������
	static int satis() {
		int res=0;
		int x=0,y=0,nx=0,ny=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				x=i;y=i;//������ ���� ��� �л�
				ArrayList<Integer> list=conn[room[x][y]];
				for(int k=0;k<4;k++) {
					nx=x+dir[k][0];
					ny=y+dir[k][1];
					
					if(nx<0||ny<0|| nx>=N|| ny>=N) continue;
					
					int cnt=0;
					for(int l=0;l<list.size();l++) {
						if(room[nx][ny]==list.get(l)) {
							cnt++;
						}
					}
					if(cnt==1) {
						res++;
					}else if(cnt==2) {
						res+=10;
					}else if(cnt==3) {
						res+=100;
					}else if(cnt==4) {
						res+=1000;
					}
					
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		for(int i=0;i<order.size();i++) {
			int turn=order.get(i);
			like(turn);
		}
		
		//����������
		int res=satis();
		System.out.println(res);
	}

}
