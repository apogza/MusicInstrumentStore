package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Managers.InstrumentManager;
import Managers.JsonFileManager;
import Managers.SearchInstrumentManager;
import Managers.SortInstrumentManager;
import Managers.Interfaces.IFileManager;
import Managers.Interfaces.IInstrumentManager;
import Managers.Interfaces.ISearchInstrumentManager;
import Managers.Interfaces.ISortInstrumentManager;

public class Store {
	public static void main(String[] args) throws IOException{
		String instrumentFolder = "instruments";
		
		BufferedReader inReader = null;
		
		try{
			inReader = new BufferedReader(new InputStreamReader(System.in));
			ISearchInstrumentManager searchManager = new SearchInstrumentManager(inReader);
			ISortInstrumentManager sortManager = new SortInstrumentManager(inReader);
			IFileManager fileManager = new JsonFileManager(instrumentFolder);

			IInstrumentManager instrumentManager = new InstrumentManager(inReader, sortManager, searchManager, fileManager);
			
			System.out.println("Welcome to the Music Store");
			instrumentManager.run();
			System.out.println("Goodbye and come back soon!");
		}
		catch(IOException ex){
			System.err.println("Caught IOException:" + ex.getMessage());
		}
		finally{
			if(inReader != null)
				inReader.close();
		}
		
		
	}
	

}
