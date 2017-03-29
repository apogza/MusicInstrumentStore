package Managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import Instruments.Instrument;
import Managers.Interfaces.IFileManager;

public class JsonFileManager implements IFileManager {

	private Gson gson;
	private File fileFolder;
	private int maxId;

	public JsonFileManager(String folder){
		fileFolder = new File(folder);
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	/**
	 * Go through every json file
	 * Create an instance of the instrument
	 * The name of the file contains the id of the instrument and its type(i.e. 44-ElectricGuitar.json)
	 * @return
	 * @throws IOException
	 */
	@Override
	public Collection<Instrument> readInstruments() throws IOException {
		Vector<Instrument> instruments = new Vector<Instrument>();
		
		for(File file : fileFolder.listFiles()){
			Instrument instrument = readInstrumentFile(file);
			
			if(instrument != null)
				instruments.add(instrument);
			
			//set the max id
			maxId = (instrument.getCatalogNumber() > maxId) ? instrument.getCatalogNumber() : maxId;
		}
		return instruments;
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	private Instrument readInstrumentFile(File file)
	{
		String[] fileNameParts = file.getName().split("-");
		Instrument instrument = null;
		
		//the filename consists of two parts
		if(fileNameParts.length == 2)
		{
			//the first part of the filename is the catalog id of the instrument
			//the second part of the filename contains the classname of the instrument
			//the two are separated by a '-'
			//we need to strip the filename from the extension
			String className = "Instruments." + fileNameParts[1].substring(0, fileNameParts[1].indexOf('.'));
			//create an instance of the json file
			instrument = getInstrumentFromJsonFile(String.format("%s/%s", fileFolder.getPath(), file.getName()), className);
		}
		return instrument;
	}
	
	/**
	 * Convert json to an instrument object
	 * @param filename
	 * @param className
	 * @return
	 */
	private Instrument getInstrumentFromJsonFile(String filename, String className) {
		Instrument instrument = null;
		
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			instrument = (Instrument) gson.fromJson(bufferedReader, Class.forName(className));
			
			bufferedReader.close();
		}
		catch(JsonSyntaxException ex){
			System.err.println(String.format("Bad JSON format in file %1", filename));
		}
		catch(ClassNotFoundException ex){
			System.err.println(String.format("Bad class name %1", className));
		}
		catch (FileNotFoundException ex){
			System.err.println(String.format("Bad JSON format in file %1", filename));
		}
		catch(IOException ex){
			System.err.println(String.format("Error reading file %1", filename));
		}
		
		return instrument;
	}
	
	/*
	 * 
	 */
	private void createFolder() throws IOException{
		if(!fileFolder.exists() && fileFolder.mkdir()){
			throw new IOException("Cannot find or create instrument file folder.");			
		}
	}
	
	
	/**
	 * To be used in order to clear all files in the directory
	 */
	private void clearFiles()
	{
		File[] files = fileFolder.listFiles();
		if(files != null){
			for(File file : files){
				if(file != null)
					file.delete();
			}
		}
	}
	
	/**
	 * The method tells us what the max ID was
	 * We will use it as a base for future instruments to be added.
	 * @return
	 */
	public int getMaxId(){
		return maxId;
	}
	
	@Override
	public void saveInstruments(Collection<Instrument> instruments) throws IOException {
		//first, create the folder if it does not exists
		createFolder();
		//second, delete all existing files
		clearFiles();
		
		FileWriter fileWriter = null;
		
		for(Instrument instrument : instruments){
			//save the file to the instruments folder
			fileWriter = new FileWriter(String.format("%s/%s-%s.json", 
					fileFolder.getPath(), instrument.getCatalogNumber(), instrument.getClass().getSimpleName()));
			
			fileWriter.write(gson.toJson(instrument));
			fileWriter.close();
		}
	}
	
	@Override
	public String getFolder() {
		return fileFolder.getPath();
	}

	@Override
	public void setFolder(String folder) {
		this.fileFolder = new File(folder);
	}
}
