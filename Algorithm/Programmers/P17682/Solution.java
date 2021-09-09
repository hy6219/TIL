package programmers.P17682;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static int solution(String dartResult) {
        int answer = 0;

        //정규식으로 자르기
        //10때문에
        //?는 없을 수도 있다는 것
        Pattern pattern=Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher= pattern.matcher(dartResult);
        //Matcher.group으로 해당 라운드마다 잘라오기
        //일찍 들어온 값을 저장해뒀다가 나중에 꺼내봐야 함
        Stack<Integer> stack=new Stack<>();
        while(matcher.find()){
            int tmp=Integer.parseInt(matcher.group(1));

            //보너스
            switch (matcher.group(2)){
                //S는 1제곱이므로 무시
                case "D":
                    tmp*=tmp;
                    break;
                case "T":
                    tmp*=(tmp*tmp);
                    break;
            }
            //옵션
            switch (matcher.group(3)){
                case "*":
                    //스택이 채워져 있다면 이전값을 pop해서 *2를 푸쉬(스타상은 이전값을 활용해야하기 때문에 pop 필요)
                    if(!stack.isEmpty()){
                        stack.push(stack.pop()*2);
                    }
                    tmp*=2;
                    break;
                case "#":
                    tmp*=(-1);
                    break;
            }
            stack.push(tmp);
        }

        //스택에서 하나씩 꺼내서 answer에 누적합하기
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }

    public static void main(String[] args){
        String str1="1S2D*3T";
        System.out.println(solution(str1));
    }
}
