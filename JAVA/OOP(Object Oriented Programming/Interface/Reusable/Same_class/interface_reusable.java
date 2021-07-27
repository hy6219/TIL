package interface_partial_change;

public class interface_reusable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bunker b=new Bunker();
		Barrack ba=new Barrack();
		Factory fa=new Factory();
		
		System.out.println(b.toString());
		System.out.println();
		ba.ba();
		ba.liftOff();
		Building r=ba.move(3, 5);
		//l로 접근했기 때문에 l 인스턴스에만 적용될수 있는 문제를
		//리턴타입을 Building(공통조상클래스)로 하고,
		//값을 Building 객체에 넣어 반환
		System.out.println("now Barrack at ("+r.x+", "+r.y+")");
		ba.stop();
		ba.land();
		System.out.println();
		
		fa.fa();
		fa.liftOff();
		r=fa.move(3, 5);
		System.out.println("now Factory at ("+r.x+", "+r.y+")");
		fa.stop();
		fa.land();
		
	}

}
