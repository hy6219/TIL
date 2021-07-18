package com.dataStructure.hashTable;

public class HashMain {
    public static void main(String[] args){

        MyHash hash = new MyHash(30);

        hash.saveData("John","010-1234-5678");
        hash.saveData("Chris","010-1234-5679");

        System.out.println("value of John:"+hash.getData("John"));//value of John:010-1234-5678
        System.out.println("value of Chris: " +hash.getData("Chris"));//value of Chris: 010-1234-5679

        System.out.println("hashCode of John: "+hash.hashCode("John"));//hashCode of John: 14
        System.out.println("hashCode of Chris: "+hash.hashCode("Chris"));//hashCode of Chris: 7

        System.out.println("===");
        System.out.println("re save of John & Chris");
        //값만 바뀔것
        hash.saveData("John","010-1234-1234");
        hash.saveData("Chris","010-1234-5555");

        System.out.println("value of John:"+hash.getData("John"));//value of John:010-1234-1234
        System.out.println("value of Chris: " +hash.getData("Chris"));//value of Chris: 010-1234-5555


        System.out.println("hashCode of John: "+hash.hashCode("John"));//hashCode of John: 14
        System.out.println("hashCode of Chris: "+hash.hashCode("Chris"));//hashCode of Chris: 7
    }
}
