package interface_partial_change;

public class Lift implements Liftable{
	/**
	 * 인터페이스를 구현한 클래스를 이용->나중에 포함관계로 넣게되면,
	 * 1)객체로 Lift 내의 메서드를 호출할 수 있음
	 * 2)변경(추가)할 경우, 번거롭거나 복잡하지 않음
	 */
	
	@Override
	public Building move(int x, int y) {
		// TODO Auto-generated method stub
		Building b=new Building();//나중에 입력받는 x,y만큼 이동 후를 보고 싶어서 포함시킴
		
		//Lift객체가 호출될때, 나가기 직전에 Building 객체에 복사
		b.x+=x;
		b.y+=y;
		return b;
		
	}
	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		//건물을 들어올리기
		System.out.println("건물을 들어올리기");
	}

	

	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("멈추시오~");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("착륙시키기!");
	}

}
