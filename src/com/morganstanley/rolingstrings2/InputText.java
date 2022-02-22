package com.morganstanley.rolingstrings2;

public class InputText {

	private char[] inputChars;
	private int startIndex;
	private int endIndex;

	public InputText( char[] inputChars, int startIndex, int endIndex ) {
		this.inputChars = inputChars;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public char[] rotateLeft() {
		StringBuilder result = new StringBuilder();
		char[] theAlphabet = AlphabetGeneratorUtil.getAlphabet();
		if ( startIndex != 0 ) {
			for ( int index = 0; index < startIndex; index++ ) {
				result.append( inputChars[ index ] );
			}
		}
		for ( int index = startIndex; index <= endIndex; index++ ) {
			char theChar = inputChars[ index ];
			int originalAlphabetPosition = theChar - 'a';
			char newChar;
			if ( originalAlphabetPosition == 0 ) {
				newChar = theAlphabet[ theAlphabet.length - (originalAlphabetPosition + 1) ];
			} else {
				newChar = theAlphabet[ originalAlphabetPosition - 1 ];
			}
			result.append( newChar );
		}
		if ( endIndex != inputChars.length - 1 ) {
			for ( int index = endIndex + 1; index < inputChars.length; index++ ) {
				result.append( inputChars[ index ] );
			}
		}
		return result.toString().toCharArray();
	}

	public char[] rotateRight() {
		StringBuilder result = new StringBuilder();
		char[] theAlphabet = AlphabetGeneratorUtil.getAlphabet();
		if ( startIndex != 0 ) {
			for ( int index = 0; index < startIndex; index++ ) {
				result.append( inputChars[ index ] );
			}
		}
		for ( int index = startIndex; index <= endIndex; index++ ) {
			char theChar = inputChars[ index ];
			int originalAlphabetPosition = theChar - 'a';
			char newChar;
			if ( originalAlphabetPosition != theAlphabet.length - 1 ) {
				newChar = theAlphabet[ originalAlphabetPosition + 1 ];
			} else {
				newChar = theAlphabet[ 0 ];
			}
			result.append( newChar );
		}
		if ( endIndex != inputChars.length - 1 ) {
			for ( int index = endIndex + 1; index < inputChars.length; index++ ) {
				result.append( inputChars[ index ] );
			}
		}
		return result.toString().toCharArray();
	}

}
