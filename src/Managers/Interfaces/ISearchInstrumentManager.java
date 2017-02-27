package Managers.Interfaces;
import java.io.IOException;


public interface ISearchInstrumentManager extends IInstrumentManager{
	
	/** 
	 * The search methods will simply print out the results that were found
	 */
	
	/**
	 * Search by manufacturer
	 * @throws IOException
	 */
	void searchByManufacturer() throws IOException;
	
	/**
	 * Search by model
	 * @throws IOException
	 */
	void searchByModel() throws IOException;
	
	/**
	 * Search by catalogNumber
	 * @throws IOException
	 */
	void searchByCatalogNumber() throws IOException;
	
}
