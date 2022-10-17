package itec220.labs;
/**
 * 
 */


/**
 * @author Robert Ward
 *
 */
public interface Converter {

	
	//public Converter(String encodingfile); << good idea
	/**
	 * Prints a list of the key values pairs used to encode and decode strings.
	 * 
	 */
	public void printKeyValuePairs();
	
	/**
	 * Encodes a text based on the Key Value Pairs.
	 * For Example if the encode file contained 
	 *  the letter 'a' would be replaced with .- wherever it was in the string  
	 *  Each Morse code letter is separated by a space.
	 *  For example "computer" would be converted to:
	 *  -.-. --- -- .--. ..- - . .-. 
	 * @param  textToEncode the String to encode
     * @return returns the encoded version of the text
	 */
	public String encodeText(String textToEncode);
	
	
	
	/**
	 * Decodes a sentence based on the Key Value Pairs.
	 * For Example if the encoded string contained Morse code 
	 *  -.-. --- -- .--. ..- - . .-.
	 *  it would be converted to "computer"  
	 * @param  textToDecode the String to decode
     * @return returns the decoded version of the text
     */
	public String decodeText(String textToDecode);
	
	
	
	/**
	 * Encodes a the text contained by the file of the given filename based on the Key Value Pairs.
	 * Saves the result to a new file the will contain the Morse code version of the text.
	 * version of the text.  
	 * @param  plainTextFileName the name of the file whose contents we want encode and save
	 * @param  encodedTextFileName name of the file to save the encoded text in
     * @return returns true if the file is encoded and saved successfully
	 */
	public boolean encodeFileToFile(String plainTextFileName, String encodedTextFileName );
	
	/**
	 * Decodes the text contained in the given filename based on the Key Value Pairs.
	 * Saves the result to a new file the will contain the plain text version of the Morse code. 
	 * version of the text.  
	 * @param  encodedTextFileName name of the file whose contents we want to decode and save
	 * @param  plainTextFileName the name of the file where we want to save the decode text.
     * @return returns true if the file is encoded and saved successfully
	 */
	public boolean decodeFileToFile( String encodedTextFileName, String plainTextFileName);
	
}
