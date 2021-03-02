package com.exception07;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author gs813
 *
 *
 *Multi-catch 문의 단점
 *-하나의 참조변수를 공유하기 때문에 값을 변경할 수 없다는 제약 존재
 *(참조변수 e=상수)
 *->instanceof 나 getClass.getSimpleName 등으로 처리가
 *가능하기는 하지만, 이러한 번거로움을 감수해내면서
 *catch블럭을 합치는 것은 거의 없을것!
 *합기는 것은 대부분 코드를 간단히 하기 위함!
 */
public class ExceptionEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * multi catch block
		 */
		System.out.println(1);
		System.out.println(2);
		Scanner sc=new Scanner(System.in);
		int val=0;
		try
		{
			System.out.println(3);
			//System.out.println(0/0);
			System.out.println("숫자 하나 입력");
			val=sc.nextInt();
			System.out.println(val);
			System.out.println(4);
		}
		catch(ArithmeticException | InputMismatchException e)
		{
			System.out.println(e.getClass().getSimpleName());
		}
	}

}
