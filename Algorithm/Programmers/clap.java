package com.test3;

//熱夢熱夢熱夢熱夢熱夢熱?
/**
 * 
 * @author gs813
 *
 *�汝� 檣策蝶->夢, 礎熱 檣策蝶->熱
 */
class Solution {
    public String solution(int n) {
        String answer="熱";
        
        int i=1;
        while(i<n)
        {
        	if(i%2==0)
        	{
        		answer+="熱";
        	}
        	else
        	{
        		answer+="夢";
        	}
        	i++;
        }
        return answer;
    }
}

public class clap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String str=s.solution(4);
		System.out.println(str);
	}

}
