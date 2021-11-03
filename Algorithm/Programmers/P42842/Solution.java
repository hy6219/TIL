package programmers.P42842;

import java.util.Arrays;

public class Solution {
    /**
     * 가로,세로>=3이어야 한다는 것을 몇가지 trial을 통해 알 수 있음
     * 가장 접근하기 쉬운것은 brown! brown은 최외곽을 두르기만 하므로!
     * (가로+세로)=T=(brown+4)/2
     * <-brown=(가로+세로)*2-4(겹쳐지는 모서리)
     * 그리고 마지막 테케에서 확인할 수 있는것! (brown+yellow)==w*h일 필요가 있음
     *
     * 중복해서 뽑아도 되고 순서도 있음
     * 단 특정 조건을 붙여주어야!(>=3, 가로>=세로)
     * */
    static int[] selected=new int[2000001];
    static int w=0;
    static int h=0;

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //가로+세로 계산해두기
        int T=(brown+4)/2;

        for(int i:selected){
            i=-1;
        }

        rec_func(0,T,brown,yellow);

        answer[0]=w;
        answer[1]=h;

        return answer;
    }

    static void rec_func(int k,int sum,int brown,int yellow){
        if(k==2){
            int[] rec=new int[2];
            int j=0;
            for(int i=0;i< selected.length;i++){
                if(j==2) break;
                if(selected[i]>=3){
                    rec[j]=selected[i];
                    j++;
                }
            }
            if(rec[0]+rec[1]==sum && (yellow+brown)==(rec[0]*rec[1])){
                w=Math.max(rec[0],rec[1]);
                h=Math.min(rec[0],rec[1]);
            }

        }else{
            //가로, 세로 모두 3 이상
            for(int cand=3;cand<=5000;cand++){
                selected[k]=cand;
                rec_func(k+1,sum,brown,yellow);
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] res1=solution(10,2);
        int[] res2=solution(8,1);
        int[] res3=solution(24,24);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }
}
