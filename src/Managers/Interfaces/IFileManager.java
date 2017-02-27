package Managers.Interfaces;

import java.io.IOException;

import ConsoleRepresenters.InstrumentRepresenter;

public interface IFileManager {
	
	/**
	 * Read instruments info from file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String[] readInstrumentsFile() throws IOException;
	
	/**
	 * 
	 * @param instrumentRepresenter
	 */
	public void addInstrumentToFile(InstrumentRepresenter instrumentRepresenter);
	
	/**
	 * 
	 * @param catalogId
	 */
	public void removeInstrumentFromFile(int catalogId);
	
	/**
	 * 
	 * @return
	 */
	public String getFileName();
	
	/**
	 * 
	 * @param fileName
	 */
	
	public void setFileName(String fileName);
}
