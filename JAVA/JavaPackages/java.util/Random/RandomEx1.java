package com.util.random;
import java.util.Random;


public class RandomEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * public Random()
		 * {
		 * 		this(System.currentTimeMillis());
		 * -->Random(long seed) 호출
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
		 * seed: 유한한 한계에서 돌아가는 패턴을 정해놓는것이라 생각
		 */
		r2		  = new Random().nextDouble() * 6;//0~6 사이 난수
		double r4 = new Random().nextDouble() * 6;//0~6사이의 난수
		//r2, r4는 종자값이 같으므로 값이 같을것
		System.out.println("r2: "+r2+", r4: "+r4);
		//r2: 4.274229891960178, r4: 5.6182119388495835
		
		System.out.println(r2 == r4);//true
		
		System.out.println(Double.valueOf(r2).equals(Double.valueOf(r4)));//true
		/*
		 * 1)boolean nextBoolean()
		 * 2)int nextInt()
		 * 3)double nextDouble()
		 * 4)float nextFloat()
		 * -->boolean.int.double.float 타입의 난수를 반환
		 * ([0,1))
		 */
		
		/*
		 * double nextGaussian()
		 * -평균이 0이고 표준편차ㅏ가 1.0인 가우시안 분포에 따른
		 * double 형의 난수 반환
		 */
		
		double gau = new Random().nextGaussian();
		double gau2 = new Random().nextGaussian();
		System.out.println("new Random().nextGaussian(): "+
							gau);//0.1522797214496331
		
		System.out.println("new Random().nextGaussian(): "+
						    gau2);//1.0090584497402475
	}

}
