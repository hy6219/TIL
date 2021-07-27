package interface_multi_inherit;

public interface IVCR {
	/**
	 * 
	 * 따로 파일을 만든 이유는
	 * 자바에서는 
	 * https://resup.tistory.com/16
	 * 와 같이 public 클래스의 이름이 파일과
	 * 다르면 각자의 파일 생성을 요구하기 때문!
	 */
	public abstract void play();
	//public (abstract) void stop();
	public void stop();
	
	public void reset();
	public abstract int getCounter();
	public abstract void setCounter(int c);
	
}
