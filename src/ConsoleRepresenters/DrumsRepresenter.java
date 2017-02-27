package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;
import Instruments.Drums;
import Utils.StringUtils;

public class DrumsRepresenter extends InstrumentRepresenter {

	private Drums instrument;
	
	public DrumsRepresenter(BufferedReader inReader, Drums instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setBassDrum(getStringValue("Bass Drum"));
		instrument.setFloorDrum(getStringValue("Floor Drum"));
		instrument.setSnareDrum(getStringValue("Snare Drum"));
		instrument.setHardware(getStringValue("Hardware"));
		instrument.setCymbals(getStringValue("Cymbals"));
		instrument.setDrumSticks(getStringValue("Sticks"));
	}
	
	@Override
	public String getInfo(){
		return super.getInfo() + 
				StringUtils.concatenateWithSeparator("|", 
						instrument.getBassDrum(),
						instrument.getFloorDrum(),
						instrument.getSnareDrum(),
						instrument.getHardware(),
						instrument.getCymbals(),
						instrument.getDrumStricks());
														
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setBassDrum(instrumentInfo.poll());
		instrument.setFloorDrum(instrumentInfo.poll());
		instrument.setSnareDrum(instrumentInfo.poll());
		instrument.setHardware(instrumentInfo.poll());
		instrument.setCymbals(instrumentInfo.poll());
		instrument.setDrumSticks(instrumentInfo.poll());
	}
	
	@Override
	public String print(){
		return super.print() +
				"\nBass Drum: " + instrument.getBassDrum() +
				"\nFloor Drum: " + instrument.getFloorDrum() +
				"\nSnare Drum: " + instrument.getSnareDrum() +
				"\nHardware: " + instrument.getHardware() +
				"\nDrum Sticks: " + instrument.getDrumStricks();
	}
}
