package itec220.labs;

import java.util.HashSet;
import java.util.List;

public class SentenceFinder {

	HashSet<String> words = new HashSet<String>();

	public SentenceFinder(String wordsFileName) {
		super();		
		List<String> lines = FileUtility.readFile(wordsFileName);
		lines.forEach((n) -> {words.add(n.toLowerCase()); });	    
	  
	}  
	
	/*
	* Input: Take a string with no spaces
	*  Return a set of valid words broken up or "There is no sentence"
	* 
	*
	*/
	public String findSentence(String text)
	{
		String result = findSentenceR("", text);
		
		return (result != null) ? result : "There is no sentence"; 
	}
	
	// Create your method here...
	public String findSentenceR(String completed, String rest)
	{
		String result = "";
		
		for(int i = 0; i < rest.length(); i++) {
			if(words.contains(rest.substring(0, i))) {
				result = findSentenceR(completed + rest.substring(0, i), rest.substring(i));
			}
		}
		
		return (result != null) ? result : null;
	}
	
	
}
