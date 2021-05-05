package com.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//boj10828
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//bufferedReader+ 발생가능한 상황 예외처리
	
	//스택 본체
	private int[] stack;
	//포인터
	private int pointer;
	//스택 용량
	private final int capacity = 10000;
	
	//스택 생성
	public Main() {
		pointer =0;
		stack = new int[capacity];
	}
	//push
	public void push(int x) {
		stack[pointer++]=x;
	}
	//size
	public int size() {
		return pointer;
	}
	//empty
	public int empty() {
		if(pointer == 0) {
			return 1;
		}
		return 0;
	}
	//top--peek
	public int top() {
		if(pointer == 0) {
			return -1;
		}
		int r = stack[pointer-1];
		return r;
	}
	//pop
	public int pop() {
		int tmp = empty();
		if(tmp == 1) {
			return -1;
		}
		return stack[--pointer];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Main stack   = new Main();
		
		//테스트 케이스 입력받기
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i = 0 ; i < testCase; i++) {
			//명령어 식별
			String cli = br.readLine();
			StringTokenizer st = new StringTokenizer(cli," ");
			String parts[]=new String[2];
			int div =0;
			while(st.hasMoreElements()) {
				String tmp = st.nextToken();
				parts[div++]=tmp;
			}
			
			switch(parts[0]) {
			case "push":
				stack.push(Integer.valueOf(parts[1]));
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			case "top":
				System.out.println(stack.top());
				break;
			}
			
			
		}
	}
	
	
	
}
