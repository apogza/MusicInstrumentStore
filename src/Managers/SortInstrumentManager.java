package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

import ConsoleRepresenters.InstrumentRepresenter;
import Managers.Interfaces.ISortInstrumentManager;
import Utils.ConsoleUtils;

/**
 * A class that we will use for sorting the catalog of instruments
 * @author apogza
 *
 */
public class SortInstrumentManager implements ISortInstrumentManager {

	
	//keep the instruments sorted by type
	private TreeSet<InstrumentRepresenter> sortedByType;
	//keep the instruments sorted by manufacturer
	private	TreeSet<InstrumentRepresenter> sortedByManufacturer;
	//keep the instruments sorted by price
	private TreeSet<InstrumentRepresenter> sortedByPrice;
	
	private BufferedReader inReader;
	
	public SortInstrumentManager(BufferedReader reader){
		sortedByType = new TreeSet<InstrumentRepresenter>(getTypeComparator()); 
		sortedByManufacturer = new TreeSet<InstrumentRepresenter>(getManufacturerComparator());
		sortedByPrice = new TreeSet<InstrumentRepresenter>(getPriceComparator());
		inReader = reader;
	}
	
	public int getMenuChoice() throws IOException {
		
		System.out.println("\nPlease, select a sort option(1, 2, or 3): ");
		System.out.println("1. Sort by instrument type");
		System.out.println("2. Sort by manufacturer");
		System.out.println("3. Sort by price");
		System.out.println("4. Quit to main menu");
			
		return ConsoleUtils.getNumIntValue("Enter your choice", inReader);
	}

	public void processMenuChoice(int choice) throws IOException {
		switch(choice){
		case 1: 
			sortByType();
			break;
		case 2:
			sortByManufacturer();
			break;
		case 3: 
			sortByPrice();
			break;
		case 4: 
			break;
		default : 
			System.out.println("Sorry, there is no such an option");
			break;
		}
	}
	
	@Override
	public void run() throws IOException{
		int choice = 0;
		do {
			choice = getMenuChoice();
			processMenuChoice(choice);
		} while(choice < 4);
	}
	
	/**
	 * The method will sort the instruments in the catalog by type.
	 */
	public void sortByType(){
		for(InstrumentRepresenter ir : sortedByType){
			System.out.println(ir.printForCatalogByType());
		}		
	}
	
	/**
	 * The method will sort the instruments in the catalog by manufacturer.
	 */
	public void sortByManufacturer(){
		for(InstrumentRepresenter ir : sortedByManufacturer){
			System.out.println(ir.printForCatalogByManufacturer());
		}		
	}
	
	/**
	 * The method will sort the instruments in the catalog by price.
	 */
	
	public void sortByPrice(){
		for(InstrumentRepresenter ir : sortedByPrice){
			System.out.println(ir.printForCatalogByPrice());
		}		
	}
	
	/**
	 * Compare instruments by their type
	 * @return
	 */
	private Comparator<InstrumentRepresenter> getTypeComparator()	{
		return (InstrumentRepresenter a, InstrumentRepresenter b)
					-> a.getInstrument().getInstrumentType()
							.compareToIgnoreCase(b.getInstrument().getInstrumentType());
	}
	
	/**
	 * Compare instruments by their manufacturer
	 * @return
	 */
	private Comparator<InstrumentRepresenter> getManufacturerComparator(){
		return (InstrumentRepresenter a, InstrumentRepresenter b)
					-> a.getInstrument().getManufacturer()
							.compareToIgnoreCase(b.getInstrument().getManufacturer());
	}
	
	/**
	 * Compare instruments by their price
	 * @return
	 */
	private Comparator<InstrumentRepresenter> getPriceComparator(){
		return (InstrumentRepresenter a, InstrumentRepresenter b) 
						-> Double.compare(a.getInstrument().getPrice(), b.getInstrument().getPrice());
	}

	@Override
	public void addInstrument(InstrumentRepresenter instrument) {
		sortedByManufacturer.add(instrument);
		sortedByType.add(instrument);
		sortedByPrice.add(instrument);
	}

	@Override
	public void removeInstrument(InstrumentRepresenter instrument) {
		sortedByManufacturer.remove(instrument);
		sortedByType.remove(instrument);
		sortedByPrice.remove(instrument);
		
	}
}
