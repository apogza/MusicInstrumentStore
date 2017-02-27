package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.AcousticGuitar;
import Utils.StringUtils;

public class AcousticGuitarRepresenter extends GuitarRepresenter {

	private AcousticGuitar instrument;
	
	public AcousticGuitarRepresenter(BufferedReader inReader, AcousticGuitar instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setBackAndSlides(getStringValue("Back and Sides"));
		instrument.setNutWidth(getStringValue("Nut Width"));
		instrument.setScale(getStringValue("Scale"));
		instrument.setTopWood(getStringValue("Top Wood"));
		
	}
	
	public String getInfo(){
		return super.getInfo()
				+ StringUtils.concatenateWithSeparator("|", 
						instrument.getBackAndSides(), 
						instrument.getNutWidth(),
						instrument.getScale(),
						instrument.getTopWood());
	}
	
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setBackAndSlides(instrumentInfo.poll());
		instrument.setNutWidth(instrumentInfo.poll());
		instrument.setScale(instrumentInfo.poll());
		instrument.setTopWood(instrumentInfo.poll());
	}
	
	public String print(){
		return super.print() 
				+ "\nBack and Sides: " + instrument.getBackAndSides()
				+ "\nNut Width: " + instrument.getNutWidth()
				+ "\nScale: " + instrument.getScale()
				+ "\nTop Wood: " + instrument.getTopWood();
	}

}
