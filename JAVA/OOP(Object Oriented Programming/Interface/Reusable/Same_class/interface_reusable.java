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
		//l�� �����߱� ������ l �ν��Ͻ����� ����ɼ� �ִ� ������
		//����Ÿ���� Building(��������Ŭ����)�� �ϰ�,
		//���� Building ��ü�� �־� ��ȯ
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
