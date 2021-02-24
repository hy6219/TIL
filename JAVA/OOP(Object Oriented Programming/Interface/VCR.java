package interface_multi_inherit;


public class VCR{

	protected int counter;
	

	public void play() {
		// TODO Auto-generated method stub
		System.out.println("play");
	}


	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("stop");
	}


	public void reset() {
		// TODO Auto-generated method stub
		counter=0;
	}


	public int getCounter() {
		// TODO Auto-generated method stub
		return counter;
	}


	public void setCounter(int c) {
		// TODO Auto-generated method stub
		counter=c;
	}
}
