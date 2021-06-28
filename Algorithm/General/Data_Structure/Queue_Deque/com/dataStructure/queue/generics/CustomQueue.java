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

        System.out.println("test remove");
        customQueue.offer("test remove");
        customQueue.offer("test");

        System.out.println(customQueue.remove(2));//특별히 추가한 특정 인덱스의 값 제거-test remove가 지워질것
        //test remove
        System.out.println(customQueue);//[Hello Queue!,Make Custom Queue using Generics!,test]


        int sizeCurr= customQueue.size();

        for(int i = 0 ; i < sizeCurr; i++){
            customQueue.poll();
        }
        System.out.println("isEmpty?: "+customQueue.isEmpty());//isEmpty?: true
        System.out.println("size: "+customQueue.size());//size: 0

    }
}
