package itec220.labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 * @author Robert Ward
 *
 */
public class Main {

	private static final String FILE_INPUT_PATH = "resources/files/input/";
	private static final String FILE_OUTPUT_PATH = "resources/files/output/";
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Step 1 Link your stack project to the project
				
		//Step 2 Implement brute force span method and Pass all basic unit tests
		
		//Step 3 Implement brute stack based span method and Pass all basic unit tests
		
		//Step 4 Update main to read and write files just first file
		
		//Step 5 Uncomment files to try all three
		
	 
		ArrayList<String> files = new ArrayList<String>();
		 
		// First Day (85) 2/11/2021
		// Last Day (100) 2/22/2021
		// Daily Stock Prices 85, 75, 60, 70, 60, 80 ,100
		// Expected Span
//		2/22/2021,100 Span 7
//		2/19/2021,80  Span 5 
//		2/18/2021,60  Span 1
//		2/17/2021,70  Span 2 
//		2/16/2021,60  Span 1 
//		2/12/2021,75  Span 1 
//		2/11/2021,85  Span 1 (First Day always 1)
		files.add(FILE_INPUT_PATH + "TestDailyStockPrice.txt");
		files.add(FILE_INPUT_PATH + "PeletonDailyStockPrice.txt");
		files.add(FILE_INPUT_PATH + "AmazonDailyStockPrice.txt");
		files.add(FILE_INPUT_PATH + "GoogleDailyStockPrice.txt");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		for (String fileName : files) {
			StockSpan sp = new StockSpan();
			//fill in code to get list of prices
			
			readFile(fileName, sp, formatter);
			
			//fill in code to print spans to console
			sp.print();
			
			ArrayList<String> output = new ArrayList<String>();
			//fill in code to write to new file
			writeSpans(FILE_OUTPUT_PATH + "testOutput.txt", sp, formatter);
		}
		 
		

		 
	}

	
	public static void readFile(String fileName,StockSpan sp,DateTimeFormatter formatter )
	{
				
		ArrayList<String> lines = FileUtility.readFile(fileName);
		Collections.reverse(lines); // Days are need to start with oldest day
		
		for (int i = 0; i < lines.size(); i++) {
			String[] fields = lines.get(i).split(",");
			sp.addPrice(Double.parseDouble(fields[1]), LocalDate.parse(fields[0],formatter) );
		}
		
	}
	public static void writeSpans(String fileName, StockSpan sp, DateTimeFormatter formatter)
	{
				
		ArrayList<String> lines = new ArrayList<>();
		for (int i = 0;  i < sp.numberofDays(); i++) {
			lines.add(String.format("%s,%d",sp.getDate(i).format(formatter) , sp.getSpan(i))); 
		    //Test line
			// System.out.println(String.format("%s,%d", sp.getDate(i).format(formatter), sp.getSpan(i)));
			
		}
		
		FileUtility.writeToFile(fileName, lines);
	}
}
