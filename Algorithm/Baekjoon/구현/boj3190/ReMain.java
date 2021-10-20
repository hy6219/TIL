package com.samsungBoj.boj3190;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ReMain {
	
	  public static int[][] map = new int[101][101];
	    public static int[] dr = {-1, 0, 1, 0}; // ��, ��, ��, ��
	    public static int[] dc = {0, 1, 0, -1};
	    public static Deque<Point> q = new LinkedList<Point>();
	    public static int N, L, ans = 0;
	    public static int[] time;
	    public static char[] direction;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	        N = Integer.parseInt(br.readLine());
	        int K = Integer.parseInt(br.readLine());
	        for (int i = 0; i < K; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int r = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());

	            map[r][c] = 2;  // ����� 2
	        }

	        L = Integer.parseInt(br.readLine());
	        time = new int[L];
	        direction = new char[L];
	        for (int i = 0; i < L; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            time[i] = Integer.parseInt(st.nextToken());
	            direction[i] = st.nextToken().charAt(0);
	        }

	        q.add(new Point(1, 1));
	        map[1][1] = 1;

	        playGame(1, 1, 1);

	        bw.write(ans + "\n");
	        br.close();
	        bw.flush();
	        bw.close();
	    }

	    public static void playGame(int row, int col, int d) {
	        int i = 0;
	        while (true) {
	            if (i < L && ans == time[i]) {
	                if (direction[i] == 'D') { // ��ȸ��
	                    d = (d + 1) % 4;
	                } else if (direction[i] == 'L') {  // ��ȸ��
	                    d = (d + 3) % 4;
	                }
	                i++;
	            }

	            int next_r = row + dr[d];
	            int next_c = col + dc[d];
	            q.addFirst(new Point(next_r, next_c));   // �Ӹ��� ����ĭ�� ��ġ

	            if (next_r <= 0 || next_c <= 0 || next_r > N || next_c > N) {   // ������ ������ ���
	                ans++;
	                break;
	            }

	            if (map[next_r][next_c] == 2) { // ����� �ִٸ�
	                map[next_r][next_c] = 1;
	            } else if (map[next_r][next_c] == 0) {    // ����� ���ٸ�
	                map[next_r][next_c] = 1;
	                map[q.peekLast().x][q.peekLast().y] = 0;    // ������ ��ġ�� ĭ ����ֱ�
	                q.pollLast();
	            } else {  // �ڱ� �ڽŰ� �ε����ٸ�
	                ans++;
	                break;
	            }

	            row = next_r;
	            col = next_c;
	            ans++;
	        }
	    }
}
