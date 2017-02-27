package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ConsoleRepresenters.AcousticGuitarRepresenter;
import ConsoleRepresenters.DrumsRepresenter;
import ConsoleRepresenters.ElectricGuitarRepresenter;
import ConsoleRepresenters.InstrumentRepresenter;
import ConsoleRepresenters.PianoRepresenter;
import ConsoleRepresenters.SynthesizerRepresenter;
import ConsoleRepresenters.ViolinRepresenter;
import Instruments.AcousticGuitar;
import Instruments.Drums;
import Instruments.ElectricGuitar;
import Instruments.Instrument;
import Instruments.Piano;
import Instruments.Synthesizer;
import Instruments.Violin;
import Managers.Interfaces.IInstrumentManager;
import Managers.Interfaces.ISearchInstrumentManager;
import Managers.Interfaces.ISortInstrumentManager;
import Utils.ConsoleUtils;


/**
 * The class is basically a CLI to add, edit and remove instruments 
 * 
 * @author apogza
 *
 */
public class InstrumentManager implements IInstrumentManager {
	
	private Map<Integer, InstrumentRepresenter> catalog;
	
	private ISortInstrumentManager sortManager;
	private ISearchInstrumentManager searchManager;
	private BufferedReader inReader;
	
	
	private int catalogNumber;
	
	/**
	 * Two-parameter constructor 
	 */
	public InstrumentManager(BufferedReader bufferedReader, ISortInstrumentManager sortManager, ISearchInstrumentManager searchManager) {
		this.sortManager = sortManager;
		this.searchManager = searchManager;
		inReader = bufferedReader;
		
		catalog = new HashMap<Integer, InstrumentRepresenter>();
		this.catalogNumber = 1;
	}
	
	/**
	 * This is the menu that the user will see when he/she
	 * starts the program.It prompts them to choose an operation.
	 * @return choice
	 * @throws IOException
	 */
	public int getMenuChoice() throws IOException {
		
		System.out.println("\nPlease, select an operation(type 1, 2, 3, 4, 5, 6)");
		System.out.println("1. Add an instrument");
		System.out.println("2. Search for an instrument");
		System.out.println("3. Sort catalog");
		System.out.println("4. Modify an instrument's info");
		System.out.println("5. Remove an instrument");
		System.out.println("6. Quit the program");
		
		return ConsoleUtils.getNumIntValue("Enter your choice", inReader);
	}
	
	/**
	 * Display the menu, get the user choice and process it
	 * @throws IOException
	 */
	public void menuLoop()throws IOException {
		int choice = 0;
		do{
			choice = getMenuChoice();
			processMenuChoice(choice);
		} while(choice < 6);
	}
	
	/**
	 * This method will process user's main menu choice.
	 * @param choice
	 * @throws IOException
	 */
	public void processMenuChoice(int choice) throws IOException{
		switch (choice){
		case 1: 
			getInstrumentsFromUser();
			break;
		case 2:
			int searchChoice = searchManager.getMenuChoice();
			searchManager.processMenuChoice(searchChoice);
			break;
		case 3:
			int sortChoice = sortManager.getMenuChoice();
			sortManager.processMenuChoice(sortChoice);
			break;
		case 4:
			modifyInstrument();
			break;
		case 5:
			removeInstrument();
			break;
		case 6:
			break;
		default:
			System.out.println("Sorry, there is no such an option");
			break;
		}
	}
	
	/**
	 * This method will allow the user to enter instruments.
	 * @throws IOException
	 * 
	 */
	private void getInstrumentsFromUser()throws IOException{
		String choice = "y";
		while (!choice.toUpperCase().equals("N")){
			getInstrument(choice);
			System.out.println("Would you not like to add more instruments? (Y) to continue or (N) to quit?");
			choice = ConsoleUtils.getStringValue("Enter your choice (Y or N)", inReader);
		}
	}
	
	/**
	 * Modify and instrument
	 * @throws IOException
	 */
	private void modifyInstrument()throws IOException{
		if(catalog.isEmpty()){
			System.out.println("The catalog is empty");
			return;
		}
		
		int catalogNumber = ConsoleUtils.getNumIntValue("Enter Catalog Number", inReader);
		
		if(catalog.containsKey(catalogNumber))
			catalog.get(catalogNumber).getInfoFromUser();
		else
			System.out.println("No such instrument");
			
	}
	
	/**
	 * Remove an instrument
	 * @throws IOException
	 */
	private void removeInstrument()throws IOException{
		if(catalog.isEmpty()){
			System.out.println("The catalog is empty");
		}
		
		int catalogNumber = ConsoleUtils.getNumIntValue("Enter Catalog Number", inReader);
		if(catalog.containsKey(catalogNumber))
			removeInstrument(catalog.get(catalogNumber));
		else
			System.out.println("No such instrument");
	}
	
	/**
	 * This method will add the kind of an instrument
	 * the user wants to put in the catalog.
	 * 
	 * @param choice
	 * @throws IOException
	 */
	public void getInstrument(String choice) throws IOException {
		if (choice.toUpperCase().equals("N")) return;
		else if (!choice.toUpperCase().equals("Y")) {
				System.out.println("Sorry: this is not an available choice");
				return;
		}
		else {
		 	Instrument instrument = null;
		 	InstrumentRepresenter representer = null;
		 	
		 	switch(classifyInstrument()){
		 	case 1 : 
		 		instrument = new AcousticGuitar();
		 		representer = new AcousticGuitarRepresenter(inReader, (AcousticGuitar)instrument);
		 		break;
		 	case 2 : 
		 		instrument = new ElectricGuitar();
		 		representer = new ElectricGuitarRepresenter(inReader, (ElectricGuitar)instrument);
		 		break;
		 	case 3 : 
		 		instrument = new Violin();
		 		representer = new ViolinRepresenter(inReader, (Violin)instrument);
		 		break;
		 	case 4 : 
		 		instrument = new Drums();
		 		representer = new DrumsRepresenter(inReader, (Drums)instrument);
		 		break;
		 	case 5 :
		 		instrument = new Piano();
		 		representer = new PianoRepresenter(inReader, (Piano)instrument);
		 		break;
		 	case 6 :
		 		instrument = new Synthesizer();
		 		representer = new SynthesizerRepresenter(inReader, (Synthesizer)instrument);
		 		break;
		 	case 7 : break;
		 	default : 
		 		System.out.println("Not an available choice");
		 		break;
		 	}
		 	if(instrument != null && representer != null)
		 	{
		 		representer.getInfoFromUser();
		 		//add the instrument
		 		addInstrument(representer);
		 	}
	 	}
	}
	
	/**
	 * The method will prompt the user to specify
	 * the kind of an instrument she wants to add.
	 * @return an integer that represents the type of an instrument
	 * @throws IOException
	 * 
	 * 
	 */
	private int classifyInstrument()throws IOException{
		System.out.println("\nWhat kind of an instrument you want to add?" + 
				"\nSelect 1, 2, 3, 4, 5, 6, or 7");
		System.out.println("1. An Acoustic Guitar");
		System.out.println("2. An Electric Guitar");
		System.out.println("3. Violin");
		System.out.println("4. A set of Drums");
		System.out.println("5. A Piano");
		System.out.println("6. A Synthesizer");
		System.out.println("7. Quit to main menu");
		
		return ConsoleUtils.getNumIntValue("Enter your choice", inReader);
	}

	@Override
	public void addInstrument(InstrumentRepresenter instrument) {
		instrument.setCatalogNumber(catalogNumber);
		
		catalog.put(catalogNumber, instrument);
		sortManager.addInstrument(instrument);
		searchManager.addInstrument(instrument);
		catalogNumber++;
	}

	@Override
	public void removeInstrument(InstrumentRepresenter instrument) {
		catalog.remove(instrument);
		sortManager.removeInstrument(instrument);
		searchManager.removeInstrument(instrument);
	}
}
