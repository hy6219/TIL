package interface_multi_inherit;

public interface IVCR {
	/**
	 * 
	 * ���� ������ ���� ������
	 * �ڹٿ����� 
	 * https://resup.tistory.com/16
	 * �� ���� public Ŭ������ �̸��� ���ϰ�
	 * �ٸ��� ������ ���� ������ �䱸�ϱ� ����!
	 */
	public abstract void play();
	//public (abstract) void stop();
	public void stop();
	
	public void reset();
	public abstract int getCounter();
	public abstract void setCounter(int c);
	
}
