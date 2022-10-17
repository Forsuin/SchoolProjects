package itec220.labs;

import java.io.Serializable;

public class Word implements Serializable {

	private static final long serialVersionUID = 1L;

	private String word;
	private String definition;
	private WordType type;
	
	
	Word(String word, WordType type, String definition){
		this.word = word;
		this.definition = definition;
		this.type = type;
	}

	public boolean compareTo(Word other) {
		return (this.word.equals(other.word) && this.definition.equals(other.definition) && this.type == other.type);
	}
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s", word, type, definition);
	}
	

	public String prettyPrint() {
		return String.format("%s, %s - %s", word, type, definition);
	}
	
}
