package com.dataStructure.queue;

import java.lang.reflect.Array;

public class MyQueue {
    int[] queue;
    int  pointer=0;

    public MyQueue(){
        queue=new int[10000];
    }
    //enque
    public boolean offer(int item) throws ArrayIndexOutOfBoundsException{
        queue[pointer++]=item;
        return true;
    }

    //사이즈
    public int size(){
        return pointer;
    }

    //front
    public int front() throws ArrayIndexOutOfBoundsException{
        return queue[pointer-1];
    }

    //rear
    public int peek() throws ArrayIndexOutOfBoundsException {
        return queue[0];
    }
    //dequeue
    public int poll() throws ArrayIndexOutOfBoundsException{
        pointer--;
        return queue[0];
    }
    //empty
    public boolean isEmpty(){
        return pointer==0;
    }

    //toString(주소값을 출력하지 않도록)
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int size = size();

        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(queue[i]);
            //마지막이 아니라면 comma 구분자 넣기
            if(i!=size-1){
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
