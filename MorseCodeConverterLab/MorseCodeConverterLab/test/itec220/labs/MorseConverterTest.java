package itec220.labs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;



class MorseConverterTest {

	private static MorseConverter mc = new MorseConverter("resources/files/input/MorseCodeTable.txt");
	
	@Test
	void testConvertSentenceToMorse() {
		
		
		assertEquals("- .... . ------ --.- ..- .. -.-. -.- ------ -... .-. --- .-- -. ------ ..-. --- -..-", mc.encodeText("The quick Brown fox"));
		
	}
	
	@Test
	void testConvertMorseToSentence() {
		
		
		assertEquals("the quick brown fox ", mc.decodeText("- .... . ------ --.- ..- .. -.-. -.- ------ -... .-. --- .-- -. ------ ..-. --- -..- ------"));
		
	}
	@Test
	void testConvertSentenceToMorseAlpha() {
		
		
		assertEquals("abc defg hijkl mnopq rst uvwxyz", mc.decodeText(".- -... -.-. ------ -.. . ..-. --. ------ .... .. .--- -.- .-.. ------ -- -. --- .--. --.- ------ .-. ... - ------ ..- ...- .-- -..- -.-- --.."));
		
	}
	@Test
	void testConvertLetterToMorse() {
		
		assertAll(() -> assertEquals(".-", mc.encodeText("a")),
				  () -> assertEquals("-...", mc.encodeText("b")),
				  () -> assertEquals("-.-.", mc.encodeText("c")),
				  () -> assertEquals("-..", mc.encodeText("d")),
				  () -> assertEquals(".", mc.encodeText("e")),
				  () -> assertEquals("..-.", mc.encodeText("f")),
				  () -> assertEquals("--.", mc.encodeText("g")),
				  () -> assertEquals("....", mc.encodeText("h")),
				  () -> assertEquals("..", mc.encodeText("i")),
				  () -> assertEquals(".---", mc.encodeText("j")),
				  () -> assertEquals("-.-", mc.encodeText("k")),
				  () -> assertEquals(".-..", mc.encodeText("l")),
				  () -> assertEquals("--", mc.encodeText("m")),
				  () -> assertEquals("-.", mc.encodeText("n")),
				  () -> assertEquals("---", mc.encodeText("o")),
				  () -> assertEquals(".--.", mc.encodeText("p")),
				  () -> assertEquals("--.-", mc.encodeText("q")),
				  () -> assertEquals(".-.", mc.encodeText("r")),
				  () -> assertEquals("...", mc.encodeText("s")),
				  () -> assertEquals("-", mc.encodeText("t")),
				  () -> assertEquals("..-", mc.encodeText("u")),
				  () -> assertEquals("...-", mc.encodeText("v")),
				  () -> assertEquals(".--", mc.encodeText("w")),
				  () -> assertEquals("-..-", mc.encodeText("x")),
				  () -> assertEquals("-.--", mc.encodeText("y")),
				  () -> assertEquals("--..", mc.encodeText("z"))
				 
				  
				);
		
	}
	
	@Test
	void testConvertLetterCapToMorse() {
		
		assertAll(() -> assertEquals(".-", mc.encodeText("A")),
				  () -> assertEquals("-...", mc.encodeText("B")),
				  () -> assertEquals("-.-.", mc.encodeText("C")),
				  () -> assertEquals("-..", mc.encodeText("D")),
				  () -> assertEquals(".", mc.encodeText("E")),
				  () -> assertEquals("..-.", mc.encodeText("F")),
				  () -> assertEquals("--.", mc.encodeText("G")),
				  () -> assertEquals("....", mc.encodeText("H")),
				  () -> assertEquals("..", mc.encodeText("I")),
				  () -> assertEquals(".---", mc.encodeText("J")),
				  () -> assertEquals("-.-", mc.encodeText("K")),
				  () -> assertEquals(".-..", mc.encodeText("L")),
				  () -> assertEquals("--", mc.encodeText("M")),
				  () -> assertEquals("-.", mc.encodeText("N")),
				  () -> assertEquals("---", mc.encodeText("O")),
				  () -> assertEquals(".--.", mc.encodeText("P")),
				  () -> assertEquals("--.-", mc.encodeText("Q")),
				  () -> assertEquals(".-.", mc.encodeText("R")),
				  () -> assertEquals("...", mc.encodeText("S")),
				  () -> assertEquals("-", mc.encodeText("T")),
				  () -> assertEquals("..-", mc.encodeText("U")),
				  () -> assertEquals("...-", mc.encodeText("V")),
				  () -> assertEquals(".--", mc.encodeText("W")),
				  () -> assertEquals("-..-", mc.encodeText("X")),
				  () -> assertEquals("-.--", mc.encodeText("Y")),
				  () -> assertEquals("--..", mc.encodeText("Z"))
				 
				  
				);
		
	}
	
	@Test
	void testConvertMorseToLetter() {
		
		assertAll(() -> assertEquals("a", mc.decodeText(".-")),
				  () -> assertEquals("b", mc.decodeText("-...")),
				  () -> assertEquals("c", mc.decodeText("-.-.")),
				  () -> assertEquals("d", mc.decodeText("-..")),
				  () -> assertEquals("e", mc.decodeText(".")),
				  () -> assertEquals("f", mc.decodeText("..-.")),
				  () -> assertEquals("g", mc.decodeText("--.")),
				  () -> assertEquals("h", mc.decodeText("....")),
				  () -> assertEquals("i", mc.decodeText("..")),
				  () -> assertEquals("j", mc.decodeText(".---")),
				  () -> assertEquals("k", mc.decodeText("-.-")),
				  () -> assertEquals("l", mc.decodeText(".-..")),
				  () -> assertEquals("m", mc.decodeText("--")),
				  () -> assertEquals("n", mc.decodeText("-.")),
				  () -> assertEquals("o", mc.decodeText("---")),
				  () -> assertEquals("p", mc.decodeText(".--.")),
				  () -> assertEquals("q", mc.decodeText("--.-")),
				  () -> assertEquals("r", mc.decodeText(".-.")),
				  () -> assertEquals("s", mc.decodeText("...")),
				  () -> assertEquals("t", mc.decodeText("-")),
				  () -> assertEquals("u", mc.decodeText("..-")),
				  () -> assertEquals("v", mc.decodeText("...-")),
				  () -> assertEquals("w", mc.decodeText(".--")),
				  () -> assertEquals("x", mc.decodeText("-..-")),
				  () -> assertEquals("y", mc.decodeText("-.--")),
				  () -> assertEquals("z", mc.decodeText("--.."))
				 
				  
				);
		
	} 

	@Test
	void testConvertMorseTopunctuationLetter() {
	
		assertAll(() -> assertEquals(".", mc.decodeText(".-.-.-")),
				  () -> assertEquals(",", mc.decodeText("--..--")),
				  () -> assertEquals("?", mc.decodeText("..--..")),
				  () -> assertEquals(":", mc.decodeText("---...")),
				  () -> assertEquals("'", mc.decodeText(".----.")),
				  () -> assertEquals(" ", mc.decodeText("------"))
				 
				  
				);
	}
		@Test
		void testConvertMorseToNumbers() {
		
			assertAll(() -> assertEquals("0", mc.decodeText("-----")),
					  () -> assertEquals("1", mc.decodeText(".----")),
					  () -> assertEquals("2", mc.decodeText("..---")),
					  () -> assertEquals("3", mc.decodeText("...--")),
					  () -> assertEquals("4", mc.decodeText("....-")),
					  () -> assertEquals("5", mc.decodeText(".....")),
					  () -> assertEquals("6", mc.decodeText("-....")),
					  () -> assertEquals("7", mc.decodeText("--...")),
					  () -> assertEquals("8", mc.decodeText("---..")),
					  () -> assertEquals("9", mc.decodeText("----.")) 
					 
					  
					);
		
	}


}
