package programmers.P12928;

public class Solution {

    //약수 모두 더하기
    public static int solution(int n) {
        int answer = 0;
        int i=2;//iterator

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        //우선 1과 n은 처음부터 포함시키기
        answer+=(n+1);

        while(i<n){
            if(n%i==0){
                //약수라면
                answer+=i;
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(12));
        System.out.println(solution(5));
    }
}
