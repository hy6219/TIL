package class_oop_polymorphism;

class TV
{
	boolean power;
	int channel;
	
	void setPower()
	{
		power=!power;
	}
	void setChannelUp()
	{
		if(power==true)
		{
			++channel;
			System.out.println("Now, Channel Up");
		}
		else
		{
			return;
		}
	}
	void setChannelDown()
	{
		if(power==true)
		{
			--channel;
			System.out.println("Now, Channel Down");
		}
		else
		{
			return;
		}
	}
}
public class CaptionTV extends TV{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaptionTV c=new CaptionTV();
		TV t=new CaptionTV();//polymorphism
		
		c.setPower();
		t.setPower();
		
		c.channel=5;
		t.channel=2;
		
		prtRpt("=",3);
		System.out.print("CaptionTV c=new CaptionTV()");
		prtRpt("=",3);
		System.out.println();
		System.out.println("Default channel: "+c.channel);
		c.setChannelUp();
		System.out.println("Current channel: "+c.channel);
		c.setChannelDown();
		System.out.println("Current channel: "+c.channel);
		System.out.println();
		
		prtRpt("=",3);
		System.out.print("TV t=new CaptionTV()");
		prtRpt("=",3);
		System.out.println();
		System.out.println("Default channel: "+t.channel);
		t.setChannelUp();
		System.out.println("Current channel: "+t.channel);
		t.setChannelDown();
		System.out.println("Current channel: "+t.channel);
	}
	//static main 메서드 내에서 접근해야 하기 때문에 static을 붙임
	static void prtRpt(String st,int n) 
	{
		if(n>0)
		{
			System.out.print(st);
			PrtRpt(st,n-1);
		}
		else
		{
			return;
		}
	}
	static void caption()
	{
		System.out.println("caption");
	}

}
