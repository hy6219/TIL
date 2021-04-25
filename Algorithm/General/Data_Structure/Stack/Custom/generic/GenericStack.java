package com.stack.generics;


/*
 * The generic class GenericStack<E>.EmptyStackException may not subclass java.lang.Throwable
 * 제네릭을 이용한 클래스에서는 throwable을 이용한 예외발생이 어려움
 * 
 */
public class GenericStack<E> {
	//스택본체
	private Object[] stack;
	//스택 포인터
	private int pointer;
	//스택 용량
	private int capacity;
	
	//생성자
	public GenericStack(int capacity){
		this.capacity = capacity;
		stack = new Object[capacity];
	}
	//capacity
	public int capacity() {
		return capacity;
	}
	//isFull
	public boolean isFull() {
		return pointer>=capacity;
	}
	//isEmpty
	public boolean isEmpty() {
		return pointer <= 0;
	}
	//size
	public int size() {
		return pointer;
	}
	//clear
	public void clear() {
		pointer = 0;
	}
	//push
	public void push(E x) {
		if(pointer >= capacity) {
			System.out.println("OverFlow 발생");
			System.exit(0);
		}else
		{
			stack[pointer++] = x;
		}
	}

	//pop
	public E pop() {
		if(pointer <= 0) {
			System.out.println("ERROR! 빈 스택입니다!");
			System.exit(0);
		}
		Object obj = stack[--pointer];
		E e = (E)obj;
		return e;
	}
	
	//peek
	public E peek() {
		Object obj = stack[pointer-1];
		E e =(E) obj;
		return e;
	}
	//get index
	public int indexOf(E e) {
		if(pointer <= 0) {
			System.out.println("ERROR! 빈 스택입니다!");
			System.exit(0);
		}
		//반절씩 나눠서 앞에서 찾으면 바로 종료
		int i = 0;
		final int limit = capacity;
		while(i < limit/2) {
			if(stack[i]==e) {
				return i;
			}
			i++;
		}
		
		while(i < limit) {
			if(stack[i]==e) {
				return i;
			}
			i++;
		}
		//못찾았으면 -1 반환
		return -1;
	}
	
	//get
	public E get(int index) {
		
		Object obj = stack[index];
		E      e   = (E)obj;
		if(pointer <= 0) {
			System.out.println("ERROR! 빈 스택입니다!");
			System.exit(0);
		}
		return e;
	}
}
