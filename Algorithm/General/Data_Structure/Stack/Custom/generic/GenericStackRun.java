package com.stack.generics;

public class GenericStackRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<Integer> stack = new GenericStack(13);
		
		//용량
		System.out.println("capacity: "+stack.capacity());
		
		//push
		for(int i = 0 ; i < 10; i++) {
			stack.push(i+1);
			System.out.println("상단: "+stack.peek());
		}
		System.out.println("--test dump---");
		 
		System.out.println("===");
		System.out.println("3찾기: "+stack.indexOf(3));//2
		System.out.println("스택이 꽉 차 있나요?: "+stack.isFull());//true
		//7번째 인덱스 값 찾기
		System.out.println("get value in index==7: "+stack.get(7));//8
		
		System.out.println("===pop"); 
		for(int i = 0; i < 5; i++) {
			System.out.println("**");
			System.out.println("상단: "+stack.peek());
			System.out.println("pop :"+stack.pop()); 
			System.out.println("상단: "+stack.peek());
			System.out.println("**");
		}
		System.out.println("지금 용량은? : "+stack.capacity());//10(용량은 변하지x!)
		System.out.println("지금 크기는? : "+stack.size());//5
		//다 지우기
		stack.clear();
		System.out.println("clear 후 지금 크기는?: "+stack.size());//0
		System.out.println("clear 후 지금 비어있나요? : "+stack.isEmpty());//true
	}

}
