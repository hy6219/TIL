package interface_multi_inherit;

public class TVCR extends TV implements IVCR{

	//나머지 1개 클래스는 포함시키고, 그 1개 클래스에
	//존재하는 메서드는 인터페이스(IVCR)로 빼기
	//그 1개 클래스의 멤버변수를 사용하기 위해
	//포함관계로써 객체 생성
	/**
	 * 포함관계+상속+인터페이스 구현
	 * -->인터페이스에서 구현된 메서드를 메인에서 오버로딩할 경우,
	 * 원래 있던 1개 클래스의 메서드를 호출하면서
	 * 갱신되므로 용이!
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
