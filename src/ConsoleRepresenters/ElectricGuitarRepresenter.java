package ConsoleRepresenters;

import java.io.BufferedReader;
import java.io.IOException;

import Instruments.ElectricGuitar;
import Utils.StringUtils;

public class ElectricGuitarRepresenter extends GuitarRepresenter {

	private ElectricGuitar instrument;
	
	public ElectricGuitarRepresenter(BufferedReader inReader, ElectricGuitar instrument) {
		super(inReader, instrument);
		this.instrument = instrument;
	}
	
	public String getInfo(){
		return super.getInfo()
				+ StringUtils.concatenateWithSeparator("|", 
						instrument.getBody(),
						instrument.getBridgeTremolo(),
						String.valueOf(instrument.getFrets()),
						instrument.getMachineHeads(),
						instrument.getPickGuard(),
						instrument.getPickUps());
	}
	
	@Override
	protected void getVariableValues() throws IOException{
		super.getVariableValues();
		
		instrument.setBody(getStringValue("Body"));
		instrument.setBridgeTremolo(getStringValue("Bridge Tremolo"));
		instrument.setFrets(getNumberIntValue("Number of Frets"));
		instrument.setMachineHeads(getStringValue("Machine Heads"));
		instrument.setPickGuard(getStringValue("Pick Guard"));
		instrument.setPickUps(getStringValue("Pick Ups"));
	}
	
	@Override
	public void setInfo(String values){
		super.setInfo(values);
		
		instrument.setBody(instrumentInfo.poll());
		instrument.setBridgeTremolo(instrumentInfo.poll());
		instrument.setFrets(Integer.parseInt(instrumentInfo.poll()));
		instrument.setMachineHeads(instrumentInfo.poll());
		instrument.setPickGuard(instrumentInfo.poll());
		instrument.setPickUps(instrumentInfo.poll());
	}
}
