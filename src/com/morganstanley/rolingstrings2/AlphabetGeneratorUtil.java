package com.morganstanley.rolingstrings2;

public class AlphabetGeneratorUtil {
	public static char[] getAlphabet() {
		StringBuilder result = new StringBuilder();
		for ( char character = 'a'; character <= 'z'; character++ ) {
			result.append( character );
		}
		return result.toString().toCharArray();
	}
}
