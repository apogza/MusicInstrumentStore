package Instruments;

import Utils.StringUtils;

/**
 * 
 * @author apogza
 * 
 * The class is at the heart of the whole inheritance hierarchy
 * All instrument will follow a java bean pattern. 
 * They provide getter and setter for every variable.
 *
 */

public abstract class Instrument {
	
	protected String type;
	protected String manufacturer;
	protected String model;
	
	protected int catalogNumber;
	protected double price;
	
		
	/**
	 * Two argument constructor 
	 * @param manufacturer
	 * @param model
	 */	
	public Instrument(String manufacturer, String model){
		this.manufacturer= manufacturer;
		this.model = model;
	}
	
	/**
	 * Getter for the instrument
	 * @return instrument type
	 */
	public String getInstrumentType(){
		return type;
	}
	
	/**
	 * Getter for the manufacturer
	 * @return
	 */
	public String getManufacturer(){
		return manufacturer;
	}
	
	/**
	 * Getter for the model
	 * @return the model
	 */
	public String getModel(){
		return model;
	}
	
	/**
	 * Getter for the price
	 * @return the price
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * Getter for the catalog number
	 * @return the catalog number
	 */
	public int getCatalogNumber(){
		return catalogNumber;
	}
	
	/**
	 * Setter for type
	 * @param type
	 */
	public void setType(String type)
	{
		if(!StringUtils.isNullOrEmpty(type))
			this.type = type;
	}
	
	/**
	 * Setter for the manufacturer
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer){
		if(!StringUtils.isNullOrEmpty(manufacturer))
			this.manufacturer = manufacturer;
	}
	
	/**
	 * Setter for the model
	 * @param model
	 */
	public void setModel(String model){
		if(!StringUtils.isNullOrEmpty(model))
			this.model = model;
	}
	
	/**
	 * Setter for the catalogNumber
	 * @param catalogNumber
	 */
	public void setCatalogNumber(int catalogNumber){
		this.catalogNumber = catalogNumber;
	}
	
	/**
	 * This method will set the price to the input given, unless the price 
	 * is negative or it is not a number.
	 * @param price
	 */
	public void setPrice(double price){
		if (price >= 0)
		    this.price = price;
		else
		    throw new IllegalArgumentException("Price should be greater than 0");
	}
}
