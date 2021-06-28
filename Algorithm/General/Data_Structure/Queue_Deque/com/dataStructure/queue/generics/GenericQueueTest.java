package com.dataStructure.queue.generics;

public class GenericQueueTest {
    public static void main(String[] args){
        //큐 인터페이스를 이용하지 않고 직접 구현한 것이라서 linkedList로 구현체를 만들지 않았습니다
        CustomQueue<String> customQueue = new CustomQueue<>();

        System.out.println("isEmpty?: "+customQueue.isEmpty());//isEmpty?: true
        System.out.println("size: "+customQueue.size());//size: 0

        customQueue.offer("Hello Queue!");
        customQueue.offer("Make Custom Queue using Generics!");

        System.out.println(customQueue);//[Hello Queue!,Make Custom Queue using Generics!]
        System.out.println("isEmpty?:"+ customQueue.isEmpty());//isEmpty?:false
        System.out.println("size: "+customQueue.size());//size: 2

        int sizeCurr= customQueue.size();

        for(int i = 0 ; i < sizeCurr; i++){
            customQueue.poll();
        }
        System.out.println("isEmpty?: "+customQueue.isEmpty());//isEmpty?: true
        System.out.println("size: "+customQueue.size());//size: 0

    }
}
