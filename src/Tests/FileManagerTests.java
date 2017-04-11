package Tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import Instruments.AcousticGuitar;
import Instruments.ElectricGuitar;
import Instruments.Instrument;
import Managers.JsonFileManager;
import Managers.Interfaces.IFileManager;

public class FileManagerTests {

	private IFileManager fileManager;
	
	public FileManagerTests() throws IOException {
		fileManager = new JsonFileManager("test/instruments/");
	}
	
	
	@Test
	public void testInstrumentToFile() throws IOException{
		Instrument acousticGuitar = new AcousticGuitar();
		acousticGuitar.setManufacturer("Yamaha");
		acousticGuitar.setCatalogNumber(1);
		
		Instrument electricGuitar = new ElectricGuitar();
		electricGuitar.setManufacturer("Ibanez");
		electricGuitar.setCatalogNumber(2);
		
		Collection<Instrument> instrumentList = new Vector<Instrument>();
		instrumentList.add(acousticGuitar);
		instrumentList.add(electricGuitar);
		
		fileManager.saveInstruments(instrumentList);
		
		instrumentList = fileManager.readInstruments();
		assertEquals(instrumentList.size(), 2);
		
		Instrument [] instrumentArray = instrumentList.toArray(new Instrument[instrumentList.size()]);
		
		assertEquals(instrumentArray[0].getInstrumentType(), "Acoustic Guitar");
		assertEquals(instrumentArray[1].getManufacturer(), "Ibanez");
		
		
	}
}
