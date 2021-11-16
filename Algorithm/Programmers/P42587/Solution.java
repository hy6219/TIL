package programmers.P42587;

import java.util.PriorityQueue;

public class Solution {
    /**
     가장 앞에 있는 문서가 먼저 처리됨->큐, 그중에서도 가중치의미가 있는
     우선순위큐를 활용할 것
     */
    static class Pair implements Comparable<Pair>{
        int idx;
        int ord;

        public Pair(int idx,int ord){
            this.idx=idx;
            this.ord=ord;
        }


        @Override
        public int compareTo(Pair o) {
            if(ord>o.ord){
                return -1;
            }

            return 1;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "idx=" + idx +
                    ", ord=" + ord +
                    '}';
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        //pair쌍을 만들어주기
        for(int i=0;i< priorities.length;i++){
            pq.add(new Pair(i,priorities[i]));
        }

        //pq에서 idx가 loc과 같을 때를 알아보기

        while(!pq.isEmpty()){
            for(int i=0;i< priorities.length;i++){
                if(priorities[i]==pq.peek().ord){
                    if(location==i){
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr1={2, 1, 3, 2};
        int[] arr2={1, 1, 9, 1, 1, 1};

        int loc1=2; int loc2=0;

        int r1=solution(arr1,loc1);
        int r2=solution(arr2,loc2);

        System.out.println(r1);
        System.out.println(r2);
    }
}
