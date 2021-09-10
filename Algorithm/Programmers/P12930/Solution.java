package programmers.P12930;


public class Solution {

    public static  String solution(String s) {
        String answer="";
        StringBuilder sb=new StringBuilder();
        String[] arr=s.split(" ");

        //먼저 대문자로 다 통일시킨 후 일괄 적용시키기
        s=s.toUpperCase();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                if(j%2==0){
                    sb.append(arr[i].toUpperCase().charAt(j));
                }else{
                    sb.append(arr[i].toLowerCase().charAt(j));

                }
            }
            if(i!=arr.length-1){
                sb.append(" ");
            }
        }
        //더 긴 공백이 있는 경우
        answer=sb.toString();

        if(s.length()>answer.length()){
            answer+=s.substring(answer.length());
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("try hello world"));
    }
}
