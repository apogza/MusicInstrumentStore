package Instruments;

public class AcousticGuitar extends Guitar {

	protected String backAndSides;
	protected String nutWidth;
	protected String scale;
	protected String topWood;
	
	public AcousticGuitar(String manufacturer, String model){
		super(manufacturer, model);
		setType("Acoustic Guitar");
	}
	
	public AcousticGuitar(){
		this(null, null);
	}
	
	/**
	 * The method returns the type of the acoustic guitar.
	 * @return a string that represents the back and slides of the
	 * acoustic guitar.
	 */
	public String getBackAndSides(){
		return backAndSides;
	}
	
	/**
	 * The method returns the backAndSlides of the acoustic guitar.
	 * @return a string that represents the nut width of the 
	 * acoustic guitar.
	 */
	public String getNutWidth(){
		return nutWidth;
	}
	
	/**
	 * The method returns the scale of the acoustic guitar.
	 * @return a string that represents the scale of the guitar.
	 */
	public String getScale(){
		return scale;
	}
	
	/**
	 * The method returns the topWood of the acoustic guitar.
	 * @return a string that represents the top wood of the guitar.
	 */
	public String getTopWood(){
		return topWood;
	}
	
	/**
	 * The method will set the backAndSlides to the input given.
	 * @param backAndSides
	 */
	public void setBackAndSlides(String backAndSides){
        this.backAndSides = backAndSides;
	}
	
	/**
	 * The method will set the nutWidth to the input given.
	 * @param n
	 */
	public void setNutWidth(String nutWidth){
        this.nutWidth = nutWidth;
	}
	
	/**
	 * The method will set the scale to the input given.
	 * @param scale
	 */
	public void setScale(String scale){
        this.scale = scale;
	}
	
	/**
	 * The method will set the topWood to the input given.
	 * @param topWood
	 */
	public void setTopWood(String topWood){
        this.topWood = topWood;
	}
}
