package com.morganstanley.rolingstrings;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

	public static final char LEFT_CHAR = 'L';

	public static String rollingString( String s, List<String> operations ) {
		char[] inputStringChars = s.toCharArray();
		for ( String operation : operations ) {
			String[] operationArr = operation.split( " " );
			int startIndex = Integer.valueOf( operationArr[ 0 ] );
			int endIndex = Integer.valueOf( operationArr[ 1 ] );
			char rotateDirection = operationArr[ 2 ].toCharArray()[ 0 ];
			if ( LEFT_CHAR == rotateDirection ) {
				inputStringChars = processRotateLeftCommand( inputStringChars, startIndex, endIndex );
			} else {
				inputStringChars = processRotateRightCommand( inputStringChars, startIndex, endIndex );
			}
		}
		return new String( inputStringChars );
	}

	private static char[] getAlphabet() {
		StringBuilder result = new StringBuilder();
		for ( char character = 'a'; character <= 'z'; character++ ) {
			result.append( character );
		}
		return result.toString().toCharArray();
	}

	private static char[] processRotateRightCommand( char[] inputStringChars, int startIndex, int endIndex ) {
		StringBuilder result = new StringBuilder();
		char[] theAlphabet = getAlphabet();
		if ( startIndex != 0 ) {
			for ( int index = 0; index < startIndex; index++ ) {
				result.append( inputStringChars[ index ] );
			}
		}
		for ( int index = startIndex; index <= endIndex; index++ ) {
			char theChar = inputStringChars[ index ];
			int originalAlphabetPosition = theChar - 'a';
			char newChar;
			if ( originalAlphabetPosition != theAlphabet.length - 1 ) {
				newChar = theAlphabet[ originalAlphabetPosition + 1 ];
			} else {
				newChar = theAlphabet[ 0 ];
			}
			result.append( newChar );
		}
		if ( endIndex != inputStringChars.length - 1 ) {
			for ( int index = endIndex + 1; index < inputStringChars.length; index++ ) {
				result.append( inputStringChars[ index ] );
			}
		}
		return result.toString().toCharArray();
	}

	private static char[] processRotateLeftCommand( char[] inputStringChars, int startIndex, int endIndex ) {
		StringBuilder result = new StringBuilder();
		char[] theAlphabet = getAlphabet();
		if ( startIndex != 0 ) {
			for ( int index = 0; index < startIndex; index++ ) {
				result.append( inputStringChars[ index ] );
			}
		}
		for ( int index = startIndex; index <= endIndex; index++ ) {
			char theChar = inputStringChars[ index ];
			int originalAlphabetPosition = theChar - 'a';
			char newChar;
			if ( originalAlphabetPosition == 0 ) {
				newChar = theAlphabet[ theAlphabet.length - (originalAlphabetPosition + 1) ];
			} else {
				newChar = theAlphabet[ originalAlphabetPosition - 1 ];
			}
			result.append( newChar );
		}
		if ( endIndex != inputStringChars.length - 1 ) {
			for ( int index = endIndex + 1; index < inputStringChars.length; index++ ) {
				result.append( inputStringChars[ index ] );
			}
		}
		return result.toString().toCharArray();
	}
}

public class Solutions {
	public static void main( String[] args ) throws IOException {
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( "./ms_8_rolling_strings.txt" ) ); // System.getenv("OUTPUT_PATH")
		String s = bufferedReader.readLine();
		int operationsCount = Integer.parseInt( bufferedReader.readLine().trim() );
		List<String> operations = IntStream.range( 0, operationsCount ).mapToObj( i -> {
			try {
				return bufferedReader.readLine();
			} catch ( IOException ex ) {
				throw new RuntimeException( ex );
			}
		} ).collect( Collectors.toList() );
		String result = Result.rollingString( s, operations );
		bufferedWriter.write( result );
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

//		System.out.println( result );

//		String s = "abc";
//		List<String> operations = new ArrayList<>();
		// Test case #1
//		operations.add( "0 0 L" ); // zbc
//		operations.add( "2 2 L" ); // zbb
//		operations.add( "0 2 R" ); // acc

		// Test case #2
//		operations.add( "0 0 R" ); // bbc
//		operations.add( "2 2 R" ); // bbd
//		operations.add( "0 2 L" ); // aac

//		String result = Result.rollingString( s, operations );

	}
}
