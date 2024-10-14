/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: CryptoManager
 * Due: 10/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Student Name here: Ya-Wen Cheng
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i=0; i<plainText.length();i++) {
			if (plainText.charAt(i)< 32 || plainText.charAt(i)>95)
				return false;
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (isStringInBounds(plainText) == false){
			return "The selected string is not in bounds. Try again.";
		}
		String str = "";
		int add;
		for (int i=0; i<plainText.length();i++) {
			add = plainText.charAt(i)+key;
			while (add > 95) {
				add -= 64;
			}
			str = str+String.valueOf((char)(add));
		}
		return str;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//form a string filled with bellasoStr
		int n = plainText.length()/bellasoStr.length();
		int remainder = plainText.length()%bellasoStr.length();
		String str = "";
		for (int i=1; i<=n; i++) {
			str = str+bellasoStr;
		}
		str = str+bellasoStr.substring(0, remainder);
		
		String new_str = "";
		int add;
		for (int i=0; i<plainText.length(); i++) {
			add = str.charAt(i)+plainText.charAt(i);
			while (add > 95) {
				add -= 64;
			}
			new_str = new_str+String.valueOf((char)add);
		}
		return new_str;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String str = "";
		int n;
		for (int i=0; i<encryptedText.length();i++) {
			n = encryptedText.charAt(i)-key;
			while (n<32) {
				n+=64;
			}
			
			str = str+String.valueOf((char)n);
		}
		return str;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//form a string filled with bellasoStr
		int n = encryptedText.length()/bellasoStr.length();
		int remainder = encryptedText.length()%bellasoStr.length();
		String str = "";
		for (int i=1; i<=n; i++) {
			str = str+bellasoStr;
		}
		str = str+bellasoStr.substring(0, remainder);
		
		String new_str = "";
		for (int i=0; i<encryptedText.length();i++) {
			int value = encryptedText.charAt(i)-str.charAt(i);
			while (value<32) {
				value+=64;
			}
			new_str = new_str+String.valueOf((char)value);
		}
		return new_str;
		
			
	}
}
