package com.stack;


public class IntStack {
	//스택본체
	private int[] stack;
	//스택 용량
	private int capacity;
	//스택 포인터
	private int pointer;
	
	/*
	 * runtime exception 생성
	 * - 스택이 비어있을 때
	 * - 스택이 오버플로우되었을 때
	 */
	public class EmptyStackException extends RuntimeException{
		public EmptyStackException() {}
	}
	
	public class OverFlowStackException extends RuntimeException{
		public OverFlowStackException() {}
	}
	
	//사용자가 입력한 크기만큼의 스택 만들기
	//pointer는 가득차면 capacity값과 같아짐!
	public IntStack(int capacity) {
		pointer = 0;//처음부터 시작할 수 있도록!
		//용량을 지정해두기
		this.capacity=capacity;
		//메모리가 넘칠수 있는 경우에 대한 예외처리
		try {
			stack = new int[this.capacity];
		}catch(OutOfMemoryError e) {
			//다시 0으로
			capacity = 0;
			this.capacity=capacity;
		}
	}
	
	//push
	public int push(int x) throws OverFlowStackException{
		//push하되, push하다가 넘칠 수 있어서 해당 경우에 대해서 예외를 throw로
		//책임전가함
		if(pointer >= capacity) {
			//오버플로우가 발생하는 경우에는 예외를 고의로 발생시키기
			throw new OverFlowStackException();
		}
		//예외발생 경우 외에는 다음 칸에 채우기
		return stack[pointer++] = x;
	}
	
	//pop 하되, 저장해서 확인할 경우를 위해서 return
	public int pop() throws EmptyStackException{
		
		//pop하되, 포인터가 0이하면 언더플로우!
		if(pointer <= 0) {
			throw new EmptyStackException();
		}
		/*
		 * 스택에 대한 모든 작업은 포인터를 바탕으로 이루어지기 때문에
		 * 실제 배열 요소값변경을 할 필요없이 포인터를 움직이거나
		 * 변경하면 됨!
		 */
		return stack[--pointer];
	}
	
	
	//peek: 상단 값 알아내기
	public int peek() throws EmptyStackException{
		//포인터가 0이하면 언더플로우!
		if(pointer <= 0) {
			throw new EmptyStackException();
		}
		return stack[pointer-1];
	}
	
	//indexOf: 요소 위치 찾아내기
	public int indexOf(int value) throws EmptyStackException{
		int i 	  = 0;
		int limit = this.capacity;
		//포인터가 0이하면 언더플로우!
		if(pointer <= 0) {
			throw new EmptyStackException();
		}
		//절반씩 나누어서 진행(절반기준 이전만큼 작업했을 때, 찾았으면 종료하도록)
		while(i < limit/2) {
			if(stack[i]==value) {
				return i;
			}
			i++;
		}
		
		while(i < limit) {
			if(stack[i] == value) {
				return i;
			}
			i++;
		}
		//찾아도 없으면 -1반환
		return -1;
	}
	
	//용량확인 capacity()
	public int capacity(){
		return capacity;
	}
	//데이터 수 확인
	public int size() {
		return pointer;
	}
	//https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html#get(int)
	//stack.get(index)
	public int get(int index) throws EmptyStackException{
		if(pointer <= 0) {
			throw new EmptyStackException();
		}
		
		return stack[index];
	}
	
	//스택이 비어있는지 확인
	public boolean isEmpty() {
		return (pointer==0)?true:false;//capacity를 처음에 지정해두고
		//나중에 채우지 않았을 수도 있으므로, 실질적인 포인터로 접근
	}
	
	//스택이 꽉 차있는지 확인
	public boolean isFull() {
		return (pointer==this.capacity)?true:false;
	}
	//스택에 쌓여 있는 모든 요소를 삭제
	public void clear() {
		pointer = 0;//포인터만 변경하면 됨!
	}
}
