package baekjoon.boj21921;

import java.util.*;

public class Main {
    static long n,x;
    static long[] visitors=new long[250001];

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        n=s.nextLong();
        x=s.nextLong();

        //슬라이딩 윈도우
        long sum=0;
        for(int i=1;i<=n;i++){
            visitors[i]=s.nextLong();
            //첫번째 케이스 합 구하기
            if(i<=x) sum+=visitors[i];
        }
        long max=sum;//가장 큰합
        int cnt=1;//기간의 갯수

        //슬라이딩 윈도우 시작
        long left=1;
        long right=x;

        while(true){
            //윈도우를 한 칸 오른쪽으로 이동
            left++;
            right++;
            if(right>n){
                break;//오른쪽 포인터가 한계를 넘어가는 경우
            }
            //합을 계산하여 정답 갱신
            sum=sum+visitors[(int)right]-visitors[(int)left-1];
            if(max==sum){
                cnt++;
            }else if(max<sum){
                max=sum;//더 큰 합을 찾은 경우
                cnt=1;
            }
        }
        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
