package interface_polymorphism_common;

public class SCV extends GroundUnit implements Repairable{
	/**
	 * SCV�� Tank, Dropship ȸ���ϰԲ� �������� ����ִ� �������̽��� �ο�
	 */
	SCV()
	{
		super(50);
		hit=MAX_HP;
	}
	//ȸ���ϴ� �޼���
	void repair(Repairable r)
	{
		if(r instanceof Unit)
		{
			/**
			 * Unit�� ����ϴ� ����: ����� �������� ��� 
			 * ������ �������� ��� ����
			 */
			/**
			 * �������̽��� ���������� ���� �ν��Ͻ� r��
			 * ������ ��ü�� �Ҽ�/���Եȴٸ� HP ȸ��
			 */
			Unit u=(Unit) r;//hit�� MAX_HP �κп� ���ؼ��� ����
			/**
			 * SCV with Repairable->Parent2: GroundUnit->Parent1: Unit
			 * +�Դٰ� SCV->Repairable ����!
			 * ���� �켱������ Unit u=new SCV();�ε�,
			 * ���� SCV�� Repairable���� ���迡 ����
			 * Unit u=[SCV: Child= Repairable: Parent]-->���� ���� ����ȯ���Ѿ���!
			 * Unit u=(SCV class)(Repairable r);
			 * <=>Unit u=(SCV class->unit:��, Parent p=new Child(); ����,
			 * ������ ����ȯ ���� ����)r;
			 * <=>Unit u=(Unit)r;
			 */
			while(u.hit<0 || u.hit!=u.MAX_HP)
			{
				u.hit++;
			}
			System.out.println(u.toString()+"�� ȸ���� �������ϴ�");
		}
	}
}
