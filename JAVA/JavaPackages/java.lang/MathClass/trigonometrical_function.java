package com.lang.method;
import static java.lang.Math.*;
import static java.lang.System.*;


public class trigonometrical_function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �ﰢ�Լ��� ����, �α�
		 */
		
		int x1 = 1, y1 = 1, x2 = 2, y2 = 2;
		
		/*
		 * double(double)
		 * ������ ���
		 */
		out.println("�����Լ�-������");
		out.println("=============================================================");
		out.println("Math.sqrt() : ������");
		out.printf("4.5�� ������ Math.sqrt(%5.2f)= %5.2f\n", 4.5,sqrt(4.5));//double��ȯ
		/*
		 * double(double)
		 * 2������ �̻�: pow(a,1.0/n.0)
		 */
		out.println("Math.pow(val, 1.0/n.0) : n������");
		
		out.printf("4.5�ڱ��ڽ� Math.pow(%5.2f, 1.0/1.0)= %5.2f\n", 4.5,pow(4.5,1.0/1.0));
		out.printf("4.5�� ������ Math.pow(%5.2f, 1.0/2.0)= %5.2f\n", 4.5,pow(4.5,1.0/2.0));
		out.printf("4.5�� 3������ Math.pow(%5.2f, 1.0/3.0)= %5.2f\n", 4.5,pow(4.5,1.0/3.0));
		out.printf("4.5�� 4������ Math.pow(%5.2f, 1.0/4.0)= %5.2f\n", 4.5,pow(4.5,1.0/4.0));
		out.printf("4.5�� 5������ Math.pow(%5.2f, 1.0/5.0)= %5.2f\n", 4.5,pow(4.5,1.0/5.0));
		/*
		 * Math.cbrt()-->��������
		 */
		out.println("Math.cbrt() : 3������");
		out.printf("4.5�� 3������ Math.cbrt(%5.2f)= %5.2f\n", 4.5,cbrt(4.5));
		
		
		out.println("Math.pow(val, n) : val^n");
		out.printf("4.5^2:  Math.pow(%5.2f, 2)= %5.2f\n", 4.5,pow(4.5,2));
		
		out.println("=============================================================");
		
		out.println("�ﰢ�Լ�");
		
		final double st = sqrt((pow(x2-x1, 2))+ pow(y2-y1,2));//(x1,y1)-(x2,y2)�� ���аŸ�
		double a = st * sin(PI/4);//�����̵ �ﰢ�� ������� �ϴ� ��! 
		/*
		 * 			|
		 *        / |
		 *       /  |
		 *      /___| �߿��� �غ� ���� | �̺κ�!
		 */
		
		double under = st * cos(PI/4);
		/*
		 *  public static double toRadians(double angdeg) {
        return angdeg / 180.0 * PI;
    }
    radian = (����/180��(=pi)) * PI;
		 */
		double under2 = st * cos(toRadians(PI/4));
		double check  = toRadians(PI/4);
		double check2 = PI/4;
		
		out.printf("�غ� : %f, ����: %f, ���� :%f\n", a, under, st);
		out.printf("toRadians(45): %f rad, PI/4: %f, (check==check2)?: %b\n", check, check2,
				(check==check2));
		out.printf("toRadians(45) == 45/180.0 * PI ?? %b\n", toRadians(45) == ((45/180.0)*PI));//true
		out.printf("st * cos(PI/4) : %f, st * cos(toRadians(PI/4)): %f, "
				+ "(under==under2)?: %b\n", under, under2,(under==under2));
		out.printf("tan(����): %f\n", 
				check2,tan(check2));
		out.printf("���� ������ ����� ��ġ atan2(�غ�(%5.2f), ����(%5.2f)): %f\n", 
				a,st,atan2(a,st));//��ź��Ʈ
		
		out.println("=============================================================");
		
		out.println("�α��Լ�");
		
		out.printf("log10(10): %f\n", log10(10));//log��(��) -->10�� ������ �ϴ� 10�� �α�//1
		out.printf("log(10): %f\n", log(10));//�ڿ��α� ln(��)
		out.printf("log(E): %f\n", log(E));//1
		/*
		 * �Լ�(��, ��)-->���� 2�� e �̿��� ������ �ٲپ� ���� ����
		 * �Լ�(��, ��)
		 */
		out.printf("���� 10�̳� e�� �ƴ� ���, �޼��带 ���� ���\n");
		out.printf("y=���� 2���ϴ� 2�� �α��Լ�: %f\n", Log(2,2));
		out.printf("y=���� 2���ϴ� 2�� �α��Լ�2: %f\n", Log2(2,2));
		out.printf("y=���� 4���ϴ� 2�� �α��Լ�: %f\n", Log(4,2));
		out.printf("y=���� 4���ϴ� 2�� �α��Լ�2: %f\n", Log2(2,4));
		out.println("y=���� 6���� �ϴ� 6�� �α��Լ�:"+String.format("%5.3f",Log(6,6)));//1.000
		
		/*
		 * ���� �ٸ� ������ ǥ�� ������ ���� �ڸ��� ���ϱ�
		 * 
		 * [sample #1] y= 24 * log10(2) -->y�� �ǹ� : 24�ڸ��� 2������ ǥ�� ������ 10������ �ڸ���
		 * [sample #2] y= 24 * Log2(5) -->y�� �ǹ� : 24�ڸ��� 5������ ǥ�� ������ 2������ �ڸ���
		 */
		out.printf("���� �ٸ� ������ ǥ�� ������ ���� �ڸ��� ���ϱ�\n");
		double Digit_y1 = floor(24 * log10(2));
		out.printf("24�ڸ��� 2���� ==> %.0f�ڸ��� 10���� ǥ�� ����\n", Digit_y1);//7�ڸ�
		double Digit_y2 = floor(24 * Log(2,5));
		out.printf("24�ڸ��� 5���� ==> %.0f�ڸ��� 2���� ǥ�� ����\n", Digit_y2);//55�ڸ�
		
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
