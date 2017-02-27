package Instruments;

public class Drums extends Instrument{

	private String bassDrum;
	private String floorDrum;
	private String snareDrum;
	private String hardware;
	private String cymbals;
	private String sticks;
	
	
	public Drums(String manufacturer, String model) {
		super(manufacturer, model);
		setType("Drums");
	}
	
	public Drums(){
		this(null, null);
	}
	
	public String getBassDrum(){
		return bassDrum;
	}
	
	public String getFloorDrum(){
		return floorDrum;
	}
	
	public String getSnareDrum(){
		return snareDrum;
	}
	
	public String getHardware(){
		return hardware;
	}
	
	public String getCymbals(){
		return cymbals;
	}
	
	public String getDrumStricks(){
		return sticks;
	}
	
	public void setBassDrum(String bassDrum){
		this.bassDrum = bassDrum;
	}
	
	public void setFloorDrum(String floorDrum){
		this.floorDrum = floorDrum;
	}
	
	public void setSnareDrum(String snareDrum){
		this.snareDrum = snareDrum;
	}
	
	public void setHardware (String hardware){
		this.hardware = hardware;
	}
	
	public void setCymbals(String cymbals){
		this.cymbals = cymbals;
	}
	
	public void setDrumSticks(String sticks){
		this.sticks = sticks;
	}
	
	
	
	
	
	

}
