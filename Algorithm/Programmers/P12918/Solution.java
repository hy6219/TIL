package programmers.P12918;

public class Solution {

    public static boolean solution(String s) {
        boolean answer = true;
        int size=s.length();

        if(size==4 || size==6){
            for(int i=0;i<size;i++){
                char c=s.charAt(i);
                if(!(c>='0' && c<='9')){
                    answer=false;
                    break;
                }
                if(c=='e'){
                    answer=false;
                    break;
                }
            }
        }else{
            return false;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

}
