package programmers.P12917;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        //s를 배열로 만들기
        Character[] arr=new Character[s.length()];

        if(s.length()==1){
            return s;
        }

        for(int i=0; i<arr.length;i++){
            arr[i]=s.charAt(i);
        }

        //정렬
        Collections.sort(Arrays.asList(arr),Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            answer.append(arr[i]);
        }

        return answer.toString();
    }

    public static void main(String[] args){
        System.out.println(solution("Zbcdefg"));
        System.out.println(solution("aBc"));
    }

}
