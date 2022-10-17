package itec220.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileUtility {
	
	
	/**
	 * Write all the lines in the list to the file indicated by filename.
	 * If the is an error it returns false
	 * @param  file the name of the file to write to
	 * @return true is it is successful writing the file
	 * 
	 */
	public static boolean writeToFile(String fileName, List<String> lines )
	{
		System.out.println(lines.size());
		Path file = Paths.get(fileName);
		try {
			Files.write(file, lines, StandardCharsets.UTF_8);
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Read the file indicated by filename.
	 * The file will be a single string each line will be separated by a space.
	 * If the is an error it returns null
	 * @param  file the name of the file whose contents read
	 * @return a string with the entire file contents
	 * 
	 */
	public static String readFileAsSingleString(String fileName)
	{
		//String builder example
		//Strings are immutable
		// it is better to use StringBuilder when you need to append things
		// Exact time a string is concatenated it creates a new string
		// this can be very costly in terms of processing
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = "";

			while ((line = br.readLine()) != null) {

				sb.append(line);
				sb.append(" ");

			}
			// remove extra final space
			return sb.substring(0,sb.length()-1);
		} catch (FileNotFoundException e) {
			System.out.print(fileName + " File Not found");

		} catch (IOException e) {
			e.printStackTrace();

		}
		// file not read so return null
		// could throw exception instead
		return null;
	}
	/**
	 * Read the file indicated by filename into a list of strings.
	 * The file will have each line as a separate string.
	 * If the is an error it returns an empty list
	 * @param  file the name of the file to read 
	 * @return a list of strings with every line of the file
	 * 
	 */
	public static List<String> readFile(String fileName)
	{
		List<String> lines = Collections.emptyList();
		  try
		    {
		   
		      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		    }
		    catch (IOException e)
		    {		 		    
		      e.printStackTrace();
		    }
		  return lines;
	}
	/**
	 * Compares two files to see if they contain the same strings.
	 * If the is an error it returns false
	 * @param  file1 the name of the first file to compare 
	 * @param  file2 the name of the second file to compare 
	 * @return true the files contain the same things - same order
	 * 
	 */
	public static boolean compare(String fileName1, String fileName2) 

    {   
		List<String> lines1;
		List<String> lines2;
		try {
			lines1 = readFile(fileName1);
			lines2 = readFile(fileName2);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		if(lines1.size() != lines2.size())
		{
			System.out.println("Size Error");
			return false;
		}
         
     for (int i = 0; i < lines1.size(); i++) {
    	 
		if(!lines1.get(i).equals(lines2.get(i)))
		{
			System.out.println("line1:" +lines1.get(i));
			System.out.println("line2:" +lines2.get(i));
			return false;
		}
	} 
  
     // made it this far
     // files must be the same
     return true;
    }
}

