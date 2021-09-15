package baekjoon.boj21919;

import java.util.*;

public class Main {
    //최대공약수
    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }
    //최소공약수
    public static int lcm(int a,int b){
        int gcd=gcd(a,b);
        if(gcd==0){
            return -1;
        }else{
            return a*b/gcd;
        }
    }
    //소수 판별
    public static boolean isSosu(int n){
        if(n==1) return false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int line=s.nextInt();
        int gcd=0;
        int lcm=1;

        Set<Integer> input=new HashSet<>();

        for(int i=0;i<line;i++){
            int temp=s.nextInt();
            boolean flag=isSosu(temp);

            if(flag){
                input.add(temp);
            }
        }
  //      System.out.println("sosu: "+input);//소수 중복제거됨

        Iterator iterator= input.iterator();


        if(input.size()<=0){
            lcm=-1;
        }else{
            while(iterator.hasNext()){
                //gcd=gcd(gcd,(int)iterator.next());
                lcm=lcm(lcm,(int)iterator.next());
            }
        }

        System.out.print(lcm);

    }
}
