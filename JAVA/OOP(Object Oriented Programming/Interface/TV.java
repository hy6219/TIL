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
		++channel;//channel++;�� ���� �ʴ� ����:
		//channel�� ��ȯ �� channel++����
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
