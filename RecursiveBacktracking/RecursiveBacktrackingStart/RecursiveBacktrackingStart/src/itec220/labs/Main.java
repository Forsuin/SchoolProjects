package itec220.labs;

import java.util.List;

public class Main {

	private static final String FILE_INPUT_PATH = "resources/files/input/";
	public static void main(String[] args) {
	

		SentenceFinder sf = new SentenceFinder(FILE_INPUT_PATH+"words.txt");
		
		List<String> lines = FileUtility.readFile(FILE_INPUT_PATH + "strings.txt");
		//System.out.println(sf.findSentence("ihaveanagreement")) ;
		
		lines.forEach((n) -> { System.out.println(sf.findSentence(n)) ;  });	    
		
	}

}
