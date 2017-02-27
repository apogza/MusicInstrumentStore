package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Managers.InstrumentManager;
import Managers.SearchInstrumentManager;
import Managers.SortInstrumentManager;
import Managers.Interfaces.ISearchInstrumentManager;
import Managers.Interfaces.ISortInstrumentManager;

public class Store {
	public static void main(String[] args)throws IOException{
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		
		ISearchInstrumentManager searchManager = new SearchInstrumentManager(inReader);
		ISortInstrumentManager sortManager = new SortInstrumentManager(inReader);
		
		InstrumentManager instrumentManager = new InstrumentManager(inReader, sortManager, searchManager);

		try{
			System.out.println("Welcome to the Music Store");
			instrumentManager.menuLoop();
			System.out.println("Goodbye and come back soon!");
		}
		catch(IOException ex){
			System.err.println("Caught IOException:" + ex.getMessage());
		}
		finally{
			inReader.close();
		}
		
		
	}
	

}
