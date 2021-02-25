package interface_partial_change;

public class Barrack extends Building implements Liftable{
	//재사용성을 높이기 위하여 Liftable이 구현된 클래스는 포함시켜서 이용하기!
	Lift l=new Lift();
	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		l.liftOff();
	}

	@Override
	public Building move(int x, int y) {
		// TODO Auto-generated method stub
		Building r=l.move(x, y);
		return r;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		l.stop();
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		l.land();
	}
	
	public void ba()
	{
		System.out.println(new Barrack().getClass().getSimpleName());
	}
	
}
