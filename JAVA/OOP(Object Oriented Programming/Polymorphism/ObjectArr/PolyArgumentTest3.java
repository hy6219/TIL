package class_oop_polymorphism_polyArgs;

import java.util.Vector;

class Product
{
	int price;
	int bonusPoint;
	Product()
	{
		this(0);
	}
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

class Audio extends Product
{
	Audio()
	{
		super(100);
	}
	@Override
	public String toString()
	{
		return "Audio";
	}
}

class Buyer
{
	int money=1000;
	int bonusPoint=0;
	Vector item=new Vector();
	void buy(Product p)
	{
		if(money<p.price)
		{
			System.out.println("잔액이 부족하여 물건을 구매할 수 없습니다");
			return;
		}
		money-=p.price;//가진돈-구매금액
		bonusPoint+=p.bonusPoint;
		item.add(p);
		System.out.println(p+"을(를) 구매하셨습니다");//p.toString호출
	}
	
	void refund(Product p)
	{
		if(item.remove(p))
		{
			money+=p.price;
			bonusPoint-=p.bonusPoint;
			System.out.println(p+"를 반품하셨습니다");
		}
		else
		{
			System.out.println("구입하신 제품 중 해당 제품이 없습니다");
		}
	}
	
	void summary()
	{
		int sum=0;
		String itemList="";
		
		if(item.isEmpty())
		{
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		for(int i=0;i<item.size();i++)
		{
			Product p=(Product)item.get(i);
			sum+=p.price;
			itemList+=(i==0)?""+p:","+p;
		}
		
		System.out.println("구입하신 물건들의 총 금액은 "+sum+"원입니다.");
		System.out.println("구입하신 제품은 "+itemList+"입니다");
	}
}


public class PolyArgumentTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b=new Buyer();
		TV t=new TV();
		Computer c=new Computer();
		Audio a=new Audio();
		b.buy(t);
		b.buy(c);
		b.buy(a);
		b.summary();
		System.out.println();
		b.refund(t);
		b.summary();
		
	}

}
