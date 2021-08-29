package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Coin {

    //금액과 코인 종류를 넣기
    public static int best(int price, ArrayList<Integer> coinList){
        //최종 동전 갯수
        Integer total=0;
        //각각의 동전이 지불 금액을 맞출 때의 갯수
        Integer coinNum=0;
        //실제 동작
        ArrayList<Integer> details=new ArrayList<>();

        //내림차순 정렬
        Collections.sort(coinList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }
                return -1;
            }
        });
        for(int idx=0; idx<coinList.size();idx++){
            coinNum=price/coinList.get(idx);
            total+=coinNum;
            //다음에 타깃이 될 금액이 변동됨
            price-=coinNum*coinList.get(idx);
            System.out.println(coinList.get(idx)+"원 갯수: "+coinNum+" 개");
        }


        return total;
    }


    public static void main(String[] args){

        ArrayList<Integer> coins=new ArrayList<>(Arrays.asList(1,50,100,500));
        System.out.println("동전 종류: "+coins);

        int totalCnt=best(4720,coins);
        System.out.println("최적 갯수: "+totalCnt+" 개");

    }
}
