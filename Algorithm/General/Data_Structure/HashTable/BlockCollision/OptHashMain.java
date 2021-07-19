package com.dataStructure.hashTable;

public class OptHashMain {

    public static void main(String[] args){
        OptimalHashTable myHash = new OptimalHashTable(30);

        myHash.saveData("Chris","010-1234-5678");
        myHash.saveData("Cindy","010-1111-2222");
        myHash.saveData("John","010-2222-3333");

        System.out.println("value of Chris: "+myHash.getData("Chris"));//value of Chris: 010-1234-5678
        System.out.println("value of Cindy: "+myHash.getData("Cindy"));//value of Cindy: 010-1111-2222
        System.out.println("value of John: "+myHash.getData("John"));//value of John: 010-2222-3333

        System.out.println("hashCode of Chris: "+myHash.hashCode("Chris"));//hashCode of Chris: 15655
        System.out.println("hashCode of Cindy: "+myHash.hashCode("Cindy"));//hashCode of Cindy: 15593
        System.out.println("hashCode of John: "+myHash.hashCode("John"));//hashCode of John: 12369
    }

}
