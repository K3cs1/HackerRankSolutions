package com.morganstanley.rolingstrings2;

import java.util.List;

public class RotateTextClient {

	private static int startIndex;
	private static int endIndex;
	private static final char LEFT_CHAR = 'L';

	public static String rolingStrings( String inputString, List<String> operations ) {
		char[] inputStringChars = inputString.toCharArray();
		for ( String operation : operations ) {
			boolean isLeft = isRotateDirectionLeft( operation );
			InputText inputText = new InputText( inputStringChars, startIndex, endIndex );
			TextFileOperationExecutor executor = new TextFileOperationExecutor();
			inputStringChars = isLeft ? executor.executeOperation( inputText::rotateLeft ) : executor.executeOperation( inputText::rotateRight );
		}
		return new String( inputStringChars );
	}

	private static boolean isRotateDirectionLeft( String operation ) {
		String[] operationArr = operation.split( " " );
		startIndex = Integer.valueOf( operationArr[ 0 ] );
		endIndex = Integer.valueOf( operationArr[ 1 ] );
		char rotateDirection = operationArr[ 2 ].toCharArray()[ 0 ];
		return LEFT_CHAR == rotateDirection;
	}

}
