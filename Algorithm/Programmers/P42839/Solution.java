package programmers.P42839;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 중복없이 뽑는 완탐
     * 순서도 있게 뽑기!
     * */
    //소수 저장하기
    static Set<Integer> set;
    //기록
    static int[] selected=new int[10001];
    static int[] used=new int[10001];
    public static int solution(String numbers) {
        int answer = 0;
        set=new HashSet<>();
        //먼저 카드를 split해줘야 함
        int[] cards=new int[numbers.length()];
        for(int i=0;i<cards.length;i++){
            cards[i]=numbers.charAt(i)-'0';
        }
        for(int i:selected){
            i=-1;
        }
        for(int i:used){
            i=0;
        }
        //완전탐색
        //1개부터 시작해서 numbers.length까지 limit을 늘려가면서 찾아보기
        for(int i=1;i<=numbers.length();i++){
            rec_func(cards,0,i);
        }

        answer=set.size();
        return answer;
    }

    static boolean isSosu(int num){
        if(num<=1) return false;
        int limit=(int)Math.sqrt(num);//에라토스테네스의 체
        for(int i=2;i<=limit;i++){
            if(num%i==0) return false;
        }
        return true;
    }

    static void rec_func(int[] cards,int k, int limit){
        if(k==limit){
            //다 찾아본 경우
            //selected에 기록된 값을 합쳐서 소수인지 판정하고 list에 추가하기
            String temp="";
            for(int i=0;i<selected.length;i++){
                if(selected[i]==-1) continue;
                if(temp.length()==limit) break;
                temp+=String.valueOf(selected[i]);
            }

            //앞에 01 02 이런식으로 붙은 0 제거하기
            String t="";
            int j=0;
            while(j<temp.length() && temp.charAt(j)=='0'){
                t+='0';
                j++;
            }
            temp.replaceFirst(t,"");

            //소수판별 후 set에 추가
            int val=Integer.valueOf(temp);
            boolean flag=isSosu(val);

            if(flag){
                set.add(val);
            }

        }else{
            for(int cand=0;cand<cards.length;cand++){
                if(used[cand]==1) continue;
                selected[k]=cards[cand]; used[cand]=1;
                rec_func(cards,k+1,limit);
                selected[k]=-1; used[cand]=0;
            }
        }
    }

    public static void main(String[] args) {
        int res1=solution("17");
        int res2=solution("011");
        System.out.println(res1);
        System.out.println(res2);
    }
}
