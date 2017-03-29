package Managers.Interfaces;

import java.io.IOException;

import ConsoleRepresenters.InstrumentRepresenter;

public interface IInstrumentManager {
	
	 /**
	  * 
	  * @throws IOException
	  */
	public void run() throws IOException;
	
	/**
	 * Add a new file
	 * @param instrument
	 */
	public void addInstrument(InstrumentRepresenter instrument);
	
	/**
	 * Remove an existing file
	 * @param instrument
	 */
	public void removeInstrument(InstrumentRepresenter instrument);
	

}
