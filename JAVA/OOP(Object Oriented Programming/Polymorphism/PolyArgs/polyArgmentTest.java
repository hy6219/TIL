package class_oop_polyargs;

class Product
{
	int price;
	int bonusPoint;
	
	Product(int price)
	{
		this.price=price;
		bonusPoint=(int)(price/10.0);
	}
}

class TV extends Product
{
	TV()
	{
		super(100);//Product(가격=100)-->bonusPoint=10
	}
	@Override
	//(최고층조상클래스는 object)
	public String toString()
	{
		return "TV";
	}
}

class Computer extends Product
{
	Computer()
	{
		super(200);
	}
	@Override
	public String toString()
	{
		return "Computer";
	}
}

class Buyer
{
	int money=1000;
	int bonusPoint=0;
	
	void buy(Product p)
	{
		if(money<p.price)
		{
			System.out.println("잔액이 부족하여 물건을 구매할 수 없습니다");
			return;
		}
		money-=p.price;//가진돈-구매금액
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"을(를) 구매하셨습니다");//p.toString호출
	}
}

public class polyArgmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b=new Buyer();
		
		/*
		 * Product p1=new TV();가 생략된 셈!
		 * 부모 참조변수가 자손 인스턴스를 참조하는 객체를
		 * 매개체로 넣어줌!
		 */
		b.buy(new TV());
		b.buy(new Computer());
		
		System.out.println("현재 남은 돈은 "+b.money+"입니다.");
		System.out.println("현재 보너스 점수는 "+b.bonusPoint+"입니다.");
	}

}
