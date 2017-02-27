package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Keys;
import Utils.StringUtils;

public class KeysRepresenter extends InstrumentRepresenter {
	
	private Keys instrument;
	
	public KeysRepresenter(BufferedReader inReader, Keys instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setDimensions(getStringValue("Dimensions"));
	}
	
	@Override 
	public String getInfo(){
		return super.getInfo() + StringUtils.concatenateWithSeparator("|", instrument.getDimensions()); 
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		instrument.setDimensions(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() + "\nDimensions: " + instrument.getDimensions();
	}
}
