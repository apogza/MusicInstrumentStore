package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.function.Function;

import ConsoleRepresenters.InstrumentRepresenter;
import Managers.Interfaces.ISearchInstrumentManager;
import Utils.ConsoleUtils;


public class SearchInstrumentManager implements ISearchInstrumentManager {

	private Map<String, Vector<InstrumentRepresenter>> manufacturerMap;
	private Map<String, Vector<InstrumentRepresenter>> modelMap;
	private Map<String, Vector<InstrumentRepresenter>> catalogNumberMap;
	
	private BufferedReader inReader;
	
	
	public SearchInstrumentManager(BufferedReader bufferedReader){
		manufacturerMap = new HashMap<String, Vector<InstrumentRepresenter>>();
		modelMap = new HashMap<String, Vector<InstrumentRepresenter>>();
		catalogNumberMap = new HashMap<String, Vector<InstrumentRepresenter>>();
		
		inReader = bufferedReader;
	}
	
	@Override
	public int getMenuChoice() throws IOException {
		int choice = '0';
		while(choice!= '4'){
			System.out.println("\nPlease, select a search option (1, 2, 3, 4)");
			System.out.println("1. Search by Manufacturer");
			System.out.println("2. Search by Model");
			System.out.println("3. Search by Catalog Number");
			System.out.println("4. Quit to main menu");
			
			choice = new Double(ConsoleUtils.getNumValue("Enter your choice", inReader)).intValue();		
		}
		
		return choice;
	}

	@Override
	public void processMenuChoice(int choice) throws IOException {
		switch(choice){
		case 1: 
			searchByManufacturer();
			break;
		case 2: 
			searchByModel();
			break;
		case 3: 
			searchByCatalogNumber();
			break;
		case 4: 
			break;
		default: 
			System.out.println("Sorry, there is no such an option");
			break;
		}
	}
	
	/**
	 * Search by manufacturer
	 * @throws IOException
	 */
	
	public void searchByManufacturer() throws IOException {
		searchInstrument("Manufacturer", manufacturerMap);
	}
	
	/**
	 * Search by model
	 * @throws IOException
	 */
	public void searchByModel() throws IOException {
		searchInstrument("Model", modelMap);
	}
	
	/**
	 * Search by catalogNumber
	 * @throws IOException
	 */
	public void searchByCatalogNumber() throws IOException{
		searchInstrument("Catalog Number", catalogNumberMap);
	}
	
	/**
	 * Private search that serves the public ones since the logic is quite similar
	 * @param prompt
	 * @param instrumentMap
	 * @throws IOException
	 */
	private void searchInstrument(String prompt, Map<String, Vector<InstrumentRepresenter>> instrumentMap) 
			throws IOException{
		
		boolean foundInstruments = false;
		
		String searchKey = Utils.ConsoleUtils.getStringValue(prompt, inReader);
		if(instrumentMap.containsKey(searchKey)){
			for(InstrumentRepresenter instrument : instrumentMap.get(searchKey)){
				System.out.println(instrument);
			}
			foundInstruments = true;
		}
		
		if(!foundInstruments){
			System.out.println("\nNo instruments found!");
		}
	}
	
	/**
	 * Add instrument to manufacturer map
	 * @param instrument
	 */
	private void addInstrumentManufacturer(InstrumentRepresenter instrument){
		addInstrumentToMap(instrument, (keyFunc) -> instrument.getInstrument().getManufacturer(), manufacturerMap);
	}
	
	/**
	 * Add instrument to model map
	 * @param instrument
	 */
	private void addInstrumentModel(InstrumentRepresenter instrument){
		addInstrumentToMap(instrument, (keyFunc) -> instrument.getInstrument().getModel(), modelMap);
	}
	
	/**
	 * Add instrument to catalogNumber map
	 * @param instrument
	 */
	private void addInstrumentCatalogNumber(InstrumentRepresenter instrument){
		addInstrumentToMap(instrument, (keyFunc) -> String.valueOf(instrument.getInstrument().getCatalogNumber()), catalogNumberMap);
	}
	
	/**
	 * A generic method used to add the same instrument to all existing maps 
	 * @param instrument
	 * @param keyFunction
	 * @param instrumentMap
	 */
	private void addInstrumentToMap(InstrumentRepresenter instrument, 
								Function<InstrumentRepresenter, String> keyFunction, 
								Map<String, Vector<InstrumentRepresenter>> instrumentMap){
		String key = keyFunction.apply(instrument);
		if(instrumentMap.containsKey(key)){
			instrumentMap.get(key).add(instrument);
		}
		else{
			Vector<InstrumentRepresenter> instrumentVector = new Vector<InstrumentRepresenter>();
			instrumentVector.add(instrument);
			instrumentMap.put(key, instrumentVector);
		}
	}
	
	private void removeInstrumentFromManufacturerMap(InstrumentRepresenter instrument){
		removeInstrumentFromMap(instrument, 
				(keyFunc) -> instrument.getInstrument().getManufacturer(), manufacturerMap);
	}
	
	private void removeInstrumentFromModelMap(InstrumentRepresenter instrument){
		removeInstrumentFromMap(instrument, 
				(keyFunc) -> instrument.getInstrument().getModel(), modelMap);
	}
	
	private void removeInstrumentFromCatalogNumberMap(InstrumentRepresenter instrument){
		removeInstrumentFromMap(instrument, 
				(keyFunc) -> String.valueOf(instrument.getInstrument().getCatalogNumber()), modelMap);
	}

	
	private void removeInstrumentFromMap(InstrumentRepresenter instrument,
											Function<InstrumentRepresenter, String> keyFunction,
											Map<String, Vector<InstrumentRepresenter>> instrumentMap){
		String key = keyFunction.apply(instrument);
		
		if(instrumentMap.containsKey(key)){
			instrumentMap.get(key).remove(instrument);	
		}		
	}

	@Override
	public void addInstrument(InstrumentRepresenter instrument) {
		addInstrumentManufacturer(instrument);
		addInstrumentModel(instrument);
		addInstrumentCatalogNumber(instrument);
	}

	@Override
	public void removeInstrument(InstrumentRepresenter instrument) {
		removeInstrumentFromCatalogNumberMap(instrument);
		removeInstrumentFromModelMap(instrument);
		removeInstrumentFromManufacturerMap(instrument);
	}
}
