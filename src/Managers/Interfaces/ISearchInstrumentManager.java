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
	void searchInstrumentsByManufacturer(String manufacturer) throws IOException;
	
	/**
	 * Search by model
	 * @throws IOException
	 */
	void searchInstrumentsByModel(String model) throws IOException;
	
	/**
	 * Search by catalogNumber
	 * @throws IOException
	 */
	void searchInstrumentsByCatalogId(String catalogId) throws IOException;
	
}
