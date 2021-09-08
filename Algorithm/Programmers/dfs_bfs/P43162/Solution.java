package programmers.P43162;

public class Solution {

    public static boolean[] dfs(int[][] computers, int idx, boolean[] visited){
        //해당 인덱스(지금 지정된 시작 인덱스)방문 처리하기
        visited[idx]=true;

        //idx!=j(1->1로 가는 경우는 카운트 x), computers[idx][j]==1, visited[j]==false(방문x)
        for(int j=0; j< computers.length;j++){
            if(idx!=j && computers[idx][j]==1 && visited[j]==false){
                visited=dfs(computers,j,visited);
            }
        }
        return visited;
    }



    public static int solution(int n, int[][] computers) {
        int answer = 0;
        //방문확인 배열
        boolean[] visited=new boolean[n];

        //visited 초기화
        for(int i=0; i<n;i++){
            visited[i]=false;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                //방문확인되지 않은 경우 dfs
                dfs(computers,i,visited);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] arr={
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int[][] arr2={
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        //System.out.println(Arrays.deepToString(arr));
        int ans=solution(3,arr);
        System.out.println(ans);
    }
}
