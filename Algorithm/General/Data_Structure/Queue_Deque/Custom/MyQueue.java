package com.queue.ringbuffer;

public class MyQueue<E> {
	//큐 본체
	private Object[] queue;
	//첫 번째 요소 커서
	private int front;
	//마지막 요소 커서
	private int rear;
	//큐의 용량
	private int capacity;
	//현재 데이터 수
	private int num;
	
	//생성자
	public MyQueue(int capacity) {
		//데이터수, 처음, 마지막 초기화
		num = front = rear= 0;
		//용량=입력된 용량
		this.capacity = capacity;
		/*
		 * 제네릭은 throwable 지원x 따라서 checked, unchecked를
		 * 상속받아 사용 불가
		 */
		queue = new Object[capacity];
	}
	
	//인큐
	public E enque(E x) {
		
		if(num >= capacity) {
			System.out.println("Overflow Error");
			System.exit(0);
		}
		queue[rear++]=x;//뒤에서 들어오니까 뒤의 인덱스를 늘려주기
		num++;//데이터 늘려주기
		/*
		 * 결론적으로 보면, 스택의 포인터가 큐에서 세분류된것!
		 */
		return x;//나중에 어떤 값이 들어갔는지 보여주기 위함
	}
	
	//디큐
	public E dequeue() {
		if(num <= 0) {
			System.out.println("no data!");
			System.exit(0);
		}
		
		Object deq = queue[front++];//앞에서 빠져나가면, 기존의 front 뒤의
		//요소가 front가 되어야 하므로, front 포인터 증가
		E e =(E)deq;
		num--;//데이터는 하나 줄이기
		
		//front-인덱스 마지막이 맞물려지면, 즉, 마지막 인덱스를 초과하려 한다면,
		//front를 0으로 다시 초기화
		if(front == capacity) {
			front = 0;
		}
		return e;
	}
	
	//큐도 peek는 상단(front)
	public E peek() {
		if(num <= 0) {
			System.out.println("no data!");
			System.exit(0);
		}
		
		Object obj = queue[front];
		E      e   = (E)obj;
		return e;
		
	}
	
	//해당값과 일치하는 인덱스 반환
	public int indexOf(E x) {
		if(num <= 0) {
			System.out.println("no data!");
			System.exit(0);
		}
		
		//반절 쪼개어 접근,반환
		int limit = num;
		int i     = 0;
		while(i < limit/2) {
			Object o    = queue[i];
			E      comp = (E)o;
			if(comp == x) {
				return i;
			}
			i++;
		}
		
		while(i < limit) {
			Object o2    = queue[i];
			E      comp2 = (E)o2;
			if(comp2 == x) {
				return i;
			}
			i++;
		}
		//그래도 못찾았다면 -1 반환
		return -1;
	}
	//큐에 데이터가 얼마나 들었는지 반환
	public int size() {
		return num;
	}
	//큐 용량
	public int capacity() {
		return capacity;
	}
	//큐가 비어있는지
	public boolean isEmpty() {
		return num<=0;
	}
	
	//큐가 꽉차있는지
	public boolean isFull() {
		return num==capacity;
	}
	
	//큐 비우기
	public void clear() {
		num=front=rear=0;
	}
	//+큐 안의 모든 데이터를 프런트 ->리어 순으로 출력
	public void dump() {
		if(num <= 0) {
			System.out.println("no data!");
			System.exit(0);
		}
		System.out.print("[");
		for(int i = 0 ; i < num; i++) {
			System.out.print(queue[(i+front)%capacity]+" ");
			//capacity로 나눈 나머지를 통해서 한 바퀴만 출력!
		}
		System.out.println("]");
	}
	//get
	public E get(int index) {
		if(num <= 0) {
			System.out.println("no data!");
			System.exit(0);
		}
		
		return (E)queue[front+index];
	}
}
