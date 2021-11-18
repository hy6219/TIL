package programmers.P43164;

import java.util.*;

public class Solution {

    static ArrayList<String> list=new ArrayList<>();
    static String route="";
    static boolean[] visit;

    public static String[] solution(String[][] tickets) {
        route="";
        for(int i=0;i< tickets.length;i++){
            visit=new boolean[tickets.length];
            //시작점
            String start=tickets[i][0];
            //도착점
            String dest=tickets[i][1];

            //시작점은 icn
            if(start.equals("ICN")){
                route=start+",";
                visit[i]=true;
                dfs(tickets,dest,1);
            }
        }
        //문자가 빠른 순으로 정렬
        Collections.sort(list);
        String[] answer=list.get(0).split(",");

        return answer;
    }

    //node: 방문한 노드갯수
    private static void dfs(String[][] tickets, String dest, int node) {
        route+=dest+",";//시작점(도착점) 넣어주기

        if(node==tickets.length){
            //다 방문한 경우
            list.add(route);
            return;
        }

        for(int cand=0;cand< tickets.length;cand++){
            String start=tickets[cand][0];
            String end=tickets[cand][1];

            //목적지가 이제는 시작점잉 되어서 연결됨
            if(start.equals(dest) && !visit[cand]){
                visit[cand]=true;//방문처리
                //dfs 순회
                dfs(tickets,end,node+1);//방문한 노드가 1개 증가!(<-방금 방문처리했음)
                visit[cand]=false;//원위치
                //경로도 원위치(3자리이므로)
                route=route.substring(0,route.length()-4);
            }

        }
    }


    public static void main(String[] args) {
        String[][] t1={{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] t2={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] r1=solution(t1);
        String[] r2=solution(t2);

        System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
//        String[][] t3= {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
//        String[][] t4={{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
//        String[][] t5={{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
//        String[][] t6={{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
//        String[][] t7={{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};

 //       String[] r3=solution(t3);
//        String[] r4=solution(t4);
//        String[] r5=solution(t5);
//        String[] r6=solution(t6);
//        String[] r7=solution(t7);

     //   System.out.println(Arrays.toString(r3));//["ICN", "B", "ICN", "A", "D", "A"]
        //  System.out.println(Arrays.toString(r4));//["ICN", "AAA", "ICN", "AAA", "ICN", "AAA"]
    //    System.out.println(Arrays.toString(r5));//["ICN", "COO", "ICN", "BOO", "DOO"]
       // System.out.println(Arrays.toString(r6));//["ICN", "SFO", "ICN", "SFO", "QRE"]
   //     System.out.println(Arrays.toString(r7));//["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
    }
}
