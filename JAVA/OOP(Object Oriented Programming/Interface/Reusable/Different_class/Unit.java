package interface_polymorphism_common;
/*
 * ����� ���� ������ �������� ��������� Ŭ������ ����
 */
public class Unit {
	//��������Ʈ
	int hit;
	//ó�� ���� HP(�ִ�ġ)
	final int MAX_HP;
	
	Unit(int hp)
	{
		this.MAX_HP=hp;
	}
	/**
	 * Unit�� �����ϰ��� ������,
	 * Parent->Child ����ȯ�� �ǹ̻� non-sense
	 
	@Override
	public String toString()
	{
		return Unit.getClass().getName();
	}
	*/
}
