package com.dataStructure.hashTable;

public class HashChainingTest {
    public static void main(String[] args){

        HashChaining hash = new HashChaining(30);

        hash.saveData("John","010-1234-5678");
        hash.saveData("Chris","010-1234-5679");
        hash.saveData("Cindy","010-1111-2222");

        System.out.println("value of John:"+hash.getData("John"));//value of John:010-1234-5678
        System.out.println("value of Chris: " +hash.getData("Chris"));//value of Chris: 010-1234-5679
        System.out.println("value of Cindy: "+hash.getData("Cindy"));//value of Cindy: 010-1111-2222

        System.out.println("hashCode of John: "+hash.hashCode("John"));//hashCode of John: 14
        System.out.println("hashCode of Chris: "+hash.hashCode("Chris"));//hashCode of Chris: 7
        System.out.println("hashCode of Cindy: "+hash.hashCode("Cindy"));//hashCode of Cindy: 7

    }
}
