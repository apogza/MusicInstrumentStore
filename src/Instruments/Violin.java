package Instruments;

public class Violin extends Strings {
	
	protected String backAndSides;
	protected int size;

	public Violin(String manufacturer, String model) {
		super(manufacturer, model);
		setType("Violin");
	}
	
	public Violin(){
		this(null, null);
	}
	
	public String getBackAndSides(){
		return backAndSides;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setBackAndSides(String backAndSides){
		this.backAndSides = backAndSides;
	}
	
	public void setSize(int size){
		this.size = size;
	}
}
