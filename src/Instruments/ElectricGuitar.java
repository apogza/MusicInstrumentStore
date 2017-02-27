package Instruments;

public class ElectricGuitar extends Guitar {
	
	protected String body;
	protected String bridgeTremolo;
	protected int frets;
	protected String machineHeads;
	protected String pickGuard;
	protected String pickUps;
	protected boolean badNumber;
	
	public ElectricGuitar(String manufacturer, String model){
		super(manufacturer, model);
		setType("Electric Guitar");
	}
	
	/**
	 * Zero argument constructor
	 */
	public ElectricGuitar(){
		this(null,null);
	}
	

	/**
	 * The method returns the body of the electric guitar.
	 * @return a string that represents the body of the electric guitar.
	 */
	public String getBody(){
		return body;
	}
	
	/**
	 * The method returns bridgeTremolo of the electric guitar.
	 * @return a string that represents the bridgeTremolo of the electric guitar.
	 */
	public String getBridgeTremolo(){
		return bridgeTremolo;
	}
	
	/**
	 * The method returns the frets of the electric guitar.
	 * @return the number of frets the electric guitar has.
	 */
	public int getFrets(){
		return frets;
	}
	
	/**
	 * The method returns the machineHeads of the electric guitar.
	 * @return a string that represents the machineHeads of the electric guitar.
	 */
	public String getMachineHeads(){
		return machineHeads;
	}
	
	/**
	 * The method returns the pick guard of the electric guitar.
	 * @return a string that represents the pick guard of the electric guitar.
	 */
	public String getPickGuard(){
	    return pickGuard;
	}
	
	/**
	 * The method returns the pickUps of the electric guitar.
	 * @return a string that represents the pickUps of the electric guitar.
	 */
	public String getPickUps(){
		return pickUps;
	}
	
	/**
	 * The method will set the body to the input provided.
	 * @param body
	 */
	public void setBody(String body){
        this.body = body;
	}
	
	/**
	 * The method will set the bridgeTremolo to the input provided.
	 * @param bridgeTremolo
	 */
	public void setBridgeTremolo(String bridgeTremolo){
		this.bridgeTremolo = bridgeTremolo;
	}
	
	/**
	 * The method will set the number of frets to the number provided.
	 * @param frets
	 */
	public void setFrets(int frets){
	    if(frets >= 18)
	        this.frets = frets;
	    else
	        throw new IllegalArgumentException("No electric guitar has fewer than 18 frets."); 
	}
	
	/**
	 * The method will set the machineHeads to the input provided.
	 * @param machineHeads
	 */
	public void setMachineHeads(String machineHeads){
	    this.machineHeads = machineHeads;
	}
	
	/**
	 * The method will set the pickGuard to the input provided.
	 * @param pickGuard
	 */
	public void setPickGuard(String pickGuard){
		this.pickGuard = pickGuard;
	}
	
	/**
	 * The method will set the pickUps to the input provided.
	 * @param pickUps
	 */
	public void setPickUps(String pickUps){
        this.pickUps = pickUps;
	}
}
