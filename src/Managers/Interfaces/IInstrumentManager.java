package Managers.Interfaces;

import java.io.IOException;

import ConsoleRepresenters.InstrumentRepresenter;

public interface IInstrumentManager {
	
	/**
	 * Displays a a list of choices to the user
	 * @return
	 * @throws IOException
	 */
	public int getMenuChoice() throws IOException;
	
	/**
	 * After the user has made their choice, process it
	 * 
	 * @param choice
	 * @throws IOException
	 */
	public void processMenuChoice(int choice) throws IOException;
	
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
