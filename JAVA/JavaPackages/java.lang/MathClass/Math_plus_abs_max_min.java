package com.lang.math.methods;
import static java.lang.Math.*;
import static java.lang.System.*;
//import static java.lang.StrictMath.*;
/*
 * StrictMath:  � OS���� ����Ǿ �׻� ���� ������� ���� �� �ֵ��� �ۼ��Ȱ�
 */
public class Math_plus_abs_max_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static double abs(double)
		 * static float abs(float)
		 * static int abs(int)
		 * static long abs(long)
		 * ->���� ��ȯ
		 */
		out.println("abs�޼���: ����ȭ");
		out.printf("static double abs(-3.14): %5.2f\n",abs(-3.14));
		out.printf("static long abs(-10): %d\n",abs(-10));
		/*
		 * static double abs(-3.14):  3.14
static long abs(-10): 10
		 */
		
		/*
		 * static double/float/int/long max|min(double/float/int/long a , b)
		 * -max: �ִ�ã��
		 * -min: �ּڰ�ã��
		 */
		//Math �� �޼��� ���ɰ� ���������Ͽ����� ���� ���ϱ�
		
		/*
		 * ���
		 *  0���ϼ���, 0.001000 s�ϼ��� ����!
		 */
		//1.Math.max 
		//+printf�� println ���� �� �����ϱ�
		int[] arr = {3, 5, 2, 4 ,1};
		int maximum   = 0, i  = 0 , j = 0 ;
		double start= ((double)System.currentTimeMillis())/1000.0;
		double end  = 0;
		
		for(i = 0 ; i < arr.length ; i++)
		{
			//�� ������ maximum�� �����־��! �׷��� ������ ��� �Ѿ� �񱳸� ��
			maximum = max(maximum, arr[i]);
		}
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("�ҿ� �ð�(printf): %f s\n",(end - start));
//		
//		start = ((double)System.currentTimeMillis())/1000.0;
//		for(i = 0 ; i < arr.length - 1; i++)
//		{
//			maximum = max(arr[i], arr[i + 1]);
//		}
//		out.println("max(println): "+ maximum);
//		end = ((double)System.currentTimeMillis())/1000.0;
//		out.printf("�ҿ� �ð�(println): %f s\n",(end - start));
		
		
		out.println();
		
		//3.���� ����- ���׿����� �̿�
		start = ((double)System.currentTimeMillis())/1000.0;
		maximum = 0;
		for(i = 0 ; i < arr.length;i++)
		{
			maximum = getMax(maximum, arr[i]);
		}
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("�ҿ� �ð�(printf): %f s\n",(end - start));
		out.println();
		//2.��������
		
		start = ((double)System.currentTimeMillis())/1000.0;
		for(i = 0 ; i < arr.length - 1; i++)
		{
			//����<-swap
			for(j = i + 1; j < arr.length; j++)
			{

				swap(arr, i, j);
			}
		}
		
//		for(int k : arr)
//		{
//			out.print(k+" ");
//		}
//		out.println();
		//�� ������ ���� �ִ��̰���
		maximum = arr[arr.length - 1];
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("�ҿ� �ð�(printf): %f s\n",(end - start));
		
		out.println();
		out.println("now, min");
		int minimum = arr[arr.length - 1] ;
		for(int k : arr)
		{
			minimum = min(minimum, k);
		}
		out.println("minimum: "+minimum);
		
		out.println();
		out.println("now, review rint");
		out.println("rint(-4.6): "+rint(-4.6)+", rint(4.6): "+rint(4.6));//-5, 5 
		out.println("rint(-4.5): "+rint(-4.5)+", rint(4.5): "+rint(4.5));//-4, 4
		
		out.println();
		out.println("now, random()");
		/*
		 * static double random() - 0.0~1.0������ ������ double ��ȯ
		 */
		int r = (int)(random() * 100) + 1;//1~100 ����(��� ����) ������ �� ���Ƿ� ��ȯ
		out.println(r);
		
	}
	public static int getMax(int a, int b)
	{
		return (a > b)? a: b;//���� MathŬ������ ���� ����
	}
	public static void swap(int[] array, int idx1, int idx2)
	{
		//�ּҰ����� �ٲ��־�� �迭�� �ݿ���
		//->�������� ���İ���
//		if(a > b)
//		{
//			//�߸� ���ĵǾ��ִ� ��� ->b�� a �ڸ��� ���� ��
//			//		  a�ڸ�							b�ڸ�
//			b ^= a;// a								(b xor a)
//			a ^= b;//a xor (a xor b)				(b xor a)
//				   // (a xor a) xor b
//				  //  0 xor b
//				  //  b
//			b ^= a;//b								(b xor a) xor b(<-a)
//				   //b								b xor (b xor a)
//				   //								(b xor b) xor a
//				// 									0 xor a
//				//b									a
//			//xor swap algorithm
//		}
		
		if(array[idx1] > array[idx2])
		{
			array[idx2] ^= array[idx1];
			array[idx1] ^= array[idx2];
			array[idx2] ^= array[idx1];
		}
	}

}
