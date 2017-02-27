package Instruments;

public class Piano extends Keys {
	
	protected String type;
	protected String keys;
	protected String bridges;
	protected String hammers;

	public Piano(String manufacturer, String model) {
		super(manufacturer, model);
		setType("Piano");
		
	}
	
	public Piano(){
		this(null, null);
	}
	
	public String getType(){
		return type;
	}
	
	public String getKeys(){
		return keys;
	}
	
	public String getBridges(){
		return bridges;
	}
	
	public String getHammers(){
		return hammers;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setKeys(String keys){
		this.keys = keys;
	}
	
	public void setBridges(String bridges){
		this.bridges = bridges;
	}
	
	public void setHammers(String hammers){
		this.hammers = hammers;
	}
}
