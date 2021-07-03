package com.dataStructure.stack;


public class CustomStackTest {

    public static void main(String[] args){

        CustomStack<String> stack = new CustomStack<>();
        System.out.println("first, now is empty?: "+stack.isEmpty());//first, now is empty?: true
        System.out.println("first, now is full?: "+stack.isFull());//first, now is full?: false
        System.out.println("capacity: "+stack.capacity());//capacity: 10000
        System.out.println("size: "+stack.size());//size: 0

        for(int i = 0 ; i < stack.capacity(); i++){
            System.out.println("#"+i+": "+stack.push("push"+i));//...#9999: push9999
        }
        System.out.println("after push, now is empty?: "+stack.isEmpty());//after push, now is empty?: false
        System.out.println("after push, now is full?: "+stack.isFull());//after push, now is full?: true
        System.out.println("capacity: "+stack.capacity());//capacity: 10000
        System.out.println("size: "+stack.size());//size: 10000

        stack.pop();
        stack.pop();

        System.out.println("after pop two items, now is empty?: "+stack.isEmpty());//after pop two items, now is empty?: false
        System.out.println("after pop two items, now is full?: "+stack.isFull());//after pop two items, now is full?: false
        System.out.println("capacity: "+stack.capacity());//capacity: 10000
        System.out.println("size: "+stack.size());//size: 9998
        System.out.println("get 2nd index item: "+stack.get(2));//get 2nd index item: push2


       final int temp = stack.size();
        //i<stack.size()로 넣어주게 되면 매번 해당 함수를 부르게 되고 정확한 동작이 수행되지 않을 수 있고
        //그런 과정의 영향으로 모두 제거되지 않을 수 있음
       for(int i = 0 ; i < temp; i++){
           stack.pop();
       }

        System.out.println("after pop all items, now is empty?: "+stack.isEmpty());//after pop all items, now is empty?: true
        System.out.println("after pop all items, now is full?: "+stack.isFull());//after pop all items, now is full?: false
        System.out.println("capacity: "+stack.capacity());//capacity: 10000
        System.out.println("size: "+stack.size());//capacity: 10000

    }
}
