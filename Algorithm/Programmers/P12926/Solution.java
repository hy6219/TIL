package programmers.P12926;

public class Solution {

    public static String solution(String s, int n) {
        String answer = "";
        char[] arr=s.toCharArray();//배열로 관리하기 위함

        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            int temp=0;
            //공백이면 그냥 공백
            if(arr[i]==' '){
                arr[i]=' ';
            }else if(arr[i]>='a' && arr[i]<='z'){
                //소문자인 경우
                temp=(int)arr[i]+n;
                if(temp>=97 && temp<=122){
                    //소문자 범위에 있다면 그대로
                    arr[i]=(char)temp;
                }else{
                    arr[i]=(char)(temp-26);//그 구간 갯수만큼
                }
            }else{
                //대문자의 경우
                temp=(int)arr[i]+n;
                if(temp>=65 && temp<=90){
                    //소문자 범위에 있다면 그대로
                    arr[i]=(char)temp;
                }else{
                    arr[i]=(char)(temp-26);//그 구간 갯수만큼
                }
            }
        }

        //char->string
        for(int i=0;i<arr.length;i++){
            answer+=arr[i];
        }

        return answer;
    }

    public static void main(String[] args){
     //   System.out.println((int)'a');//97
       // System.out.println((int)'A');//65

        System.out.println(solution("AB",1));
        System.out.println(solution("z",1));
        System.out.println(solution("a B z",4));
    }
}
