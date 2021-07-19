package com.dataStructure.hashTable;

public class OptimalHashTable {
    class Slot{
        String key;
        String value;
        Slot(String key, String value){
                this.key=key;
                this.value=value;
        }

    }
    public Slot[] hashTable;

    public int size;

    public OptimalHashTable(int size){
        this.size= Character.MAX_VALUE-1;
        this.hashTable=new Slot[this.size];
    }


    public void setSize(int size){
        this.size=Character.MAX_VALUE-1;
    }

    public int getSize(){
        return size;
    }

    //해쉬함수
    public int hashCode(String key){
        int hash= 0;
        for(int i = 0 ; i < key.length(); i++){
            hash+=31*key.charAt(i);
        }

        return hash;
    }

    //데이터 저장
    public boolean saveData(String key, String value){
        /*
        * 키값에 대한 해쉬함수 결과값을 이용해서
        * 존재했다면 값을 업데이트
        * 아니라면 새로 생성
        * */
        Integer address = this.hashCode(key);

        if(this.hashTable[address]!=null){
            this.hashTable[address].value=value;
        }else{
            this.hashTable[address]=new Slot(key,value);
        }
        return true;
    }
    //데이터 꺼내기
    public String getData(String key){
        Integer address = this.hashCode(key);

        if(this.hashTable[address]!=null){
            return this.hashTable[address].value;
        }else{
            return null;
        }
    }

}
