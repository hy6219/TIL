package com.lang.method;
import static java.lang.Math.*;
import static java.lang.System.*;


public class trigonometrical_function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 삼각함수와 지수, 로그
		 */
		
		int x1 = 1, y1 = 1, x2 = 2, y2 = 2;
		
		/*
		 * double(double)
		 * 제곱근 계산
		 */
		out.println("지수함수-제곱근");
		out.println("=============================================================");
		out.println("Math.sqrt() : 제곱근");
		out.printf("4.5의 제곱근 Math.sqrt(%5.2f)= %5.2f\n", 4.5,sqrt(4.5));//double반환
		/*
		 * double(double)
		 * 2제곱근 이상: pow(a,1.0/n.0)
		 */
		out.println("Math.pow(val, 1.0/n.0) : n제곱근");
		
		out.printf("4.5자기자신 Math.pow(%5.2f, 1.0/1.0)= %5.2f\n", 4.5,pow(4.5,1.0/1.0));
		out.printf("4.5의 제곱근 Math.pow(%5.2f, 1.0/2.0)= %5.2f\n", 4.5,pow(4.5,1.0/2.0));
		out.printf("4.5의 3제곱근 Math.pow(%5.2f, 1.0/3.0)= %5.2f\n", 4.5,pow(4.5,1.0/3.0));
		out.printf("4.5의 4제곱근 Math.pow(%5.2f, 1.0/4.0)= %5.2f\n", 4.5,pow(4.5,1.0/4.0));
		out.printf("4.5의 5제곱근 Math.pow(%5.2f, 1.0/5.0)= %5.2f\n", 4.5,pow(4.5,1.0/5.0));
		/*
		 * Math.cbrt()-->세제곱근
		 */
		out.println("Math.cbrt() : 3제곱근");
		out.printf("4.5의 3제곱근 Math.cbrt(%5.2f)= %5.2f\n", 4.5,cbrt(4.5));
		
		
		out.println("Math.pow(val, n) : val^n");
		out.printf("4.5^2:  Math.pow(%5.2f, 2)= %5.2f\n", 4.5,pow(4.5,2));
		
		out.println("=============================================================");
		
		out.println("삼각함수");
		
		final double st = sqrt((pow(x2-x1, 2))+ pow(y2-y1,2));//(x1,y1)-(x2,y2)간 선분거리
		double a = st * sin(PI/4);//직각이등변 삼각형 만들려고 하는 것! 
		/*
		 * 			|
		 *        / |
		 *       /  |
		 *      /___| 중에서 밑변 말고 | 이부분!
		 */
		
		double under = st * cos(PI/4);
		/*
		 *  public static double toRadians(double angdeg) {
        return angdeg / 180.0 * PI;
    }
    radian = (각도/180도(=pi)) * PI;
		 */
		double under2 = st * cos(toRadians(PI/4));
		double check  = toRadians(PI/4);
		double check2 = PI/4;
		
		out.printf("밑변 : %f, 옆면: %f, 빗변 :%f\n", a, under, st);
		out.printf("toRadians(45): %f rad, PI/4: %f, (check==check2)?: %b\n", check, check2,
				(check==check2));
		out.printf("toRadians(45) == 45/180.0 * PI ? %b\n", toRadians(45) == ((45/180.0)*PI));//true
		out.printf("st * cos(PI/4) : %f, st * cos(toRadians(PI/4)): %f, "
				+ "(under==under2)?: %b\n", under, under2,(under==under2));
		out.printf("tan(각도): %f\n", 
				check2,tan(check2));
		out.printf("두점 사이의 상대적 위치 atan2(밑변(%5.2f), 빗변(%5.2f)): %f\n", 
				a,st,atan2(a,st));//역탄젠트
		
		out.println("=============================================================");
		
		out.println("로그함수");
		
		out.printf("log10(10): %f\n", log10(10));//log밑(값) -->10을 밑으로 하는 10의 로그//1
		out.printf("log(10): %f\n", log(10));//자연로그 ln(값)
		out.printf("log(E): %f\n", log(E));//1
		/*
		 * 함수(수, 밑)-->밑을 2나 e 이외의 값으로 바꾸어 진행 가능
		 * 함수(밑, 수)
		 */
		out.printf("밑이 10이나 e가 아닌 경우, 메서드를 만들어서 사용\n");
		out.printf("y=밑을 2로하는 2의 로그함수: %f\n", Log(2,2));
		out.printf("y=밑을 2로하는 2의 로그함수2: %f\n", Log2(2,2));
		out.printf("y=밑을 4로하는 2의 로그함수: %f\n", Log(4,2));
		out.printf("y=밑을 4로하는 2의 로그함수2: %f\n", Log2(2,4));
		out.println("y=밑을 6으로 하는 6의 로그함수:"+String.format("%5.3f",Log(6,6)));//1.000
		
		/*
		 * 밑이 다른 지수간 표현 가능한 값의 자리수 구하기
		 * 
		 * [sample #1] y= 24 * log10(2) -->y의 의미 : 24자리의 2진수로 표현 가능한 10진수의 자리수
		 * [sample #2] y= 24 * Log2(5) -->y의 의미 : 24자리의 5진수로 표현 가능한 2진수의 자리수
		 */
		out.printf("밑이 다른 지수간 표현 가능한 값의 자리수 구하기\n");
		double Digit_y1 = floor(24 * log10(2));
		out.printf("24자리의 2진수 ==> %.0f자리의 10진수 표현 가능\n", Digit_y1);//7자리
		double Digit_y2 = floor(24 * Log(2,5));
		out.printf("24자리의 5진수 ==> %.0f자리의 2진수 표현 가능\n", Digit_y2);//55자리
		
	}
	
	public static double Log(double base, double value)
	{
		if(base <= 1)
		{
			return -1;
		}
		
		/*
		 * https://terms.naver.com/entry.nhn?docId=3350176&cid=60210&categoryId=60210
		 * loga(b) = (1/logb(a)) = (logc(b)/logc(a))
		 * 
		 */
		return (log10(value)/log10(base));
	}
	public static double Log2(double value, double base)
	{
		return Log(base, value);
	}
}
