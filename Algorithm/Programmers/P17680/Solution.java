package programmers.P17680;

import java.util.Deque;
import java.util.LinkedList;

//LRU알고리즘
public class Solution {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> queue=new LinkedList<>();
        final int hit=1;
        final int miss=5;

        if(cacheSize==0){
            return cities.length*5;//넣을 수도 없는 경우라 miss와 같은 상황
        }

        for(int i=0; i< cities.length;i++){

           String city=cities[i].toUpperCase();

           //cache hit-기존페이지 지우고 새 페이지 삽입
            if(queue.remove(city)){
                //맨앞에 새페이지 삽입
                queue.addFirst(city);
                answer+=hit;
            }else{
                //cache miss
                //1.캐시가 가득찬 경우
                //가장 먼저 들어온==가장 오래된==가장 뒤의 데이터 삭제
                if(queue.size()==cacheSize){
                    queue.pollLast();
                }
                //가장 앞에 새 페이지 삽입-->queue.size!=cacheSize도 해당됨
                queue.addFirst(city);
                answer+=miss;

            }

        }




        return answer;
    }

    public static void main(String[] args){
        String[] c1={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(3,c1));
    }
}
