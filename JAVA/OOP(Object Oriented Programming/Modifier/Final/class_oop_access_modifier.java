package class_oop_access_modifier;

class Card
{
	//const.
	/*
	 * final이 붙어 상수지만!
	 *선언+초기화를 동시에 하지 않아도!
	 *
	 *
	 *final 인스턴스변수이므로! 생성자 or 초기화 블럭(둘 중 하나)에서 초기화가 가능!
	 *https://blog.advenoh.pe.kr/java/%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-final%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9D%B4%ED%95%B4/
	 *
	 */
	final int NUM;//카드에 새겨진 숫자
	final String KIND;//카드 종류
	/*class var
	 * 
	 */
	static int width=100;
	static int height=200;
	
	Card()
	{
		this("DIAMOND",2);
	}
	Card(String kind, int number)
	{
		KIND=kind;
		NUM=number;
		/*
		 * final에는 값을 할당시킬 수 없음
		 * (this.var or class.var 불가!)
		 * 
		 * 단, 값을 변경할수는 있음!
		 * 
		 * 
		 */
	}
	public String toString()
	{
		/*
		 * Card instance를 출력하는 것과 동일
		 * System.out.println(c);
		 * 
		 * 그 이유는 System.out.println(pbj)가 호출되면
		 * public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
    }
    와 같은 String valueOf(obj)를 불러오고, 이로 인하여
    toString()을 호출하게 되기 때문에 동일한것!
		 * 
		 * +공식 api 에서 아래와 같이 정의된 toString은
		 * 메모리 주소를 내놓는데,
		 *  이를 String클래스에서 오버라이딩하지 않으면
		 * 메모리 주소를 내놓게 되기에, 오버라이딩을 꼭 해야 하고!
		 * 기본적으로 jdk에서 String 클래스에서 오버라이딩되도록
		 * 되어 있음
		 * https://atoz-develop.tistory.com/entry/%EC%9E%90%EB%B0%94-Object-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%A0%95%EB%A6%AC-toString-equals-hashCode-clone
		 * 
	
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}

		 */
		
		/**
		 * 이런 메서드를 우리가 오버라이딩했으니,
		 * 같은 맥락!
		 */
		return "kind: "+KIND+", number: "+NUM;
	}
}
class another
{
	int c_number;
	String c_kind;
	
	another()
	{
		this("JOKER",3);
	}
	another(String c_kind,int c_number)
	{
		this.c_kind=c_kind;
		this.c_number=c_number;
	}
	/**
	 * 결과적으로
	 * java에서는 기본적으로
	 * import java.lang을 항상 암시적으로 제공하기 때문에
	 * java.lang에 속한 String object의 메서드인
	 * toString을 오버라이드하는것!
	 * 따라서 public을 붙여야 함!
	 * 
	 * 왜 access modifier가 public이어야 하느냐?
	 * https://johngrib.github.io/wiki/Object-toString/
	 * 
	 * java.lang api 문서에서
	 * toString의 접근제어자가 public으로 되어 있는데
	 * 자손클래스의 경우, 조상클래스의 접근제어자 이상의 범주에서
	 * 선택하여야 하기 때문에 이 경우 public을 택할 수밖에 없다!
	 * 
	 * java..
	 * class A (extends Object)가 된 형태!
	 */
	@Override
	public String toString()
	{
		return "kind: "+c_kind+", number"+c_number;
	}
}
public class class_oop_access_modifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c=new Card("SPADE",3);
		System.out.println("Card c");
		System.out.println(c);
		System.out.println();
		System.out.println(c.toString());
		
		System.out.println();
		System.out.println();
		/*
		 * toString 한가지 관찰
		 */
		another a=new another("DIAMOND",3);
		System.out.println("another a");
		System.out.println(a);
		System.out.println();
		System.out.println(a.toString());
	}

}
