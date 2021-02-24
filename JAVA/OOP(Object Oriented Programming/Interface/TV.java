package interface_multi_inherit;

class TV {
	protected boolean power;
	protected int channel;
	protected int volume;
	
	public void power()
	{
		power=!power;
	}
	public void channelUp()
	{
		++channel;//channel++;를 하지 않는 이유:
		//channel을 반환 후 channel++수행
	}
	public void channelDown()
	{
		--channel;
	}
	public void volumeUp()
	{
		++volume;
	}
	public void volumeDown()
	{
		--volume;
	}
}
