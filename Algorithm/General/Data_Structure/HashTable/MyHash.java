package com.dataStructure.hashTable;



public class MyHash {
    //슬롯 기반 해쉬테이블
    public Slot[] hashTable;
    public int size;
    public MyHash(int size){
        this.size = size;
        this.hashTable = new Slot[size*31];
    }

    class Slot{
        //복잡도를 낮추기 위해서 String을 이용
        String value;

        Slot(String value){
            this.value=value;
        }
    }
    public void setSize(int size){
        this.size=size;
    }
    public int getSize(){
        return size;
    }
    //간단한 해쉬함수-오버라이딩한 것이 아님! 원래의 hashCode는 인자를 받지 않음!
    //division 방식 이용
    public int hashCode(String key){
        return (int)(key.charAt(0))%size;
    }
    //데이터 저장
    public boolean saveData(String key, String value){
        Integer address = this.hashCode(key);
        //이미 슬롯이 만들어진 적이 있다면 값만 바꿔주기
        if(this.hashTable[address]!=null){
            this.hashTable[address].value=value;
        }else{
            //슬롯이 없다면
            //슬롯 객체 생성
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    //데이터 가져오기
    public String getData(String key){
        Integer address = this.hashCode(key);

        //해쉬값이 존재하는 경우
        if(this.hashTable[address]!=null){
            return this.hashTable[address].value;
        }else{
            //해쉬값이 존재하지 않은 경우 없으므로 return null
            return null;
        }
    }

}
