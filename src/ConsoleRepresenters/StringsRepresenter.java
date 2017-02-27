package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Strings;
import Utils.StringUtils;

public abstract class StringsRepresenter extends InstrumentRepresenter {

	private Strings instrument;
	
	public StringsRepresenter(BufferedReader inReader, Strings instrument) {
		super(inReader, instrument);
		
		this.instrument = instrument;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	
	@Override
	protected void getVariableValues()throws IOException{
		super.getVariableValues();
		
		instrument.setFingerboard(getStringValue("Fingerboard"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() 
				+ StringUtils.concatenateWithSeparator(instrument.getFingerboard(), "|");
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		this.instrument.setFingerboard(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() + "\nFingerboard: " + instrument.getFingerboard();
	}
}
