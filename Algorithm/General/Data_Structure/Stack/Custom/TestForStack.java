package com.stack;

public class TestForStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStack stack = new IntStack(10);
		
		for(int i = 0 ; i < 10; i++) {
			stack.push(i+1);
			System.out.println("상단: "+stack.peek());
		}


		 
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
		/*
		 * 이제 없으니까 에러남
		System.out.println(stack.peek());
		
		Exception in thread "main" com.stack.IntStack$EmptyStackException
	at com.stack.IntStack.peek(IntStack.java:68)
	at com.stack.Run.main(Run.java:18)
		*/
	}

}
