package com.test01;

/**
 * 
 * @author gs813
 *두 개 뽑아서 더하기

 *
 *정수 배열 numbers가 주어집니다. 
 *numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 
 *더해서 만들 수 있는 모든 수를 배열에 
 *오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
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
			   * 인텍스에 값을 넣어 찾아가므로
			   * 최댓값을 cnt로 넘겨야 겠음
			   * 정렬 후 가장 큰 두값을 최대로 삼기!
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
	    	   * ==>4+3+2+1+0=0~(length-1) 합 크기 정도!(처음에는 
	    	   * 이렇게 해서 temp배열 크기를 잡으려 했지만 맨 위처럼
	    	   * 최대합크기+1이 가장 안정적이고 다른 테케에도
	    	   * 맞음!)
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
		 * input: 0~100 값-->최대 200
		 * 내 생각: 배열을 만들고 값에 해당되는 인덱스를 증가시키기
		 * 초기화는 1로!
		 * 2,1,3,4,1 입력
		 * 2,3,4,5,6,7 출력
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
