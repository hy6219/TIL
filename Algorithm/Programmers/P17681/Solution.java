package programmers.P17681;

public class Solution {


    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //지도1
        int[][] map1=new int[n][n];
        //지도2
        int[][] map2=new int[n][n];

        for(int i=0; i<n;i++){
            //지도1
            Integer k=arr1[i];
            String  temp=Integer.toBinaryString(k);//각 행을 2진수 문자열로 변환

            //n보다 길이가 작으면 앞에 0추가
            while(temp.length()<n){
                temp="0".concat(temp);
            }

            //지도2
            Integer k2=arr2[i];
            String  temp2=Integer.toBinaryString(k2);//각 행을 2진수 문자열로 변환

            //n보다 길이가 작으면 앞에 0추가
            while(temp2.length()<n){
                temp2="0".concat(temp2);
            }

            for(int j=0; j<temp.length();j++){
                //charAt으로 저장
                //지도1
                int t=temp.charAt(j)-'0';
                map1[i][j]=t;

                //지도2
                t=temp2.charAt(j)-'0';
                map2[i][j]=t;
            }
        }
        //지도1, 지도2 2차원 배열화 성공
    //    System.out.println("지도1: "+Arrays.deepToString(map1));
     //   System.out.println("지도2: "+Arrays.deepToString(map2));

        StringBuilder sb=null;
        for(int i=0; i<n;i++){
            sb=new StringBuilder();
            for(int j=0; j<n;j++){
                //하나라도 벽인 경우
                if(map1[i][j]==1 || map2[i][j]==1){
                    sb.append("#");
                }

                if(map1[i][j]==0 && map2[i][j]==0){
                    //둘다 공백인 경우
                    sb.append(" ");
                }
            }
            answer[i]=sb.toString();//한줄씩 추가
        }
     //   System.out.println("확인 : "+Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args){
        int n1=5;
        int[] arr1={9, 20, 28, 18, 11};
        int[] arr2={30, 1, 21, 17, 28};

        int n2=6;
        int[] arr3={46, 33, 33 ,22, 31, 50};
        int[] arr4={27 ,56, 19, 14, 14, 10};

        System.out.println(solution(n1,arr1,arr2));
    }
}
