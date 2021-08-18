package swea.sw1959;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int T= Integer.valueOf(sc.nextLine());//테스트케이스 수
        int[] a=null;
        int[] b=null;
        int max=0;

        for(int i=0;i<T;i++) {
            //n m 입력받기

            int n = sc.nextInt();
            int m = sc.nextInt();
            int abs = Math.abs(n - m);
            int[] result = null;
            int temp = 0;
            max = 0;

            a=new int[n];
            b=new int[m];
            //배열 입력받기
            //a
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }

            if (n == m) {
                //case1. a와 b배열 크기가 같은 경우
                //그냥 계산
                for (int j = 0; j < n; j++) {
                    max += a[j] * b[j];
                }
            } else if (n > m) {
                //case 2. b길이가 더 짧은 경우
                //0~abs가 a의 시작위치
                result = new int[abs+1];
                for (int j = 0; j <= abs; j++) {
                    temp=0;
                    for (int k = 0; k < m; k++) {
                        temp += a[j+k] * b[k];
                    }
                    result[j] = temp;
                    max = Math.max(max, result[j]);
                }

            } else {
                //case3: a길이가 더 짧은 경우
                result = new int[abs+1];
                for (int j = 0; j <= abs; j++) {
                    temp=0;
                    for (int k = 0; k < n; k++) {
                        temp += a[k] * b[j+k];
                    }
                    result[j] = temp;
                    max = Math.max(max, result[j]);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i + 1).append(" ").append(max);
            System.out.println(sb);
        }
    }
}
