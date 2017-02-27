package Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * The class will hold static methods for manipulating strings
 * @author apogza
 *
 */
public class StringUtils {
	
	/**
	 * A method that tells you whether a string is null or empty
	 * @param str
	 * @return true / false
	 */
	public static boolean isNullOrEmpty(String str){
		return str == null || str.isEmpty();
	}
	
	/**
	 * Check whether the string is 0.0 or 0 that has been converted to a string
	 * @param str
	 * @return
	 */
	public static boolean isZero(String str){
		
		return str.equals("0.0") || str.equals("0");
	}
	
	/**
	 * The method will concatenate the given values using a separator
	 * 
	 * @param separator - the separator to be used
	 * @param values - the values
	 * @return
	 */
	public static String concatenateWithSeparator(String separator, String... values){
		StringBuilder sb = new StringBuilder();
		
		for(String value : values){
			if(!StringUtils.isNullOrEmpty(value) && StringUtils.isZero(value))
				sb.append(value);
			else
				sb.append("");
			//add the separator at the end of each value
			sb.append(separator);
		}
		
		return sb.toString();
	}
	
	/**
	 * The method is supposed to do the exact opposite to the method above
	 * Using a separator
	 * 
	 * @param separator
	 * @param strToTokenize
	 * @return
	 */
	public static Queue<String> tokenizeString(String separator, String strToTokenize){
		StringTokenizer tokenizer = new StringTokenizer(strToTokenize, separator);
		Queue<String> tokenQueue = new LinkedList<String>();		
		
		while(tokenizer.hasMoreTokens()){
				tokenQueue.add(tokenizer.nextToken());
		}
		
		return tokenQueue;
	}
}
