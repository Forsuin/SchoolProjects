package itec220.labs;

import java.util.HashMap;
import java.util.List;

public class MorseConverter implements Converter {
	private HashMap<Character, String> charToMorse = new HashMap<Character, String>();
	private HashMap<String, Character> morseToChar = new HashMap<String, Character>();
	
	MorseConverter(String path){
		List<String> strings;
		
		try {
			strings = FileUtility.readFile(path);
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		for(String s : strings) {
			String[] split = s.split(strings.get(0));
			
			if(split.length == 0) {
				continue;
			}
			
			charToMorse.put(split[0].charAt(0), split[1]);
			morseToChar.put(split[1], split[0].charAt(0));
		}
	}
	
	@Override
	public void printKeyValuePairs() {
		System.out.println("Char to Morse Code");
		
		charToMorse.entrySet().forEach(entry ->{
			System.out.format("'%c' %s\n", entry.getKey(), entry.getValue());
		});
		
		System.out.println("\nMorse Code to Char");
		
		morseToChar.entrySet().forEach(entry ->{
			System.out.format("%s '%c'\n", entry.getKey(), entry.getValue());
		});
	}

	@Override
	public String encodeText(String textToEncode) {
		String encoded = "";
		
		char[] text = textToEncode.toLowerCase().toCharArray();
		
		for(int i = 0; i < text.length; i++) {
			encoded += charToMorse.get(text[i]);
			
			if(textToEncode.length() > 1 && i < text.length - 1) {
				encoded += ' ';
			}
		}
		
		return encoded;
	}

	@Override
	public String decodeText(String textToDecode) {
		String decoded = "";
		
		String[] words = textToDecode.split(" ");
		
		for(String word : words) {
			decoded += morseToChar.get(word);
		}
		
		return decoded;
		
	}

	@Override
	public boolean encodeFileToFile(String plainTextFileName, String encodedTextFileName) {
		List<String> text = FileUtility.readFile(plainTextFileName);
		
		text.set(0, encodeText(text.get(0)));
		
		FileUtility.writeToFile(encodedTextFileName, text);
		
		return true;
	}

	@Override
	public boolean decodeFileToFile(String encodedTextFileName, String plainTextFileName) {
		List<String> text = FileUtility.readFile(encodedTextFileName);
		
		text.set(0, decodeText(text.get(0)));
		
		FileUtility.writeToFile(plainTextFileName, text);
		
		return true;
	}

}
