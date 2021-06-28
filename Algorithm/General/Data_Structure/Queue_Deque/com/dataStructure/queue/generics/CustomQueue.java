package com.dataStructure.queue.generics;

public class CustomQueue<E> {
    E[] queue;
    int pointer = 0;

    public CustomQueue(){
        queue= (E[])new Object[1000];
    }
    //enqueue
    public boolean offer(E item) throws ArrayIndexOutOfBoundsException{
        queue[pointer++]=item;
        return true;
    }

    //size
    public int size() throws ArrayIndexOutOfBoundsException{
        return pointer;
    }
    //isEmpty
    public boolean isEmpty(){
        return pointer==0;
    }

    //데이터를 넣는 곳 front
    public E front() throws ArrayIndexOutOfBoundsException{
        return queue[pointer-1];
    }

    //데이터를 빼는 곳 rear
    public E peek() throws ArrayIndexOutOfBoundsException{
        return queue[0];
    }
    //dequeue
    public E poll() throws ArrayIndexOutOfBoundsException{
        pointer--;
        return queue[0];
    }

    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int size = size();

        sb.append("[");
        for(int i = 0 ; i < size; i++){
            sb.append(queue[i]);

            if(i!=size-1){
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
