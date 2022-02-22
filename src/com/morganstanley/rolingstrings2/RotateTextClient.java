package com.morganstanley.rolingstrings2;

import java.util.List;

public class RotateTextClient {

	public static final char LEFT_CHAR = 'L';

	public static String rolingStrings( String inputString, List<String> operations ) {
		char[] inputStringChars = inputString.toCharArray();
		for ( String operation : operations ) {
			String[] operationArr = operation.split( " " );
			int startIndex = Integer.valueOf( operationArr[ 0 ] );
			int endIndex = Integer.valueOf( operationArr[ 1 ] );
			char rotateDirection = operationArr[ 2 ].toCharArray()[ 0 ];
			InputText inputText = new InputText( inputStringChars, startIndex, endIndex );
			TextFileOperationExecutor executor = new TextFileOperationExecutor();
			if ( LEFT_CHAR == rotateDirection ) {
				inputStringChars = executor.executeOperation( inputText::rotateLeft );
			} else {
				inputStringChars = executor.executeOperation( inputText::rotateRight );

			}
		}
		return new String( inputStringChars );
	}

}
