package interface_polymorphism_common;
/*
 * 지상과 공중 유닛의 공통적인 멤버변수를 클래스로 정의
 */
public class Unit {
	//공격포인트
	int hit;
	//처음 시작 HP(최대치)
	final int MAX_HP;
	
	Unit(int hp)
	{
		this.MAX_HP=hp;
	}
	/**
	 * Unit에 구현하고자 했지만,
	 * Parent->Child 형변환은 의미상 non-sense
	 
	@Override
	public String toString()
	{
		return Unit.getClass().getName();
	}
	*/
}
