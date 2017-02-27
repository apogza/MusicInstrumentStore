package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Piano;
import Utils.StringUtils;

public class PianoRepresenter extends KeysRepresenter {

	private Piano instrument;
	
	public PianoRepresenter(BufferedReader inReader, Piano instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setType(getStringValue("Type"));
		instrument.setType(getStringValue("Keys"));
		instrument.setType(getStringValue("Bridges"));
		instrument.setType(getStringValue("Hammers"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() + 
				StringUtils.concatenateWithSeparator("|", 
						instrument.getType(),
						instrument.getKeys(),
						instrument.getBridges(),
						instrument.getHammers());
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setType(instrumentInfo.poll());
		instrument.setKeys(instrumentInfo.poll());
		instrument.setBridges(instrumentInfo.poll());
		instrument.setHammers(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() 
				+ "\nType: " + instrument.getType()
				+ "\nKeys: " + instrument.getKeys()
				+ "\nBridges: " + instrument.getBridges()
				+ "\nHammers: " + instrument.getHammers();
	}
}
