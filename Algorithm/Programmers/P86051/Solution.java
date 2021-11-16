package programmers.P86051;

public class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        /**
         *
         * "0123456789" char at에서 contains하는지 확인
         * */

        String s="0123456789";

        for(int i=0;i< numbers.length;i++){
            int n=numbers[i];
            String cur=String.valueOf(n);

            if(s.contains(cur)){
                //제거해주기
                int idx=s.indexOf(cur);
                s=s.substring(0,idx)+s.substring(idx+1);
            }
        }


        for(int i=0;i<s.length();i++){
            answer+=Integer.valueOf(s.charAt(i)-'0');
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] n1={1,2,3,4,6,7,8,0};
        int[] n2={5,8,4,0,6,7,9};

        int r1=solution(n1);
        int r2=solution(n2);

        System.out.println(r1);
        System.out.println("---");
        System.out.println(r2);
    }
}
