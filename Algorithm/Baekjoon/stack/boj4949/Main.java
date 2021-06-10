package com.stack.boj4949.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

   
   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   
	   String input="";
	   
	   Loop1:
	   while(!(input=br.readLine()).equals(".")) {
		   Stack<Character> stack = new Stack<>();
		   
		   for(int i = 0 ; i < input.length(); i++) {
			   //열린괄호면 push하는데, 닫힌 괄호를 보면서 비어있으면 no를 출력하고 스택을 다시 탐색
			   if(input.charAt(i)=='(') {
				   stack.push('(');
			   }else if(input.charAt(i)==')') {
				   if(stack.isEmpty()) {
					   bw.write("no\n");
					   continue Loop1;
				   }
				   
				   //만약 스택이 비어있지 않다면 pop을 해서 pair를 확인하자
				   char comp = (char)stack.pop();
				   
				   if(comp!='(') {
					   //pair가 되지 않은 경우
					   bw.write("no\n");
					   continue Loop1;
				   }
			   }else if(input.charAt(i)=='[') {
				   //[열린괄호일때
				   stack.push('[');
			   }else if(input.charAt(i)==']') {
				   if(stack.isEmpty()) {
					   bw.write("no\n");
					   continue Loop1;
				   }else {
					   char c = (char)stack.pop();
					   
					   if(c !='[') {
						   bw.write("no\n");
						   continue Loop1;
					   }
				   }
				 
				   
			   }
			   
		   }//한줄에 대한 확인 완료!
		 //마지막으로 최종확인! 비어있지 않으면 no(비게 될때까지 확인!)
		   if(!stack.isEmpty()) {
			   bw.write("no\n");
			   continue Loop1;
		   }
		   bw.write("yes\n");
	   }
      
	   bw.flush();
	   bw.close();
	   br.close();
   }

}
