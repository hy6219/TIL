class Solution {
   
    static long[] dy;
    
    static void dp(int price, int count){
        dy=new long[count+1];
        //초기값
        dy[1]=price;
        
        //dp테이블 채우기
        for(int i=2;i<=count;i++){
            dy[i]=dy[i-1]+price*i;
        }
    }
    
    public long solution(int price, int money, int count) {
        long answer = -1;
        //dp 테이블 채우기 수행~
        dp(price, count);
        //모자라지 않으면 0
        long temp=dy[count];
        if(money>=temp){
            answer=0;
        }else{
            //모자른경우
            answer=temp-money;
        }
        return answer;
    }
}