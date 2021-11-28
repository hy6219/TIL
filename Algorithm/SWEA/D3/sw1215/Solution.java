package swea.sw1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine(){
            String str="";

            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }

    static FastReader scan=new FastReader();
    static int len;
    static char[][] arr;
    static char[] record;

    static void input(){
        len=scan.nextInt();
        arr=new char[8][8];
        record=new char[8];
        String str=null;

        for(int i=0;i<8;i++){
            str=scan.nextLine();
            for(int j=0;j<8;j++){
                arr[i][j]=str.charAt(j);
            }
        }
    }

    //완전탐색
    static int makeStrAndCheck(){
        int cnt=0;
       //가로 방향

        for(int i=0;i<arr.length;i++){
            String str="";
            for(int j=0;j<=arr[i].length-len;j++){
                boolean flag=false;

                for(int k=j;k<j+len;k++){
                    str+=arr[i][k];
                }

                flag=isPalindrome(str);

                if(flag) cnt++;
                str="";
            }
        }

        //세로 방향
        for(int i=0;i<arr.length;i++){
            String str="";
            for(int j=0;j<=arr[i].length-len;j++){
                boolean flag=false;
                for(int k=j;k<j+len;k++){
                    str+=arr[k][i];
                }
                flag=isPalindrome(str);

                if(flag) cnt++;

                str="";
            }
        }

        return cnt;
    }

    //회문이 맞는지 확인
    static boolean isPalindrome(String s){
        String reverse="";

        for(int i=0;i<s.length();i++){
            reverse+=s.charAt(s.length()-1-i);
        }

        return s.equals(reverse);
    }

    static void pro(){
        int ans=0;
        for(int i=1;i<=10;i++){
            input();
            ans=makeStrAndCheck();
            System.out.println("#"+i+" "+ans);
        }
    }

    public static void main(String[] args) {
        pro();
    }
}
