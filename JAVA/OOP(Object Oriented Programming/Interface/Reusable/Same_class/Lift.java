package interface_partial_change;

public class Lift implements Liftable{
	/**
	 * �������̽��� ������ Ŭ������ �̿�->���߿� ���԰���� �ְԵǸ�,
	 * 1)��ü�� Lift ���� �޼��带 ȣ���� �� ����
	 * 2)����(�߰�)�� ���, ���ŷӰų� �������� ����
	 */
	
	@Override
	public Building move(int x, int y) {
		// TODO Auto-generated method stub
		Building b=new Building();//���߿� �Է¹޴� x,y��ŭ �̵� �ĸ� ���� �; ���Խ�Ŵ
		
		//Lift��ü�� ȣ��ɶ�, ������ ������ Building ��ü�� ����
		b.x+=x;
		b.y+=y;
		return b;
		
	}
	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		//�ǹ��� ���ø���
		System.out.println("�ǹ��� ���ø���");
	}

	

	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("���߽ÿ�~");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("������Ű��!");
	}

}
