package programmers.P42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * progresses,speeds로 끝나는 일자를 미리 계산해서 객체로 만들고
     * 큐로 관리해서 앞의 것을 하나 뺀 후에 그 끝나는 일자를 저장해두고
     * 그 일자 <= 그 다음일자 이면 계속 poll해주기
     * */

    static class Document{
        int progress;
        int speed;
        int finDay;

        public Document(int progress, int speed, int finDay) {
            this.progress = progress;
            this.speed = speed;
            this.finDay = finDay;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    ", finDay=" + finDay +
                    '}';
        }
    }

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Document> queue=new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int rev=0;//남은 양
            rev=100-progresses[i];
            rev=(int)Math.ceil((double)rev/speeds[i]);
            queue.add(new Document(progresses[i],speeds[i],rev));
        }


        Document first=queue.poll();
        int fin=first.finDay;//끝나는 일자 저장
        int cnt=1;
        while(!queue.isEmpty()){
            Document cur=queue.poll();
            int curDay=cur.finDay;

            if(fin>=curDay){
                cnt++;
            }else{
                answer.add(cnt);
                cnt=1;
                fin=curDay;
            }
        }
        //마지막
        answer.add(cnt);

        return answer;
    }

    public static void main(String[] args) {
        int[] p1={93, 30, 55};
        int[] s1={1, 30, 5};
        int[] p2={95, 90, 99, 99, 80, 99};
        int[] s2={1, 1, 1, 1, 1, 1};

        ArrayList<Integer> list1=solution(p1,s1);
        ArrayList<Integer> list2=solution(p2,s2);

        System.out.println(list1);
        System.out.println(list2);
    }
}
