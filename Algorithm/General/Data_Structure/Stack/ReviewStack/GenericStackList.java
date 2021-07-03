package com.dataStructure.stack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericStackList<E> {

    List<E> stack=null;

    public GenericStackList(){
        stack = new ArrayList<>(20);
    }

    //push
    public Object push(E item) throws ArrayIndexOutOfBoundsException{
        stack.add(item);
        return item;
    }

    //pop
    public Object pop() throws ArrayIndexOutOfBoundsException{
        int last = stack.size()-1;
        E item = stack.get(last);

        stack.remove(last);
        return item;
    }

    //size
    public int size(){
        return stack.size();
    }

    //isEmpty
    public boolean isEmpty() throws ArrayIndexOutOfBoundsException{
        return stack.isEmpty();
    }

    //get
    public E get(int idx) throws ArrayIndexOutOfBoundsException{
        return stack.get(idx);
    }
    //capacity
    public int capacity() throws ArrayIndexOutOfBoundsException, NoSuchFieldException, IllegalAccessException {
        //reflection
        //https://stackoverflow.com/questions/2497063/how-to-get-the-capacity-of-the-arraylist-in-java
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[])field.get(stack)).length;
    }

    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();//지역변수로 사용<-어차피 매번 내용 초기화해야 함
        int size=  stack.size();
        sb.append("[");
        for(int i = 0 ; i < size; i++){
            sb.append(stack.get(i));

            if(i!=size-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
