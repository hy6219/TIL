package com.util.random;
import java.util.Random;

public class RandomEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		for(i = 0 ; i < 10; i++)
		{
			System.out.print(getRand(5,10)+" ");//5 10 7 8 7 9 5 7 10 5 
		}
	}
	/*
	 * 1)
	 * int getRand(int from, int to)
	 * :from과 to 범위의 정수값 반환 [from, to]
	 */
	
	public static int getRand(int from, int to)
	{
		return new Random().nextInt(Math.abs(to-from)+1) + Math.min(from, to);
		//from~to사이의 난수를 반환하는 것이기 때문!
	}
	/*
	 * 2)
	 * int[] fillRand(int[] arr, int from, int to)
	 * : 배열 arr을 from과 to 범위의 값들로 채워서 반환
	 * 
	 */
	public int[] fillRand(int[] arr, int from, int to)
	{
		int i = 0 ;
		for( i = 0 ; i < arr.length; i++)
		{
			arr[i] = getRand(from, to);
		}
		return arr;
	}
	/*
	 * 3) 2)를 오버로딩
	 * int[] fillRand(int[] arr, int[] data)
	 * :배열 arr을 배열 data에 있는 값들 중 임의로 채워서 반환
	 */
	public int[] fillRand(int[] arr, int[] data)
	{
		int i = 0 ;
		for( i = 0 ; i < arr.length; i++)
		{
			arr[i] = data[getRand(0,data.length -1)];
		}
		return arr;
	}
}
