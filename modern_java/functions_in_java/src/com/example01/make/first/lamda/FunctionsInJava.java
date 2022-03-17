package com.example01.make.first.lamda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

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
}
