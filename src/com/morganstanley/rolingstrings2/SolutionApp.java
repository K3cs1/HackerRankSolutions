package com.morganstanley.rolingstrings2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolutionApp {

	public static void main( String[] args ) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
//		BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( "./ms_8_rolling_strings.txt" ) ); // System.getenv("OUTPUT_PATH")
//		String inputString = bufferedReader.readLine();
//		int operationsCount = Integer.parseInt( bufferedReader.readLine().trim() );
//		List<String> operations = IntStream.range( 0, operationsCount ).mapToObj( i -> {
//			try {
//				return bufferedReader.readLine();
//			} catch ( IOException ex ) {
//				throw new RuntimeException( ex );
//			}
//		} ).collect( Collectors.toList() );
//		String result = RotateTextCommandExecutor.rolingStrings( inputString, operations );
//		bufferedWriter.write( result );
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();

//		System.out.println( result );

		String inputString = "abc";
		List<String> operations = new ArrayList<>();
		//Test case #1
		operations.add( "0 0 L" ); // zbc
		operations.add( "2 2 L" ); // zbb
		operations.add( "0 2 R" ); // acc

		// Test case #2
//		operations.add( "0 0 R" ); // bbc
//		operations.add( "2 2 R" ); // bbd
//		operations.add( "0 2 L" ); // aac

		String result = RotateTextClient.rolingStrings( inputString, operations );
		System.out.println( result );
	}
}
