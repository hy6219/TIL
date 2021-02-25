package interface_polymorphism_common;

public class RepairableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank t1=new Tank();
		Marine m1=new Marine();
		SCV s1=new SCV();
		Dropship d1=new Dropship();
		
		s1.repair(t1);
		//s1.repair(m1);: Marine은 인터페이스를 구현하지 않았기 때문에
		//Repairable interface로 캐스팅하거나 메서드의 파라미터를
		//변경하라는 메시지가 발생함
		s1.repair(d1);
	}

}
