package Instruments;

public abstract class Strings extends Instrument{
	
	//a variable to hold the type of finger board
	protected String fingerboard;
	
	public Strings(String manufacturer, String model){
		super(manufacturer, model);
	}
	
	public String getFingerboard(){
		return fingerboard;
	}
	
	public void setFingerboard(String fingerboard){
		this.fingerboard = fingerboard;
	}

}
