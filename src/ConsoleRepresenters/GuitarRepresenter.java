package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.Guitar;
import Utils.StringUtils;

public abstract class GuitarRepresenter extends StringsRepresenter {
	
	private Guitar instrument;
	
	public GuitarRepresenter(BufferedReader inReader, Guitar instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setCaseIncluded(getStringValue("Case Included"));
		instrument.setNeckMaterial(getStringValue("Neck Material"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() 
				+ StringUtils.concatenateWithSeparator("|", 
						instrument.getCaseIncluded(), instrument.getNeckMaterial());
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setCaseIncluded(instrumentInfo.poll());
		instrument.setNeckMaterial(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() + "\nCase Included: " + instrument.getCaseIncluded()
			+"\nNeck Material: " + instrument.getNeckMaterial();
	}
}
