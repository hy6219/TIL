package class_access_modifier_oop;

class Time
{
	/*
	 * 캡슐화(encapsulation)로 데이터 보호할 시간 변수들 보호
	 * public으로 메소드 접근을 두어, 어디에서도 사용할 수 있게끔 함
	 */
	private int hour,min,sec;
	Time()
	{
		this(0,0,0);
	}
	Time(int hour, int min, int sec)
	{
		this.hour=hour;
		this.min=min;
		this.sec=sec;
	}
	Time(Time tt)
	{
		this.hour=tt.hour;
		this.min=tt.min;
		this.sec=tt.sec;
	}
	/*
	 * setters
	 * 시,분,초 범위제한 설정
	 * hour: 0~23
	 * min, sec: 0~59
	 * 
	 * parameter or local value can't use access modifier
	 */
	
	public void SetHour(int hour)
	{
		if(hour<0 ||hour>23)
		{
			return;
		}
		else
		{
			this.hour=hour;
		}
	}
	public void SetMin(int min)
	{
		if(min<0 ||min>59)
		{
			return;
		}
		else
		{
			this.min=min;
		}
	}
	public void SetSec(int sec)
	{
		if(sec<0 ||sec>59)
		{
			return;
		}
		else
		{
			this.sec=sec;
		}
	}
	public void SetTime(Time obj)
	{
		(this).SetHour(obj.hour);
		(this).SetMin(obj.min);
		(this).SetSec(obj.sec);
	}
	/*
	 * getters
	 */
	public int GetHour()
	{
		return hour;
	}
	public int GetMin()
	{
		return min;
	}
	public int GetSec()
	{
		return sec;
	}
	@Override
	public String toString()
	{
		return hour+" : "+min+" : "+sec;
	}
}

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t=new Time(16,40,10);
		t.SetTime(t);
		System.out.println(t);
	}

}
