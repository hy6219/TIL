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
	 * :from�� to ������ ������ ��ȯ [from, to]
	 */
	
	public static int getRand(int from, int to)
	{
		return new Random().nextInt(Math.abs(to-from)+1) + Math.min(from, to);
		//from~to������ ������ ��ȯ�ϴ� ���̱� ����!
	}
	/*
	 * 2)
	 * int[] fillRand(int[] arr, int from, int to)
	 * : �迭 arr�� from�� to ������ ����� ä���� ��ȯ
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
	 * 3) 2)�� �����ε�
	 * int[] fillRand(int[] arr, int[] data)
	 * :�迭 arr�� �迭 data�� �ִ� ���� �� ���Ƿ� ä���� ��ȯ
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
