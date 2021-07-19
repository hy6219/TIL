package com.dataStructure.hashTable;

public class HashChaining {
    //슬롯 기반 해쉬테이블
    public Slot[] hashTable;
    private int size;
    public HashChaining(int size){
        this.hashTable = new Slot[size];
        this.size=size;
    }

    class Slot{
        //복잡도를 낮추기 위해서 String을 이용
        //내 키에 해당되는 것인지, 링크드리스트에 연결되는 것인지 확인하는
        //절차가 필요
        String key;
        String value;
        //링크드리스트에서 포인터값이 필요
        Slot next;


        Slot(String key,String value){
            this.key = key;
            this.value=value;
            this.next=null;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //간단한 해쉬함수-오버라이딩한 것이 아님! 원래의 hashCode는 인자를 받지 않음!
    //chaining 방식 이용
    public int hashCode(String key){
        return (int)(key.charAt(0))%size;
    }
    //데이터 저장
    public boolean saveData(String key, String value){
        Integer address = this.hashCode(key);
        //이미 슬롯이 만들어진 적이 있다면
        //링크드 리스트를 순회
        if(this.hashTable[address]!=null){
            //헤드부터 접근해서 링크드리스트로 이용해서 다음값 확인하기
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while(findSlot!=null){
                if(findSlot.key==key){
                    //내가 찾는 키에 해당
                    findSlot.value = value;//이미 있는 슬롯 중 해당 슬롯의
                    //값만 업데이트
                    return true;
                }
                prevSlot=findSlot;
                findSlot=findSlot.next;

            }
            prevSlot.next=new Slot(key,value);//순회해도 키와 일치하지 않는 경우는
            //찾는 슬롯 이전 슬롯과 이어주기

        }else{
            //슬롯이 없다면
            //슬롯 객체 생성
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    //데이터 가져오기
    public String getData(String key){
        Integer address = this.hashCode(key);

        //해쉬값이 존재하는 경우
        if(this.hashTable[address]!=null){
            Slot findSlot = this.hashTable[address];

            while(findSlot!=null){
                if(findSlot.key==key){
                    return findSlot.value;
                }
                findSlot = findSlot.next;
            }
            return null;//다 돌아도 없는 경우
        }else{
            //해쉬값이 존재하지 않은 경우 없으므로 return null
            return null;
        }
    }
}
