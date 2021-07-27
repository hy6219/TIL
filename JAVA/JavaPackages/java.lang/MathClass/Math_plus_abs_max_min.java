package com.lang.math.methods;
import static java.lang.Math.*;
import static java.lang.System.*;
//import static java.lang.StrictMath.*;
/*
 * StrictMath:  어떤 OS에서 실행되어도 항상 같은 계산결과가 나올 수 있도록 작성된것
 */
public class Math_plus_abs_max_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static double abs(double)
		 * static float abs(float)
		 * static int abs(int)
		 * static long abs(long)
		 * ->절댓값 반환
		 */
		out.println("abs메서드: 절댓값화");
		out.printf("static double abs(-3.14): %5.2f\n",abs(-3.14));
		out.printf("static long abs(-10): %d\n",abs(-10));
		/*
		 * static double abs(-3.14):  3.14
static long abs(-10): 10
		 */
		
		/*
		 * static double/float/int/long max|min(double/float/int/long a , b)
		 * -max: 최댓값찾기
		 * -min: 최솟값찾기
		 */
		//Math 내 메서드 성능과 직접구현하였을때 성능 비교하기
		
		/*
		 * 모두
		 *  0초일수도, 0.001000 s일수도 있음!
		 */
		//1.Math.max 
		//+printf와 println 성능 비교 공부하기
		int[] arr = {3, 5, 2, 4 ,1};
		int maximum   = 0, i  = 0 , j = 0 ;
		double start= ((double)System.currentTimeMillis())/1000.0;
		double end  = 0;
		
		for(i = 0 ; i < arr.length ; i++)
		{
			//그 이전의 maximum과 비교해주어야! 그렇지 않으면 계속 둘씩 비교만 함
			maximum = max(maximum, arr[i]);
		}
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("소요 시간(printf): %f s\n",(end - start));
//		
//		start = ((double)System.currentTimeMillis())/1000.0;
//		for(i = 0 ; i < arr.length - 1; i++)
//		{
//			maximum = max(arr[i], arr[i + 1]);
//		}
//		out.println("max(println): "+ maximum);
//		end = ((double)System.currentTimeMillis())/1000.0;
//		out.printf("소요 시간(println): %f s\n",(end - start));
		
		
		out.println();
		
		//3.직접 구현- 삼항연산자 이용
		start = ((double)System.currentTimeMillis())/1000.0;
		maximum = 0;
		for(i = 0 ; i < arr.length;i++)
		{
			maximum = getMax(maximum, arr[i]);
		}
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("소요 시간(printf): %f s\n",(end - start));
		out.println();
		//2.직접구현
		
		start = ((double)System.currentTimeMillis())/1000.0;
		for(i = 0 ; i < arr.length - 1; i++)
		{
			//정렬<-swap
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
		//맨 마지막 값이 최댓값이겠지
		maximum = arr[arr.length - 1];
		out.printf("max(printf): %d\n", maximum);
		end = ((double)System.currentTimeMillis())/1000.0;
		out.printf("소요 시간(printf): %f s\n",(end - start));
		
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
		 * static double random() - 0.0~1.0전까지 범위의 double 반환
		 */
		int r = (int)(random() * 100) + 1;//1~100 정수(모두 포함) 범위의 수 임의로 반환
		out.println(r);
		
	}
	public static int getMax(int a, int b)
	{
		return (a > b)? a: b;//실제 Math클래스와 내용 동일
	}
	public static void swap(int[] array, int idx1, int idx2)
	{
		//주소값으로 바꿔주어야 배열에 반영됨
		//->오름차순 정렬가정
//		if(a > b)
//		{
//			//잘못 정렬되어있는 경우 ->b가 a 자리로 가야 함
//			//		  a자리							b자리
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
