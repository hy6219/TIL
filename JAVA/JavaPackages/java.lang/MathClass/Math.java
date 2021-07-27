package com.lang.method;
import static java.lang.Math.*;
import static java.lang.System.*;//static import: 클래스명 생략 가능

public class Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double val = 90.7552;
		/*
		 * 반올림
		 */
		out.println("round("+val+")= "+round(val)); //91
		
		/*
		 * 소수점 2(n)번째 자리까지 표현
		 */
		double format ;
		format = round(val * 100) /100.0;
		out.println("소수점 둘째자리까지 : "+format); //90.76
		
		//소수점 셋째자리까지
		format = round(val * 1000)/1000.0;
		out.println("소수점 셋째자리까지: "+format);//90.755
		
		/*
		 * 올림
		 */
		out.println("올림: "+ceil(val));//91
		//버림
		out.println("버림: "+floor(val));//90
		//반올림
		out.printf("round 반올림:  %d\n", round(val));//91 round는 int 반환
		out.printf("round 1.5: %d\n", round(1.5)); //2
//		out.printf("반올림 f문자 : %f\n",round(val));
//		out.printf("rint 반올림  : %d\n", rint(val));
		out.printf("rint 반올림  : %f\n", rint(val));//rint는 double 반환 91.000000
		out.printf("음수 round -1.75 반올림: %d\n", round(-1.75));//-2
		out.printf("음수 rint -1.75 반올림: %f\n", rint(-1.75));//-2.000000
		
		out.printf("음수 round -1.5 반올림: %d, -1.2반올림: %d\n", round(-1.5),round(-1.2));//-1 -1
		out.printf("음수 rint -1.5 반올림: %f\n", rint(-1.5));//-2.000000
		/*
		 * 반올림시
		 * 음수-
		 * .1~.5--> 정수부분은 살리고 소수부분은 날리기(더 커지기)
		 * 
		 * .6~.9--> -((부호x)정수부분+1)(더 작아지기)
		 */
		/*
		 * x.5인 double형 값에 대해서 rint는 가장 가까운 짝수 정수를 반환
		 */
		out.printf("음수 -1.5 올림: %f, -1.75 올림: %f\n", ceil(-1.5),ceil(-1.75));
		/*ceil : double
		 * 음수 -1.5 올림: -1.000000, -1.75 올림: -1.000000
		 * 음수 올림: 숫자가 더 커짐!
		 * */
		out.printf("음수 -1.5 버림: %f, -1.75 버림: %f\n", floor(-1.5),floor(-1.75));
		/*
		 * floor: double
		 * 
		 * 음수 -1.5 버림: -2.000000, -1.75 버림: -2.000000
		 * 
		 * 음수 버림: 숫자가 더 작아짐!
		 * 
		 * */
		out.printf("ceil(%f): %f, floor(%f): %f\n", -1.2,ceil(-1.2),-1.2,floor(-1.2));//-1,-2
	}

}
