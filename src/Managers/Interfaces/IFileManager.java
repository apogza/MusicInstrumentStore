package Managers.Interfaces;

import java.io.IOException;
import java.util.Collection;

import Instruments.Instrument;

public interface IFileManager {
	
	/**
	 * Read instruments info from file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public Collection<Instrument> readInstruments() throws IOException;
	
	/**
	 * Save instruments to a file
	 * @param collection
	 */
	public void saveInstruments(Collection<Instrument> collection) throws IOException;
	
	/**
	 * Delete all instruments in the folder
	 */
	public void deleteInstruments();
	
	/**
	 * 
	 * @return
	 */
	public String getFolder();
	
	/**
	 * 
	 * @param fileName
	 */
	
	public void setFolder(String fileName);
}
