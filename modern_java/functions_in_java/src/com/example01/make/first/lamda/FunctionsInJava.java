package com.example01.make.first.lamda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionsInJava {
    @Test
    public void 람다맛보기(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        System.out.println(Arrays.toString(hiddenFiles));

    }

    @Test
    public void 메서드레퍼런스_정적메서드참조(){
        Person person = new Person("김길동",27);
        FunctionalnterfaceForLamda lamda = User::from;
        User user = lamda.translate(person);
        user.printUserInfo();
    }

    @Test
    public void 메서드레퍼런스_인자가_있는_생성자참조(){
        BiFunction<String,Integer,Person> function = Person::new;
        Person person = function.apply("나길동",27);
        System.out.println(person.getName()+" "+person.getAge());

    }

    @Test
    public void 메서드레퍼런스_기본_생성자_참조(){
        Supplier<User> supplier = User::new;
        User user = supplier.get();
        System.out.println(user.getName());
    }

    @Test
    public void 메서드레퍼런스_void_메서드_인스턴스참조(){
        User user = new User("김길동",12);
        Runnable printUserInfo = user::printUserInfo;
        printUserInfo.run();
    }

    @Test
    public void 메서드레퍼런스_void가_아닌_메서드_인자없는_인스턴스참조(){
        User user = new User("김길동",12);
        Supplier<String> function= user::getName;
        System.out.println(function.get());
    }
}
