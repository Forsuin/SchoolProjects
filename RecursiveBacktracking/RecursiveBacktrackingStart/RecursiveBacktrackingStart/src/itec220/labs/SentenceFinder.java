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
		//call your method here
		return null;
	}
	
	// Create your method here...
	public String findSentenceR(String text)
	{
		
		return null;
		
	}
	
	
}
