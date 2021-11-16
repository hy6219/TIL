package programmers.P42584;

import java.util.Arrays;


public class Solution {
    /**
     * 먼저 들어간 시간대부터 비교->큐
     * 그런데 굳이 큐로 접근하지 않아도 될 듯
     * */
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i< prices.length-1;i++){
            int target=prices[i];
            int time=0;
            for(int j=i+1;j< prices.length;j++){
                time++;

                if(target>prices[j]){
                    break;
                }
            }

            answer[i]=time;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 3, 2, 3};
        int[] res=solution(arr);
        System.out.println(Arrays.toString(res));
    }
}
