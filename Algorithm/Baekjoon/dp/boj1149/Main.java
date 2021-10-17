package com.dp.boj1149;

import java.io.BufferedReader;
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
	
	static class Home{
		int red;
		int green;
		int blue;
		Map<String,Integer> map=new HashMap<>();
		
		public Home(int red,int green,int blue) {
			this.red=red;
			this.green=green;
			this.blue=blue;
		}

		public int getRed() {
			return red;
		}

		public void setRed(int red) {
			this.red = red;
		}

		public int getGreen() {
			return green;
		}

		public void setGreen(int green) {
			this.green = green;
		}

		public int getBlue() {
			return blue;
		}

		public void setBlue(int blue) {
			this.blue = blue;
		}

		public Map<String, Integer> getMap() {
			return map;
		}
	

		
		public void setMap(Map<String,Integer> map) {
			this.map=map;
		}

		@Override
		public String toString() {
			return "Home [red=" + red + ", green=" + green + ", blue=" + blue + ", map=" + map + "]";
		}
		
	}
	
	static FastReader r=new FastReader();
	static int N;
	static ArrayList<Home> home=new ArrayList<>();
	static int min=0;
	//색깔 기록
	static String[] colors;
	
	static void input() {
		N=r.nextInt();
		colors=new String[N];
		
		for(int i=0;i<N;i++) {
			int red=r.nextInt();
			int green=r.nextInt();
			int blue=r.nextInt();
			Home h=new Home(red,green,blue);
			Map<String,Integer> m=new HashMap<>();
			m.put("R",red);
			m.put("G", green);
			m.put("B",blue);
			
			//최소비용 순서대로 정렬해두기
			List<Map.Entry<String,Integer>> list=new ArrayList<>(m.entrySet());
			Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					Integer v1=o1.getValue();
					Integer v2=o2.getValue();
					return v1.compareTo(v2);
				}
				
			});
		
			m=new HashMap<>();
			for(int j=0;j<list.size();j++) {
				m.put(list.get(j).getKey(), list.get(j).getValue());
			}
			h.setMap(m);
			
			home.add(h);
		}	
		
	}
	
	static void pro() {

		//1번집은 최소비용으로 먼저 칠해두기
		ArrayList<Map.Entry<String, Integer>> list=new ArrayList<>(home.get(0).getMap().entrySet());
		colors[0]=list.get(0).getKey();
		min+=list.get(0).getValue();
		
		Loop:
		for(int i=1;i<N;i++) {
			//이전 집과 겹치는 색이 되지 않도록 확인하면서 색칠하기
			list=new ArrayList<>(home.get(i).getMap().entrySet());
			String prev=colors[i-1];
			
		//	System.out.println("list: "+list);
			for(int j=0;j<3;j++) {
				String col=list.get(j).getKey();
			//	System.out.println("cur color: "+col);
			//	System.out.println("prev color: "+prev);
				if(prev.equals(col))continue;
				else {
					colors[i]=list.get(j).getKey();
					break;
				}
			}
		}
		
		for(int i=1;i<N;i++) {
			min+=home.get(i).getMap().get(colors[i]);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
		//System.out.println("colors: "+Arrays.toString(colors));
		System.out.println(min);
	}

}
