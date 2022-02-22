package datastructures.subarray;

import java.util.Scanner;

public class Solution {

	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int arrLength = scanner.nextInt();
		int[] numArrays = new int[ arrLength ];
		for ( int i = 0; i < arrLength; i++ ) {
			numArrays[ i ] = Integer.valueOf( scanner.nextInt() );
		}
		scanner.close();

		int numNegativeSubarrays = 0;

		for ( int i = 0; i < arrLength; i++ ) {
			for ( int j = i; j < arrLength; j++ ) {

				int sum = 0;

				for ( int k = i; k <= j; k++ ) {
					sum += numArrays[ k ];
				}

				if ( sum < 0 ) {
					numNegativeSubarrays++;
				}
			}
		}

		System.out.println( numNegativeSubarrays );
	}

}
