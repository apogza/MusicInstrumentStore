package Instruments;

public class Synthesizer extends Keys {
	
	protected String musicDatabase;
	protected String effects;
	protected String powerSupply;
	protected String storageDevice;
	
	public Synthesizer(String manufacturer, String model) {
		super(manufacturer, model);
		setType("Synthesizer");
	}
	
	public Synthesizer(){
		this(null, null);
	}
	
	public String getMusicDatabase(){
		return musicDatabase;
	}
	
	public String getEffects(){
		return effects;
	}
	
	public String getPowerSupply(){
		return powerSupply;
	}
	
	public String getStorageDevice(){
		return storageDevice;
	}
	
	public void setMusicDatabase(String musicDatabase){
		this.musicDatabase = musicDatabase;
	}
	
	public void setEffects(String effects){
		this.effects = effects;
	}
	
	public void setPowerSupply(String powerSupply){
		this.powerSupply = powerSupply;
	}
	
	public void setStorageDevice(String storageDevice){
		this.storageDevice = storageDevice;
	}
}
