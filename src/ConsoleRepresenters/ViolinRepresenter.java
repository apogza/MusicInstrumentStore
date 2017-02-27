package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Violin;
import Utils.StringUtils;

public class ViolinRepresenter extends StringsRepresenter {

	private Violin instrument;
	
	public ViolinRepresenter(BufferedReader inReader, Violin instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setBackAndSides(getStringValue("Back and Sides"));
		instrument.setSize(getNumberIntValue("Size"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() +
				StringUtils.concatenateWithSeparator("|", 
						instrument.getBackAndSides(),
						String.valueOf(instrument.getSize()));
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setBackAndSides(instrumentInfo.poll());
		instrument.setSize(Integer.parseInt(instrumentInfo.poll()));
	}
	
	@Override
	public String print(){
		return super.print() + "\nBack and Sides: " + instrument.getBackAndSides()
			+ "\nSize: " + String.valueOf(instrument.getSize());
	}

}
