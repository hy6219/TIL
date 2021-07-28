package recursive.boj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int special(int n){
        if(n<=2){
            return n;
        }else if(n==3){
            return 4;
        }else{
            //f(n)=f(n-3)+f(n-2)+f(n-1)
            return special(n-3)+special(n-2)+special(n-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < T;i++){
            int temp = Integer.valueOf(br.readLine());
            int res = special(temp);
            System.out.println(res);
        }
    }
}
