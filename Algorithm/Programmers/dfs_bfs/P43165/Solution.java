package programmers.P43165;

public class Solution {

    public static int dfs(int[] numbers,int order,int sum,int target){
        //만약 다 순회했다면
        if(order==numbers.length){
            //누적합이 target과 같은 경우
            if(sum==target){
                return 1;
            }
            return 0;
        }
        //왼쪽과 오른쪽으로 나누어서 진행되는 것같은 양상
        return dfs(numbers,order+1,sum+numbers[order],target)+
                dfs(numbers,order+1,sum-numbers[order],target);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer=dfs(numbers,0,0,target);
        return answer;
    }

    public static void main(String[] args){
        int ans=solution(new int[]{1, 1, 1, 1, 1},3);

        System.out.println(ans);
    }
}
