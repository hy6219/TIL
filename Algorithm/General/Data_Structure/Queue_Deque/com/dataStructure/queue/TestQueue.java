package com.dataStructure.queue;

public class TestQueue {
    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        System.out.println("size of queue: "+queue.size());//size of queue: 0
        System.out.println(queue.isEmpty());//true

        queue.offer(1);
        queue.offer(2);

        System.out.println(queue);//[1,2]

        queue.offer(3);
        queue.offer(4);

        System.out.println("size of queue: "+queue.size());//size of queue: 4
        System.out.println("isEmpty: "+ queue.isEmpty());//isEmpty: false

        System.out.println("front: "+queue.front());//front: 4-데이터를 넣는 곳
        System.out.println("rear: "+queue.peek());//rear: 1-데이터를 빼는 곳

        //dequeue
        System.out.println("dequeue: "+queue.poll());//dequeue: 1
        System.out.println("isEmpty: "+queue.isEmpty());//isEmpty: false
        System.out.println("size: "+queue.size());//size: 3

        int nowSize = queue.size();

        for(int i = 0 ; i < nowSize; i++){
            queue.poll();
        }
        System.out.println("isEmpty: "+queue.isEmpty());//isEmpty: true
        System.out.println("size: "+queue.size());//size: 0


    }
}
