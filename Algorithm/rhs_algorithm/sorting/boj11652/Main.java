package rhs_algo.sort.boj11652;

import java.io.*;
import java.util.*;

public class Main {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
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
            return Integer.valueOf(next());
        }

        Long nextLong(){
            return Long.valueOf(next());
        }

        Double nextDouble(){
            return Double.valueOf(next());
        }

    }

    static FastReader r= new FastReader();
    static int N;
    //카드값-등장횟수
    static Map<Long,Integer> map=new HashMap<>();

    public static void input(){
        N=r.nextInt();
       for(int i=0;i<N;i++){
           //임시 키값(카드값)
           Long temp=r.nextLong();
           if(map.containsKey(temp)){
               //전에 등장한적있다면, value값을 찾아서 업그레이드
               map.put(temp,map.get(temp)+1);
           }else{
               //전에 등장한적 없다면 그저 put해주기
               map.put(temp,1);
           }
       }
    }

    public static Long pro(){
        //정렬 후 맨 처음에 있는 키값 반환시켜주기
        //value 내림차순 정렬 후 키 오름차순 정렬
        List<Map.Entry<Long,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                Long key1=o1.getKey();
                Long key2=o2.getKey();

                Integer val1=o1.getValue();
                Integer val2=o2.getValue();
                //value값이 같다면 key 기분 오름차순 정렬
                if(val1.equals(val2)){
                    return key1.compareTo(key2);
                }else{
                    return val2.compareTo(val1);
                }
            }
        });
      //  System.out.println("list: "+list);
        return list.get(0).getKey();//정렬 후 가장 앞에 있는 요소 가져오기
    }

    public static void main(String[] args){
        input();
        Long ans=pro();
        System.out.println(ans);
    }
}
