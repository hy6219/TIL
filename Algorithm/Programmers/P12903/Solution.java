package programmers.P12903;

public class Solution {

    public static String solution(String s) {
        String answer = "";
        int size=s.length();
        int mid=size/2;
        //길이가 짝수이면 [길이/2-1,길이/2]
        if(size%2==0){
            answer=s.substring(mid-1,mid+1);
        }else{
            //길이가 홀수면 길이/2위치의 값을 리턴
            answer=s.substring(mid,mid+1);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

}
