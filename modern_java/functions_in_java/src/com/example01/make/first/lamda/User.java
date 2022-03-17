package com.example01.make.first.lamda;

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //인스턴스 메서드
    public void printUserInfo(){
        System.out.println(this.getName()+"의 나이: "+this.getAge());
    }

    //static method
    public static User from(Person person){
        return new User(person.getName(),person.getAge());
    }
}
