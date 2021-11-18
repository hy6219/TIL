package programmers.P43163;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    static int min=Integer.MAX_VALUE;
    static boolean[] visit;

    static class Point{
        int idx;
        int depth;

        public Point(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "idx=" + idx +
                    ", depth=" + depth +
                    '}';
        }
    }

    //한글자 차이만 나는지 확인
    static boolean isAccessible(String cur,String next){
        int cnt=0;

        for(int i=0;i<next.length();i++){
            if(cur.charAt(i)!=next.charAt(i)){
                cnt++;
            }
        }

        return cnt==1;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        /**
         * 연결->그래프!!
         * */
        //만약 target이 words에 들어있지 않다면 0을 바로 반환!
        boolean first=false;
        //target 인덱스
        int idx=0;

        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                first=true;
            }
        }

        if(!first) return 0;

        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                idx=i;
                break;
            }
        }

        for(int i=0;i< words.length;i++){
            if(isAccessible(begin,words[i])){
                visit=new boolean[words.length];
                visit[i]=true;
                bfs(i,words,idx);
            }
        }

        answer=min;
        return answer;
    }


    static void bfs(int index,String[] words,int targetIdx){
        Queue<Point> queue=new LinkedList<>();

        //시작점 넣고 방문처리
        queue.add(new Point(index,1));
        visit[index]=true;

        while(!queue.isEmpty()){
            //하나 꺼내기
            Point temp=queue.poll();

            if(words[temp.idx].equals(words[targetIdx])){
                min=Math.min(min,temp.depth);
                return;
            }
            //연결된 곳으로 이동해서 한글자 차이가 나면 진행
            for(int i=0;i< words.length;i++){
                if(!visit[i] && isAccessible(words[temp.idx],words[i])){
                    visit[i]=true;
                    queue.add(new Point(i,temp.depth+1));
                }
            }
        }

    }

    public static void main(String[] args) {
        String[] w1={"hot", "dot", "dog", "lot", "log", "cog"};
        String[] w2={"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution("hit","cog",w1));
        System.out.println(solution("hit","cog",w2));
    }
}
