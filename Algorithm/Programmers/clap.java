package com.test3;

//���ڼ��ڼ��ڼ��ڼ��ڼ�?
/**
 * 
 * @author gs813
 *
 *Ȧ�� �ε���->��, ¦�� �ε���->��
 */
class Solution {
    public String solution(int n) {
        String answer="��";
        
        int i=1;
        while(i<n)
        {
        	if(i%2==0)
        	{
        		answer+="��";
        	}
        	else
        	{
        		answer+="��";
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
