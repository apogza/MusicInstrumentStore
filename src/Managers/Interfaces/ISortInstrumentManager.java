package Managers.Interfaces;

public interface ISortInstrumentManager extends IInstrumentManager {
	
	/**
	 * Print the instruments ordered by type
	 */
	void sortByType();
	
	/**
	 * Print the instruments ordered by manufacturer
	 */
	void sortByManufacturer();
	
	/**
	 * Print the instruments ordered by price
	 */
	void sortByPrice();
	
}
