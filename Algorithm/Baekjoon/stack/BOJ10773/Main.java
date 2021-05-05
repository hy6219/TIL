package com.stack.boj10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int line = 0;
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		int sum = 0;
		line = Integer.valueOf(sc.nextLine());
		for(int i = 0 ; i < line; i++) {
			int tmp = Integer.valueOf(sc.nextLine());
			if(tmp!=0) {
				stack.push(tmp);
			}else {
				stack.pop();
			}
		}
		int limit = stack.size();
		for(int i = 0; i < limit;i++) {
			int top = (int)stack.pop();
			sum += top;
		}
		System.out.println(sum);
		
		
	}

}
