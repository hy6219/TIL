package interface_multi_inherit;

public class TVCR extends TV implements IVCR{

	//������ 1�� Ŭ������ ���Խ�Ű��, �� 1�� Ŭ������
	//�����ϴ� �޼���� �������̽�(IVCR)�� ����
	//�� 1�� Ŭ������ ��������� ����ϱ� ����
	//���԰���ν� ��ü ����
	/**
	 * ���԰���+���+�������̽� ����
	 * -->�������̽����� ������ �޼��带 ���ο��� �����ε��� ���,
	 * ���� �ִ� 1�� Ŭ������ �޼��带 ȣ���ϸ鼭
	 * ���ŵǹǷ� ����!
	 */
	VCR v=new VCR();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVCR t=new TVCR();
		t.play();
		t.stop();
		t.channel=13;
		t.volume=30;
		t.channelUp();
		t.volumeDown();
		System.out.println("channel: "+t.channel+", volume: "+t.volume);
		t.setCounter(10);
		System.out.println("counter: "+t.getCounter());
		t.reset();
		System.out.println("counter: "+t.getCounter());
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		v.play();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		v.stop();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		v.reset();
	}

	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return v.getCounter();
	}

	@Override
	public void setCounter(int c) {
		// TODO Auto-generated method stub
		v.setCounter(c);
	}

}
