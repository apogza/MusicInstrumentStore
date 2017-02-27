package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Synthesizer;
import Utils.StringUtils;

public class SynthesizerRepresenter extends KeysRepresenter {

	private Synthesizer instrument;
	
	public SynthesizerRepresenter(BufferedReader inReader, Synthesizer instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setMusicDatabase(getStringValue("Music Database"));
		instrument.setEffects(getStringValue("Effects"));
		instrument.setPowerSupply(getStringValue("Power Supply"));
		instrument.setStorageDevice(getStringValue("Storage Device"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() +
				StringUtils.concatenateWithSeparator("|", 
						instrument.getMusicDatabase(),
						instrument.getEffects(),
						instrument.getPowerSupply(),
						instrument.getStorageDevice());
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setMusicDatabase(instrumentInfo.poll());
		instrument.setEffects(instrumentInfo.poll());
		instrument.setPowerSupply(instrumentInfo.poll());
		instrument.setStorageDevice(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() 
				+ "\nMusic Database: " + instrument.getMusicDatabase() 
				+ "\nEffects: " + instrument.getEffects()
				+ "\nPower Supply: " + instrument.getPowerSupply()
				+ "\nStorage Device: " + instrument.getStorageDevice();
	}
}
