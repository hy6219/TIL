package programmers.P12921;

public class Solution {
/*
* 에라토스테네스의 체 알고리즘
* -1부터 n까지를 모두 배열에 넣기
* -2부터 시작해서 그 배수에 해당되는 숫자들을 모두 제거(자기자신(x의 배수에서 x)은 지우지 않음)
* -다 제거하고 남은 것이 소수!
*
* */

    public static int solution(int n) {
        int answer =0;
        int[] numbers=new int[n+1];
        //1부터 n까지를 모두 배열에 담기
        for(int i=2;i<=n;i++){
            numbers[i]=i;
        }

        //자기자신 외에 배수는 제거
        for(int i=2;i<=n;i++){
            //값이 0인 경우는 제외
            if(numbers[i]==0) continue;

            //자기자신은 x*1이므로 x*2부터 시작
            for(int j=2*i;j<=n;j+=i){
                numbers[j]=0;//제외
            }
        }

        //0이 아닌 경우를 카운트
        for(int i=0;i< numbers.length;i++){
            if(numbers[i]!=0){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(10));
        System.out.println(solution(5));
    }
}
