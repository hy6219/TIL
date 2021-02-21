package class_abstract_common;

abstract class unit
{
	static int x=10;
	static int y=20;
	abstract void move(int x, int y);
	void stop() 
	{
		System.out.println("stop");
	};
}
class Tank extends unit
{

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		x=super.x;
		y=super.y;
		System.out.println("Move to: ( "+x+", "+y+" )");
	}
	void changeMod()
	{
		System.out.println("Change the mode");
	}
}
public class Marine extends unit{
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine m=new Marine();
		m.move(0, 1);
		m.stimpack();
		/*
		 * move(x,y) , abstract class 내 x&y를 static으로 둔다면?
		 * 
		 * -->어떻게 x,y 매개변수를 따로 정의해두지 않았는데, int인지 아닌지
		 * 확인도 안하고 그저 바로 x=super.x로 바로 넘어가서
		 * 매개변수가 자동으로 super.x로 인식되는지? (심지어, 메인함수 내에서
		 * 따로 변수를 정의해두지 않았음)
		 */
		System.out.println();
		Tank t=new Tank();
		t.move(x, y);
		t.changeMod();
	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Move to: ( "+x+", "+y+" )");
	}
	void stimpack()
	{
		System.out.println("use stimpack!");
	}

}
