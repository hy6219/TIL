package com.dataStructure.stack;

public class CustomStack<E> {
    //스택 본체
    E[] stack = null;
    //직접 빼내고 삽입하는것보다는, 포인터로 접근해서 처리하는 것이 처리 속도가 보다 나을 것
    int pointer = 0;

    //객체 인스턴스 생성 시 크기 정해주기
    public CustomStack(){
        stack = (E[])new Object[10000];
    }

    //push
    public E push(E item) throws ArrayIndexOutOfBoundsException{
        stack[pointer++]=item;
        return item;
    }

    //pop
    public E pop() throws ArrayIndexOutOfBoundsException{
        return stack[--pointer];
    }

    //size
    public int size(){
        return pointer;
    }

    //isEmpty
    public boolean isEmpty() throws ArrayIndexOutOfBoundsException{
        return pointer==0;
    }

    //isFull
    public boolean isFull() throws ArrayIndexOutOfBoundsException{
        return pointer==stack.length;
    }

    //capacity
    public int capacity() throws ArrayIndexOutOfBoundsException{
        return stack.length;
    }

    //get
    public E get(int idx) throws  ArrayIndexOutOfBoundsException{
        return stack[idx];
    }

    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();//지역변수로 사용<-어차피 매번 내용 초기화해야 함

        sb.append("[");
        for(int i = 0 ; i < pointer; i++){
            sb.append(stack[i]);

            if(i!=pointer-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
