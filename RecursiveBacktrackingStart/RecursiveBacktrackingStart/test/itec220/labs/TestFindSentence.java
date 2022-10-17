package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestFindSentence {

	private static final String FILE_INPUT_PATH = "resources/files/input/";
	@Test
	void validSentence() {
		SentenceFinder sf = new SentenceFinder(FILE_INPUT_PATH + "testWords.txt");
		String result = sf.findSentence("ismysailonfire");
		
		assertEquals("is my sail on fire", result);
	}

}
