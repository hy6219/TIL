package interface_polymorphism_common;

public class RepairableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank t1=new Tank();
		Marine m1=new Marine();
		SCV s1=new SCV();
		Dropship d1=new Dropship();
		
		s1.repair(t1);
		//s1.repair(m1);: Marine�� �������̽��� �������� �ʾұ� ������
		//Repairable interface�� ĳ�����ϰų� �޼����� �Ķ���͸�
		//�����϶�� �޽����� �߻���
		s1.repair(d1);
	}

}
