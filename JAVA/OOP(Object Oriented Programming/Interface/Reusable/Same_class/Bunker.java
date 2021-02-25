package interface_partial_change;

public class Bunker extends Building{
	Bunker()
	{
		super();
	}
	
	public String toString()
	{
		return new Bunker().getClass().getSimpleName();
	}
}
