package itec220.labs;


public class Main {

	
	private static final int MAX_NUM_DECODE = 6;
	private static final String FILE_INPUT_PATH = "resources/files/input/";
	private static final String FILE_OUTPUT_PATH = "resources/files/output/";
	private static final String FILE_ENCODE_OUTPUT_PATH = "resources/files/testEncode/";
	
	public static void main(String[] args)  {
		
		// Step 1 Create MorseConverter the implements Converter interface
		//Error until you create MorseConverter class with Constructor
		MorseConverter mc = new MorseConverter("resources/files/input/MorseCodeTable.txt");
			
		// Step 2 Print the Key Value Pairs
		// print key value pairs notice there is no order
		mc.printKeyValuePairs();	
		
		// Step 3 and 4 can be used together
		// Both basicTest and Unit test can help you troubleshoot
		
		//Step 3  
		// Pass all Unit tests for morseTotext and textToMorse 
		//Step 4 
		// run basicTest(mc); basic test prints out console
		
		basicTest(mc); //<< Uncomment for step 3 (or during part 2)
		
		
		//Step 5
		// Complete decodeFileToFile
		//Once you have finished the code for you converter decode all the files
		//Decode all of the files by changing fileTestCount
		// Currently it decodes 0 test files
		// NOTE use F5 (Refresh) to see files in project
		// Open and look at them
		int fileTestCount = 6;
		decodeFileTest(mc, fileTestCount);
		
		//Step 6
		// Complete encodeFileToFile
		// Once you have decoded the files encode them back to the original form
		// encode all of the files by changing fileTestCount
		// Currently it encodes 0 test files
		// NOTE use F5 (Refresh) to see files in project
		int fileEncodeCount = 6;
		encodeFileTest(mc, fileEncodeCount);
		
		// Once you have encoded the files check if the match the original 
		// Currently it compares 0 test files
		int filesToCompare = 6;
		compareTestfile(filesToCompare);


				
	}
	/**
	 * Decodes some number of test files based on filesToDecode.
	 * For example if filesToDecode is 0 - 0 files are decoded
	 * Input file location is \resources\files\input
	 * Output file location is \resources\files\output
	 * Test input file name is QuoteXMorse.txt (Where X is 1,2,3,4,5,6)
	 * Test output file name is QuoteXDecoded.txt (Where X is 1,2,3,4,5,6)
	 * @param  mc to do conversion
     * @param  filesToDecode number of test files to convert
     */
	private static void decodeFileTest(MorseConverter mc, int filesToDecode)
	{
		if(filesToDecode > MAX_NUM_DECODE)
		{
			filesToDecode = MAX_NUM_DECODE;
		}
		
		for (int i = 1; i <= filesToDecode ; i++) {
			String inputPath = String.format("%sQuote%dMorse.txt",FILE_INPUT_PATH,i);
			String outputPath = String.format("%sQuote%d.txt",FILE_OUTPUT_PATH,i);
			System.out.printf("Decoding %s to %s%n",inputPath,outputPath);
			mc.decodeFileToFile(inputPath,outputPath);
		}
	}
	/**
	 * Decodes some number of test files based on filesToDecode.
	 * For example if filesToDecode is 0 - 0 files are decoded
	 * Input file location is \resources\files\input
	 * Output file location is \resources\files\output
	 * Test input file name is QuoteXDecoded.txt (Where X is 1,2,3,4,5,6)
	 * Test output file name is QuoteX.txt (Where X is 1,2,3,4,5,6)
	 * NOTE: Input Files must exist before calling 
	 * @param  mc MorseConverter to do conversion
     * @param  filesToDecode number of test files to convert
     */
	private static void encodeFileTest(MorseConverter mc, int filesToDecode)
	{
		if(filesToDecode > MAX_NUM_DECODE)
		{
			filesToDecode = MAX_NUM_DECODE;
		}
		
		for (int i = 1; i <= filesToDecode ; i++) {
			String inputPath = String.format("%sQuote%d.txt",FILE_OUTPUT_PATH,i);
			String outputPath = String.format("%sQuote%dMorse.txt",FILE_ENCODE_OUTPUT_PATH,i);
			System.out.printf("Decoding %s to %s%n",inputPath,outputPath);
			mc.encodeFileToFile(inputPath,outputPath);
		}
	}
	/**
	 * Compares some number of files based on filesToDecode returns 
	 * true if the are identical.
	 * For example if filesToCompare is 0 - 0 files are checked
	 * file1 location is \resources\files\input
	 * file2 location is \resources\files\testEncode
	 * file1 name is QuoteXMorse.txt (Where X is 1,2,3,4,5,6)
	 * file2 name is QuoteXMorse.txt (Where X is 1,2,3,4,5,6)
	 * NOTE: files must exist before calling 
	 * @param  filesToDecode number of test files to convert
     */
	private static void compareTestfile(int filesToCompare)
	{
		if(filesToCompare > MAX_NUM_DECODE)
		{
			filesToCompare = MAX_NUM_DECODE;
		}
		
		for (int i = 1; i <= filesToCompare ; i++) {
			String inputPath = String.format("%sQuote%dMorse.txt",FILE_INPUT_PATH,i);
			String outputPath = String.format("%sQuote%dMorse.txt",FILE_ENCODE_OUTPUT_PATH,i);
			System.out.printf("Compare %s to %s -Match Result: %b%n",inputPath,outputPath, FileUtility.compare(inputPath, outputPath));
			
		}
	}
	
	private static void basicTest(MorseConverter mc)
	{
		System.out.println();
		System.out.println("Encode:abc defg hijkl mnopq rst uvwxyz");
		System.out.println(mc.encodeText("abc defg hijkl mnopq rst uvwxyz"));
		System.out.println();
		System.out.println("Encode:abcdefghijklmnopqrstuvwxyz");
		System.out.println(mc.encodeText("abcdefghijklmnopqrstuvwxyz"));
		System.out.println();
		System.out.println("Encode Rick: Weddings are basically funerals with cake: ");
		System.out.println(mc.encodeText("Rick: Weddings are basically funerals with cake"));
		System.out.println();
		// Encode then decode
		System.out.println("Encode then Decode The: ");
		System.out.println(mc.decodeText(mc.encodeText("The")));	
		System.out.println();
		System.out.println("Encode then Decode Rick: Weddings are basically funerals with cake: ");
		System.out.println(mc.decodeText(mc.encodeText("Rick: Weddings are basically funerals with cake")));
	}
	
}
