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
	static ArrayList<Integer>[] conn;//연결정보
	static int[][] room;//자리

	static int[][] dir= {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	//진행순서
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
	
	//좋아하는 학생이 많은 칸으로 이동할 수 있는 칸 갯수 확인하기
	static void like(int key){
		//좋아하는 학생들(value)가져와서
		//빈 곳에 위치하게 되었을 때 인접한 곳에 value들이 얼마나 주변에 있는지 확인하고
		//최댓값을 갱신시켜주면서 (좌표, 좋아하는학생수) 리스트를 인접학생수를 기준으로 내림차순 정렬
		//만약, 최댓값인 경우가 여럿이면 2번조건에 대한 메서드를 실행
		//그렇지 않다면 자리를 정해주고 끝내기
		
		ArrayList<Integer> value=conn[key];
		int cx=0,cy=0;
		int max=Integer.MIN_VALUE;
		//(좌표, 좋아하는 학생 수)
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
					max=Integer.MIN_VALUE;//초기화
				}
			}
		}
		
		//정렬
		List<Map.Entry<int[],Integer>> list=new ArrayList<>(like.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<int[],Integer>>() {

			@Override
			public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
				// TODO Auto-generated method stub
				Integer v1=o1.getValue();
				Integer v2=o2.getValue();
				return v2.compareTo(v1);//내림차순정렬
			}
			
		});
		
		//최댓값이 여러개인지 확인
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
			//여러개인 경우 2번조건 수행
			second(key);
		}else {
			//그렇지 않으면 자리 정해주기
			int[] plot=list.get(0).getKey();
			int x=plot[0];
			int y=plot[1];
			
			if(room[x][y]==0) {
				room[x][y]=key;
			}
		}
		
	}	
	
	//2번조건
	//좌표를 움직이면서 비어있는 칸 갯수가 가장 많은 칸 확인(1번과 유사하게, 조건을 충족하는 경우가 많으면
	//3번조건으로 이행됨)
	static void second(int key) {
		int cx=0,cy=0,nx=0,ny=0;
		
		//(좌표, 그때 인접칸 갯수)
		Map<int[],Integer> like=new HashMap<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cx=i;cy=j;
				int cnt=countEmptyRoom(cx,cy);
				like.put(new int[] {cx,cy},cnt);
			}
		}
		
		//value기준으로 정렬
		List<Map.Entry<int[],Integer>> list=new ArrayList<>(like.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<int[],Integer>>() {

			@Override
			public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
				// TODO Auto-generated method stub
				Integer v1=o1.getValue();
				Integer v2=o2.getValue();
				return v2.compareTo(v1);//내림차순정렬
			}
			
		});
		
		
		//최댓값이 여러개인지 확인
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
			//여러개인 경우 3번조건 수행
			//리스트에서 키값들에 대해서만 행->열 순으로 정렬
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
						//행번호가 같으면 열번호 오름차순 정렬
						return c1.compareTo(c2);
					}
					
					return r1.compareTo(r2);
				}
				
			});
		}else {
			//그렇지 않으면 자리 정해주기
			int[] plot=list.get(0).getKey();
			int x=plot[0];
			int y=plot[1];
			
			if(room[x][y]==0) {
				room[x][y]=key;
			}
		}
	}
	
	
	//인접한 칸 중 비어있는 칸 갯수 세기
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
	
	//만족도조사
	static int satis() {
		int res=0;
		int x=0,y=0,nx=0,ny=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				x=i;y=i;//만족도 조사 대상 학생
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
		
		//만족도조사
		int res=satis();
		System.out.println(res);
	}

}
