package com.designPattern.generator.singleton;

public class Singleton {
    private Singleton(){

    }

    private static Singleton s;

    public static Singleton getInstance(){
       if(s==null){
           //생성자로 정의되어 있지 않은 경우[static은 this를
           // 사용할 수 없기 때문에 this.s는 안됨!!]
           s = new Singleton();
       }
       return s;
    }

    public void connect(){
        System.out.println("연결되었습니다");
    }



}
