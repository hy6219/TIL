package programmers.P86051;

public class Solution2 {

    //더 깔끔한 풀이
    //0~9합=45에서 빼기
    public static int solution(int[] numbers){
        int answer=45;

        for(int i:numbers){
            answer-=i;
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
