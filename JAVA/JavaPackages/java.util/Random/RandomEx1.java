package com.util.random;
import java.util.Random;


public class RandomEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * public Random()
		 * {
		 * 		this(System.currentTimeMillis());
		 * -->Random(long seed) ȣ��
		 * }
		 */
		Random r1 = new Random();
		double r2 = new Random().nextDouble();
		int	   r3 = new Random().nextInt();
		System.out.println("r1: "
				+r1+",\nr2: "+r2+
				",\nr3: "+r3);
		
		/*
		 * public Random(long seed)
		 */
		r2		  = new Random(6).nextDouble();//0~6 ���� ����
		double r4 = new Random(6).nextDouble();//0~6������ ����
		//r2, r4�� ���ڰ��� �����Ƿ� ���� ������
		System.out.println("r2: "+r2+", r4: "+r4);
		//r2: 0.7307886238322471, r4: 0.7307886238322471
		
		System.out.println(r2 == r4);//true
		
		System.out.println(Double.valueOf(r2).equals(Double.valueOf(r4)));//true
		/*
		 * 1)boolean nextBoolean()
		 * 2)int nextInt()
		 * 3)double nextDouble()
		 * 4)float nextFloat()
		 * -->boolean.int.double.float Ÿ���� ������ ��ȯ
		 * ([0,1))
		 */
		
		/*
		 * double nextGaussian()
		 * -����� 0�̰� ǥ���������� 1.0�� ����þ� ������ ����
		 * double ���� ���� ��ȯ
		 */
		
		double gau = new Random().nextGaussian();
		double gau2 = new Random().nextGaussian();
		System.out.println("new Random().nextGaussian(): "+
							gau);//0.1522797214496331
		
		System.out.println("new Random().nextGaussian(): "+
						    gau2);//1.0090584497402475
	}

}
