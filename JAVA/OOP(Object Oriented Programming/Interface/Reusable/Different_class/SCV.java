package interface_polymorphism_common;

public class SCV extends GroundUnit implements Repairable{
	/**
	 * SCV가 Tank, Dropship 회복하게끔 공통점을 비어있는 인터페이스로 부여
	 */
	SCV()
	{
		super(50);
		hit=MAX_HP;
	}
	//회복하는 메서드
	void repair(Repairable r)
	{
		if(r instanceof Unit)
		{
			/**
			 * Unit을 사용하는 이유: 지상과 공중유닛 모두 
			 * 유닛을 공통으로 삼고 있음
			 */
			/**
			 * 인터페이스를 공통적으로 갖는 인스턴스 r이
			 * 유닛의 객체에 소속/포함된다면 HP 회복
			 */
			Unit u=(Unit) r;//hit과 MAX_HP 부분에 대해서만 접근
			/**
			 * SCV with Repairable->Parent2: GroundUnit->Parent1: Unit
			 * +게다가 SCV->Repairable 느낌!
			 * 따라서 우선적으로 Unit u=new SCV();인데,
			 * 위의 SCV와 Repairable간의 관계에 따라서
			 * Unit u=[SCV: Child= Repairable: Parent]-->따라서 강제 형변환시켜야함!
			 * Unit u=(SCV class)(Repairable r);
			 * <=>Unit u=(SCV class->unit:즉, Parent p=new Child(); 따라서,
			 * 묵시적 형변환 진행 가능)r;
			 * <=>Unit u=(Unit)r;
			 */
			while(u.hit<0 || u.hit!=u.MAX_HP)
			{
				u.hit++;
			}
			System.out.println(u.toString()+"의 회복이 끝났습니다");
		}
	}
}
