package com.dataStructure.hashTable;

public class HashLinearProbing {
    //슬롯 기반 해쉬테이블
    public Slot[] hashTable;
    private int size;
    public HashLinearProbing(int size){
        this.hashTable = new Slot[size];
        this.size=size;
    }

    class Slot{
        //복잡도를 낮추기 위해서 String을 이용
        //내 키가 저장되어있다는 보장은 없기 때문에
        //데이터가 해당 키에 매칭되는지 확인할 필요가 있음

        String key;
        String value;


        Slot(String key,String value){
            this.key = key;
            this.value=value;

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
        if(this.hashTable[address]!=null){
          //현재 해쉬테이블의 주소값에 있는 키를 비교
            if(this.hashTable[address].key==key){
                this.hashTable[address].value=value;//값만 업데이트
                return true;
            }else{
                //한칸씩 뒤로 옮기기
                Integer curAddr = address + 1;
                while(this.hashTable[curAddr]!=null){
                    //빈공간을 찾아 나서서 옮길 것!
                    if(this.hashTable[curAddr].key==key){
                        this.hashTable[curAddr].value=value;//값 업데이트
                        return true;
                    }
                    //다음슬롯으로 이동
                    curAddr++;
                    //주소가 맨 끝일 경우 처리
                    if(curAddr >=this.hashTable.length){
                        return false;
                    }
                }
                //주소에 해당되는 슬롯이 없는 경우
                //새로운 슬롯을 만들어줌
                this.hashTable[curAddr]= new Slot(key,value);
                return true;
            }

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
            //내가 찾는 키인지 먼저 확인
            if(this.hashTable[address].key==key){
                return this.hashTable[address].value;
            }else{
                //다음슬롯으로 넘어가서 빈공간이 없는 한,
                //데이터 확인
                Integer curAddr = address+1;

                while(this.hashTable[curAddr]!=null){
                    if(this.hashTable[curAddr].key==key){
                        return this.hashTable[curAddr].value;
                    }else{
                        curAddr++;
                        if(curAddr >= this.hashTable.length){
                            return null;//끝까지 간 상황
                        }
                    }
                }
                //해당 데이터가 없는 경우
                return null;
            }
        }else{
            //해쉬값이 존재하지 않은 경우 없으므로 return null
            return null;
        }
    }
}
