package com.test01;

/**
 * 
 * @author gs813
 *
 *
 *���� �迭 numbers�� �־����ϴ�. 
 *numbers���� ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� 
 *���ؼ� ���� �� �ִ� ��� ���� �迭�� 
 *������������ ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 */
class  solution
{
	public int[] solution(int[] numbers) 
	 {
		  int s=0;
		  int max=0;
		  int a=0;
		  
		  for(int i=0;i<numbers.length-1;i++)
		  {
			  /*
			   * ���ؽ��� ���� �־� ã�ư��Ƿ�
			   * �ִ��� cnt�� �Ѱܾ� ����
			   * ���� �� ���� ū �ΰ��� �ִ�� ���!
			   */
			  //a=numbers[i];
			  for(int j=i+1;j<numbers.length;j++)
			  {
				if(numbers[i]>numbers[j])
				{
					a=numbers[j];
					numbers[j]=numbers[i];
					numbers[i]=a;
				}
			  }
		  }
		  max=numbers[numbers.length-1]+numbers[numbers.length-2]+1;

	      int[] temp =new int[max];
	      //initializing
	      for(int i=0;i<max;i++)
	      {
	    	  temp[i]=1;
	      }
	      for(int i=0;i<numbers.length-1;i++)
	      {
	    	  for(int j=i+1;j<numbers.length;j++)
	    	  {
	    		  temp[numbers[i]+numbers[j]]++; 
	    	  }
	    	  /*
	    	   * index[0,1,2,3,4]
	    	   * --> 0+1, 0+2, 0+3, 0+4
	    	   * 1+2, 1+3, 1+4
	    	   * 2+3, 2+4
	    	   * 3+4
	    	   * 
	    	   * ==>4+3+2+1+0=0~(length-1) �� ũ�� ����!(ó������ 
	    	   * �̷��� �ؼ� temp�迭 ũ�⸦ ������ ������ �� ��ó��
	    	   * �ִ���ũ��+1�� ���� �������̰� �ٸ� ���ɿ���
	    	   * ����!)
	    	   */
	    	  
	      }
	      for(int i=0;i<max;i++)
	      {
	    	  if(temp[i]>=2)
	    	  {
	    		  s++;
	    	  }
	      }
	      int[] answer=new int[s];
	      int j=0;
	      for(int i=0;i<max;i++)
	      {
	    	  if(temp[i]>=2 && j<s)
	    	  {
	    		  answer[j]=i;
	    		  j++;
	    	  }
	      }
	      return answer;
    }
}
public class twoSum {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * input: 0~100 ��-->�ִ� 200
		 * �� ����: �迭�� ����� ���� �ش�Ǵ� �ε����� ������Ű��
		 * �ʱ�ȭ�� 1��!
		 * 2,1,3,4,1 �Է�
		 * 2,3,4,5,6,7 ���
		 */
		solution s=new solution();
		int[] numbers= {2,1,3,4,1};
		int[] res=s.solution(numbers);
		for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i]+" ");
		}
		System.out.println();
	}

}
