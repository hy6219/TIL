package com.lang.method;
import static java.lang.Math.*;
import static java.lang.System.*;//static import: Ŭ������ ���� ����

public class Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double val = 90.7552;
		/*
		 * �ݿø�
		 */
		out.println("round("+val+")= "+round(val)); //91
		
		/*
		 * �Ҽ��� 2(n)��° �ڸ����� ǥ��
		 */
		double format ;
		format = round(val * 100) /100.0;
		out.println("�Ҽ��� ��°�ڸ����� : "+format); //90.76
		
		//�Ҽ��� ��°�ڸ�����
		format = round(val * 1000)/1000.0;
		out.println("�Ҽ��� ��°�ڸ�����: "+format);//90.755
		
		/*
		 * �ø�
		 */
		out.println("�ø�: "+ceil(val));//91
		//����
		out.println("����: "+floor(val));//90
		//�ݿø�
		out.printf("round �ݿø�:  %d\n", round(val));//91 round�� int ��ȯ
		out.printf("round 1.5: %d\n", round(1.5)); //2
//		out.printf("�ݿø� f���� : %f\n",round(val));
//		out.printf("rint �ݿø�  : %d\n", rint(val));
		out.printf("rint �ݿø�  : %f\n", rint(val));//rint�� double ��ȯ 91.000000
		out.printf("���� round -1.75 �ݿø�: %d\n", round(-1.75));//-2
		out.printf("���� rint -1.75 �ݿø�: %f\n", rint(-1.75));//-2.000000
		
		out.printf("���� round -1.5 �ݿø�: %d, -1.2�ݿø�: %d\n", round(-1.5),round(-1.2));//-1 -1
		out.printf("���� rint -1.5 �ݿø�: %f\n", rint(-1.5));//-2.000000
		/*
		 * �ݿø���
		 * ����-
		 * .1~.5--> �����κ��� �츮�� �Ҽ��κ��� ������(�� Ŀ����)
		 * 
		 * .6~.9--> -((��ȣx)�����κ�+1)(�� �۾�����)
		 */
		/*
		 * x.5�� double�� ���� ���ؼ� rint�� ���� ����� ¦�� ������ ��ȯ
		 */
		out.printf("���� -1.5 �ø�: %f, -1.75 �ø�: %f\n", ceil(-1.5),ceil(-1.75));
		/*ceil : double
		 * ���� -1.5 �ø�: -1.000000, -1.75 �ø�: -1.000000
		 * ���� �ø�: ���ڰ� �� Ŀ��!
		 * */
		out.printf("���� -1.5 ����: %f, -1.75 ����: %f\n", floor(-1.5),floor(-1.75));
		/*
		 * floor: double
		 * 
		 * ���� -1.5 ����: -2.000000, -1.75 ����: -2.000000
		 * 
		 * ���� ����: ���ڰ� �� �۾���!
		 * 
		 * */
		out.printf("ceil(%f): %f, floor(%f): %f\n", -1.2,ceil(-1.2),-1.2,floor(-1.2));//-1,-2
	}

}
