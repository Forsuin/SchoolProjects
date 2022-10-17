package itec220.labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Word> words = readWords("words.txt");
		
		writeFile(words, "outputWords.txt");
		
		ArrayList<Word> newWords = readFile("outputWords.txt");
		
		System.out.format("Original words and processed words are %s\n", (wordsEqual(words, newWords)) ? "equal" : "not equal");
		
	}

	public static boolean wordsEqual(ArrayList<Word> lhs, ArrayList<Word> rhs) {
		if(lhs.size() != rhs.size()) return false;
		
		for(int i = 0; i < lhs.size(); i++) {
			if((lhs.get(i).compareTo(rhs.get(i))) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public static ArrayList<Word> readFile(String path){
		
		ArrayList<Word> words = new ArrayList<Word>();
		
		try {
			FileInputStream file = new FileInputStream(new File(path));
			ObjectInputStream input = new ObjectInputStream(file);
			
			int num = input.readInt();
			
			for(int i = 0; i < num; i++) {
				words.add((Word)input.readObject());
			}
			
			input.close();
			file.close();
		}
		catch(IOException e) {
			System.err.println("Problem initializing input stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return words;
	}
	
	
	public static void writeFile(ArrayList<Word> words, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(new File(fileName));
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			output.writeInt(words.size());
			
			for(Word word : words) {
				output.writeObject(word);
			}
			
			output.close();
			file.close();
		}
		catch(IOException e){
			System.err.format("Could not write to file %s\n%s", fileName, e);
		}
	}
	
	
	public static ArrayList<Word> readWords(String path){
		ArrayList<Word> words = new ArrayList<Word>();
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			
			String line;
			
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				
				String[] fields = line.split(",");
				
				words.add(new Word(fields[0], WordType.valueOf(fields[1].toUpperCase()), fields[2]));
			}
			
		}
		catch(IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		
		return words;
	}
}
