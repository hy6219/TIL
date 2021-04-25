package com.queue.ringbuffer;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> queue = new MyQueue(13);
		System.out.println("capacity: "+queue.capacity());//13
		
		for(int i = 0; i < 5; i++) {
			System.out.println("***");
			queue.enque(i+1);
			System.out.println("peek: "+queue.peek());//1
			//링버퍼로 되어있기 때문!
			System.out.println("***");
		}
		//용량
		System.out.println("크기: "+queue.size());//5
		//1개만 디큐!
		System.out.println(queue.dequeue());//1
		//용량
		System.out.println("크기: "+queue.size());//4
		
		//현재 데이터
		System.out.println("현재 데이터: ");
		queue.dump();//2 3 4 5
		
		System.out.println("get value in index 2: "+queue.get(2));//4
		
		System.out.println("지금 큐가 비워져 있나요?: "+queue.isEmpty());//false
		System.out.println("is full?: "+queue.isFull());//false
		
		//clear
		queue.clear();
		System.out.println("[after clear]지금 큐가 비워져 있나요?: "+queue.isEmpty());//true
		System.out.println("[after clear]is full?: "+queue.isFull());//false
		System.out.println("[after clear] size: "+queue.size());//0
	}

}
