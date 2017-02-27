package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;

import Instruments.Instrument;
import Utils.ConsoleUtils;
import Utils.StringUtils;

/**
 * A representer is simply a class that will do all the work
 * related to I/O for the instrument:
 * - getting input for the user
 * - setting variables once the input has been processed
 * 
 * @author apogza
 *
 */

public abstract class InstrumentRepresenter {
	
	private Instrument instrument;
	
	protected Queue<String> instrumentInfo;
	protected BufferedReader inReader;
	
	/**
	 * It is always necessary to specify the instance of the instrument
	 * @param instrument
	 */
	public InstrumentRepresenter(BufferedReader inReader, Instrument instrument){
		this.inReader = inReader;
		this.instrument = instrument;
	}
	
	/**
	 * Getter that gives back the catalog number of the instrument
	 * @return
	 */
	public int getCatalogNumber(){
		return instrument.getCatalogNumber();
	}
	
	/**
	 * Communicate the assigned catalog number back to the instrument
	 * @param catalogNumber
	 */
	public void setCatalogNumber(int catalogNumber){
		instrument.setCatalogNumber(catalogNumber);
	}
	
	/**
	 * Get the info for the instrument
	 * The method should be overridden by classes inheriting this one
	 * @return
	 */
	public String getInfo(){	
		return StringUtils.concatenateWithSeparator("|", instrument.getInstrumentType(),
											instrument.getManufacturer(),
											instrument.getModel(),
											String.valueOf(instrument.getCatalogNumber()),
											String.valueOf(instrument.getPrice()));
	}
	
	/**
	 * Getter for the instrument
	 * @return
	 */
	public Instrument getInstrument(){
		return instrument;
	}
	
	/**
	 * Set the info for the instrument from a string, it will be used to restore instrument from a file
	 * @param values
	 */
	public void setInfo(String values){
		instrumentInfo = StringUtils.tokenizeString("|", values);
		
		instrument.setType(instrumentInfo.poll());
		instrument.setManufacturer(instrumentInfo.poll());
		instrument.setModel(instrumentInfo.poll());
		instrument.setCatalogNumber(Integer.parseInt(instrumentInfo.poll()));
		instrument.setPrice(Double.parseDouble(instrumentInfo.poll()));
	}
	
	public final void getInfoFromUser() throws IOException{
		getVariableValues();
	}
	
	/**
	 * The method asks the user for the information common for all instruments
	 * 
	 * @throws IOException 
	 */
	protected void getVariableValues() throws IOException {
		System.out.println("Please, supply the needed information");
		
		instrument.setManufacturer(ConsoleUtils.getStringValue("Manufacturer", inReader));
		instrument.setModel(ConsoleUtils.getStringValue("Model", inReader));
		instrument.setPrice(ConsoleUtils.getNumValue("Price (in Euro)", inReader));
	}
	
	/**
	 * This method will print an instrument - instrument type first
	 * @return a string that holds the common information about an instrument.
	 */
	public String printForCatalogByType(){
		return ("\n" + instrument.getInstrumentType() + "\t" + instrument.getManufacturer() + "\n" +
				"Model: " + instrument.getModel() + "\t" + "Catalog Number: " + instrument.getCatalogNumber() + "\t" + 
				"Price: " + instrument.getPrice() + " euro");
	}
	
	/**
	 * This method will print an instrument - manufacturer first
	 * @return a string that holds the common information about an instrument.
	 */
	public String printForCatalogByManufacturer(){
		return("\n" + instrument.getManufacturer() + "\t" + instrument.getInstrumentType() + "\n" +
				"Model: " + instrument.getModel() + "\t" + "Catalog Number: " + instrument.getCatalogNumber() + "\t" + 
				"Price: " + instrument.getPrice() + " euro");
	}
	
	/**
	 * This method will print an instrument - price first
	 * @return a string that holds the common information about an instrument.
	 */
	public String printForCatalogByPrice(){
		return("\nPrice: " + instrument.getPrice() + " Euro" + "\t" + instrument.getManufacturer() + "\t" + 
				instrument.getInstrumentType() + "\n" + "Model: "	+ instrument.getModel() + "\t" +
				"Catalog Number: " + instrument.getCatalogNumber());
	}
	
	public String print(){
		return printForCatalogByType();
	}	
	
	/**
	 * A wrapper for the static method in ConsoleUtils for retrieving a string value
	 * We need to be sure that inReader is initialized
	 * @param prompt
	 * @return
	 * @throws IOException
	 */
	protected String getStringValue(String prompt) throws IOException{
		return ConsoleUtils.getStringValue(prompt, inReader);
	}
	
	/**
	 * A wrapper for the static method in ConsoleUtils for retrieving a number value
	 * We need to be sure that inReader is initialized
	 * @param prompt
	 * @return
	 * @throws IOException
	 */
	protected double getNumberValue(String prompt) throws IOException{
		return ConsoleUtils.getNumValue(prompt, inReader);
	}
	
	/**
	 * A wrapper for the static method in ConsoleUtils, but returning an integer
	 * @param prompt
	 * @return
	 * @throws IOException
	 */
	protected int getNumberIntValue(String prompt) throws IOException{
		return new Double(ConsoleUtils.getNumValue(prompt, inReader)).intValue();
	}
}
