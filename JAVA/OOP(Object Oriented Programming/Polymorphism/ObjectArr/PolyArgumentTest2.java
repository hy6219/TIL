package class_oop_polymorphism_arr;

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
	Product[] item=new Product[10];//구입한 제품 저장 배열
	int i=0;//iterator
	void buy(Product p)
	{
		if(money<p.price)
		{
			System.out.println("잔액이 부족하여 물건을 구매할 수 없습니다");
			return;
		}
		money-=p.price;//가진돈-구매금액
		bonusPoint+=p.bonusPoint;
		item[i++]=p;
		System.out.println("cur item: "+item[i-1]+", price: "+Integer.toString(item[i-1].price)+" , bonus point: "+Integer.toString(item[i-1].bonusPoint));
		System.out.println(p+"을(를) 구매하셨습니다");//p.toString호출
	}
	
	void summary()
	{
		int sum=0;
		String itemList="";
		
		for(int i=0;i<item.length;i++)
		{
			if(item[i]==null) break;

			sum+=item[i].price;
			itemList+=item[i]+",";
		}
		
		System.out.println("구입하신 물건들의 총 금액은 "+sum+"원입니다.");
		System.out.println("구입하신 제품은 "+itemList+"입니다");
	}
}


public class PolyArgumentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b=new Buyer();
		b.buy(new Computer());
		b.buy(new Audio());
		b.buy(new TV());
		b.summary();
	}

}
