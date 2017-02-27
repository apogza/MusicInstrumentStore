package Utils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The class will provide implementation of methods to help with I/O
 * 
 * @author apogza
 *
 */
public class ConsoleUtils {
	
	/**
	 * The method retrieves a double value from a user.
	 * If we need to retrieve an int, convert the double to int in the caller method 
	 * 
	 * @param prompt - the message to show the user
	 * @param in - the BufferedReader
	 * @return - the double value entered by the user
	 * @throws IOException
	 */
	public static double getNumValue(String prompt, BufferedReader in) throws IOException{
		double result = 0;
		
		boolean badNumber = false;
		do{
			badNumber = false;
			try{
				System.out.print("\n" + prompt + ": ");
				String temp = in.readLine();
				if(!StringUtils.isNullOrEmpty(temp))
					result = Double.parseDouble(temp);
			}
			catch(NumberFormatException e){
				System.err.println("Please, enter valid numbers!");
				badNumber = true;
			}
		}
		while(badNumber == true);
		
		return result;
	}
	
	public static int getNumIntValue(String prompt, BufferedReader in) throws IOException{
		Double result = getNumValue(prompt, in);
		return result.intValue();
	}
	
	/**
	 * The method takes only
	 * @param prompt - The message to show the user
	 * @param in - the BufferedReader
	 * @return the string value entered by the user
	 * @throws IOException
	 */
	public static String getStringValue(String prompt, BufferedReader in) throws IOException{
		System.out.print("\n" + prompt + ": ");
		return in.readLine();
	}

}
