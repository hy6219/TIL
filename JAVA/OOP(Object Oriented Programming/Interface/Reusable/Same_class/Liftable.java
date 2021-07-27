package interface_partial_change;

public interface Liftable {
	public abstract void liftOff();
	public abstract Building move(int x, int y);
	public abstract void stop();
	public void land();
}
