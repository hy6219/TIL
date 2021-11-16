package programmers.P42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 큐처럼 생각해서, 다음 peek과의 합이 weight 이하인지 확인해서 꺼내기
     * */
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que=new LinkedList<>();
        //무게합 검사
        int sum=0;
        //시간 체크
        int time=0;
        /**
         * 1. 다리 위에 어떤 트럭도 없는 경우->트럭을 일단 하나 올리고 시간도 올리고 무게도 올라감
         * 2. 큐에 다리 길이만큼 다 찬 경우-> 다리를 비워줘야 하므로, 하나를 빼서 무게합에서 제외해주기
         * 3. 다리 길이만큼 차지 않은 경우 ->
         * 3-1. 현재무게합+트럭무게<=무게 중량 한계 -> 올릴 트럭으로 등록
         * 3-2. 현재무게합+트럭무게>무게 중량 한계  -> 그냥 의미없이 0을 넣어서 트럭이 건너가도록 해주기
         * ->2케이스 외에는 시간 모두 증가
         * */

        for(int i=0; i< truck_weights.length;i++){
            int target=truck_weights[i];
            while(true){
                //1.
                if(que.isEmpty()){
                    que.add(target);
                    sum+=target;
                    time++;
                    break;
                }else if(que.size()==bridge_length){
                    //2
                    sum-=que.poll();
                }else{
                    //3-1
                    if(sum+target<=weight){
                        que.add(target);
                        time++;
                        sum+=target;
                        break;
                    }else{
                        //3-2
                        que.add(0);
                        time++;
                    }
                }
            }
        }
        //마지막 건널때에도 다리 길이만큼 건너야 함
        time=time+bridge_length;
        return time;
    }
    public static void main(String[] args) {
        int[] w1={7,4,5,6};
        int[] w2={10};
        int[] w3={10,10,10,10,10,10,10,10,10,10};

        int l1=2; int l2=100;
        int g1=10; int g2=100;

        int r1=solution(l1,g1,w1);
        int r2=solution(l2,g2,w2);
        int r3=solution(l2,g2,w3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}
