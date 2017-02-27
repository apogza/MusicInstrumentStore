package Instruments;

public abstract class Keys extends Instrument {

	protected String dimensions;
	
	public Keys(String manufacturer, String model) {
		super(manufacturer, model);
	}
	
	public String getDimensions(){
		return dimensions;
	}
	
	public void setDimensions(String dimensions){
		this.dimensions = dimensions;
	}
}
