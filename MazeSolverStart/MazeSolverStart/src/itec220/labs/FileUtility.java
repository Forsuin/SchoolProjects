package itec220.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
	
	
	
	public static ArrayList<String> readFileResouurce(String filename)
	{
		List<String> list = null; 
		Path path;
		try {
			 //Uncomment to Show path and resource info 
			 //System.out.println(FileUtility.class.getResource(filename));
			path = Paths.get(FileUtility.class.getResource(filename).toURI());
			list = Files.readAllLines(path);
		} catch (URISyntaxException e) {
			System.out.println("Error Bad URL");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Resource Not Found");
			e.printStackTrace();
		}
		
		return new ArrayList<>(list);
	}
	
	public static boolean writeToFile(String fileName, String line )
	{
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(line);
		return writeToFile(fileName,lines);
	}
	
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
	
	public static ArrayList<String> readFile(String fileName)
	{
		ArrayList<String> lines = null;
		  try
		    {
		   
		      lines = new ArrayList<>( Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8));
		    }
		    catch (IOException e)
		    {		 		    
		      e.printStackTrace();
		    }
		  return lines;
	}
	public static boolean compare(String fileName1, String fileName2) 

    {   
		List<String> lines1;
		List<String> lines2;
		try {
			lines1 = FileUtility.readFile(fileName1);
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

