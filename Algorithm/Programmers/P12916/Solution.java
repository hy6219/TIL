package programmers.P12916;

import java.util.Locale;

public class Solution {
    //p와 y갯수가 같으면 true 아니라면 false
    public static boolean solution(String s) {

        int pCnt=0;
        int yCnt=0;

        //대->소문자로(대소문자 구분x)
        s=s.toLowerCase();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='p'){
                pCnt++;
            } else if (c == 'y') {
                yCnt++;
            }else{
                continue;
            }
        }

        if(pCnt==yCnt){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
