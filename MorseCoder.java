package programming.set9.morse;
import java.util.Arrays;
import java.lang.Character;

import acm.program.*;

public class MorseCoder extends ConsoleProgram {
	
	private static final String[] latinCharacters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };
    private static final String[] morseCharacters = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };
	
	public void run() {
		System.out.println(encode("SOS! SOS!"));
		System.out.println(decode("-.-.-.-"));
	}
	
	/**
	 * Returns a new string which is the morse code version of the input string.
	 * Each word is on a separate line. The morse representation of each
	 * character of the input string is separated from the next by a space
	 * character in the output string.
	 * 
	 * @param input
	 *            the input string.
	 * @return the morse code version of the input string, ignoring all
	 *         characters in the input string that cannot be represented in
	 *         international morse code.
	 */
	public static String encode(String input) {
		String output = "";
		String [] words = input.split("[ \\n]+");
				
		for(int i = 0; i < words.length; i++){
			String[] chars = words[i].split("(?!^)");
//			System.out.println(Arrays.toString(chars));
//			System.out.println("i");
			for(int j = 0; j < chars.length; j++){
				if(Character.isUpperCase(chars[j].charAt(0))){
					chars[j] = chars[j].toLowerCase();
				}
//				System.out.println("j");
				for(int k = 0; k < latinCharacters.length; k++){
//					System.out.println("k");
					if(chars[j].equals(latinCharacters[k])){
						output += morseCharacters[k] + " ";
					}
					
				}
			}
			output += "\n";
		}
	   return output;
	}
	
	
	
	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in morse code format as produced by the
	 * encode method.
	 * 
	 * @param input
	 *            morse code input string.
	 * @return natural language version or {@code null} if the input string
	 *         could not be properly parsed.
	 */
	public static String decode(String input) {
		String output = "";
		String [] wordsOrLines = input.split("\\n");
		System.out.println(Arrays.toString(wordsOrLines));
		
		for(int i = 0; i < wordsOrLines.length; i++){
			String[] chars = wordsOrLines[i].split("[ \\n]+");
			System.out.println(Arrays.toString(chars));
			for(int j = 0; j < chars.length; j++){
				for(int k = 0; k < morseCharacters.length; k++){
					if(chars[j].equals(morseCharacters[k])){
						output += latinCharacters[k];
					} 
				}
			}
			
			if(output.isEmpty()){
				return null;
			} else {	
				output += " ";
			}
		}
		return output;   
	}
	
}
